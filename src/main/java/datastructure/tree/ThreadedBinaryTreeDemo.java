package datastructure.tree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode98 node1 = new HeroNode98(1, "宋江");
        HeroNode98 node2 = new HeroNode98(3, "卢俊义");
        HeroNode98 node3 = new HeroNode98(6, "吴用");
        HeroNode98 node4 = new HeroNode98(8, "公孙胜");
        HeroNode98 node5 = new HeroNode98(10, "关胜");
        HeroNode98 node6 = new HeroNode98(14, "林冲");
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(node1);
        threadedBinaryTree.threadNodes(node1);
        System.out.println(node5.getLeft());
        System.out.println(node5.getRight());
        threadedBinaryTree.threadList();
    }
}

class ThreadedBinaryTree {
    private HeroNode98 root;

    private HeroNode98 pre = null;

    public void setRoot(HeroNode98 root) {
        this.root = root;
    }

    public void threadList(){
        HeroNode98 node = root;
        while (node !=null){
            while (node.getLeftType()==0){
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType()==1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    public void threadNodes(HeroNode98 node) {
        if (node == null) {
            return;
        }
        threadNodes(node.getLeft());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        threadNodes(node.getRight());

    }

    public void delNode(int no) {
        if (this.root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                this.root.delNode(no);
            }

        } else {
            System.out.println("null");
        }
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("null");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("null");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("null");
        }
    }

    public HeroNode98 preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode98 infixOrderSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode98 postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}

class HeroNode98 {
    private int no;
    private String name;
    private HeroNode98 left;
    private HeroNode98 right;

    //0:左子树，1前驱节点
    private int leftType;
    //0:右子树，1后驱节点
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode98(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode98 getLeft() {
        return left;
    }

    public void setLeft(HeroNode98 left) {
        this.left = left;
    }

    public HeroNode98 getRight() {
        return right;
    }

    public void setRight(HeroNode98 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode98{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }

    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
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

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode98 preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode98 resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode98 infixOrderSearch(int no) {
        HeroNode98 resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode98 postOrderSearch(int no) {
        HeroNode98 resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}
