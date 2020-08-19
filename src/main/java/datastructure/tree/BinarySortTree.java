package datastructure.tree;

public class BinarySortTree {
    public static void main(String[] args) {
        int arr[] = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySort binarySort = new BinarySort();
        for (int i = 0; i < arr.length; i++) {
            binarySort.add(new Node90(arr[i]));
        }
        binarySort.infixOrder();
        binarySort.delNode(2);
        binarySort.delNode(5);
        binarySort.delNode(9);
        binarySort.delNode(12);
        binarySort.delNode(7);
        binarySort.delNode(3);
//        binarySort.delNode(10);
//        binarySort.delNode(1);
        binarySort.infixOrder();

    }
}

class BinarySort {
    private Node90 root;

    public Node90 getRoot() {
        return root;
    }

    public Node90 search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public int delRightTreeMin(Node90 node90) {
        Node90 target = node90;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public Node90 searchParent(int value) {
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
            Node90 targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node90 parent = searchParent(value);
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

    public void add(Node90 node) {
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


class Node90 {
    int value;
    Node90 left;
    Node90 right;

    public Node90(int value) {
        this.value = value;
    }

    public Node90 search(int value) {
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

    public Node90 searchParent(int value) {
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

    public void add(Node90 node) {
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
        return "Node90{" +
                "value=" + value +
                '}';
    }
}