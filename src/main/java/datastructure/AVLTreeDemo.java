package datastructure;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {10,11,7,6,8,9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node80(arr[i]));
        }
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());
    }
}

class AVLTree{
    private Node80 root;

    public Node80 getRoot() {
        return root;
    }

    public Node80 search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public int delRightTreeMin(Node80 node90) {
        Node80 target = node90;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public Node80 searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node80 targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node80 parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                }
                if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                int min = delRightTreeMin(targetNode.right);
                targetNode.value = min;
            } else {
                if (targetNode.left != null) {
                    if (parent!=null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }

        }
    }

    public void add(Node80 node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("null");
        }
    }
}

class Node80 {
    int value;
    Node80 left;
    Node80 right;

    public Node80(int value) {
        this.value = value;
    }

    public int leftHeight(){
        if(left==null){
            return 0;
        }
        return left.height();
    }

    public int rightHeight(){
        if(right==null){
            return 0;
        }
        return right.height();
    }

    private void leftRotate(){
        Node80 newNode = new Node80(value);
        newNode.left=left;
        newNode.right = right.left;
        value=right.value;
        right = right.right;
        left = newNode;
    }

    private void rightRotate(){
        Node80 newNode = new Node80(value);
        newNode.right=right;
        newNode.left = left.right;
        value=left.value;
        left = left.left;
        right = newNode;
    }

    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
    }

    public Node80 search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    public Node80 searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    public void add(Node80 node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        if(rightHeight()-leftHeight()>1){
            if(right!=null&&right.leftHeight()>right.rightHeight()){
                right.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }
        if(leftHeight()-rightHeight()>1){
            if(left!=null&&left.rightHeight()>left.leftHeight()){
                left.leftRotate();
                rightRotate();
            }else {
                rightRotate();
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node80{" +
                "value=" + value +
                '}';
    }
}