package datastructure;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode99 node1 = new HeroNode99(1, "宋江");
        HeroNode99 node2 = new HeroNode99(2, "卢俊义");
        HeroNode99 node3 = new HeroNode99(3, "吴用");
        HeroNode99 node4 = new HeroNode99(4, "公孙胜");
        HeroNode99 node5 = new HeroNode99(5, "关胜");
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(node1);
        binaryTree.preOrder();
        binaryTree.infixOrder();
        binaryTree.postOrder();
        System.out.println(binaryTree.preOrderSearch(5));
        System.out.println(binaryTree.infixOrderSearch(5));
        System.out.println(binaryTree.postOrderSearch(5));
        binaryTree.delNode(3);
        binaryTree.preOrder();
    }
}

class BinaryTree{
    private HeroNode99 root;

    public void setRoot(HeroNode99 root) {
        this.root = root;
    }

    public void delNode(int no){
        if(this.root !=null){
            if(root.getNo()==no){
                root = null;
            }else {
                this.root.delNode(no);
            }

        }else {
            System.out.println("null");
        }
    }

    public void preOrder(){
        if(this.root !=null){
            this.root.preOrder();
        }else {
            System.out.println("null");
        }
    }

    public void infixOrder(){
        if(this.root !=null){
            this.root.infixOrder();
        }else {
            System.out.println("null");
        }
    }

    public void postOrder(){
        if(this.root !=null){
            this.root.postOrder();
        }else {
            System.out.println("null");
        }
    }

    public HeroNode99 preOrderSearch(int no){
        if(this.root !=null){
            return this.root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    public HeroNode99 infixOrderSearch(int no){
        if(this.root !=null){
            return this.root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    public HeroNode99 postOrderSearch(int no){
        if(this.root !=null){
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}

class HeroNode99{
    private int no;
    private String name;
    private HeroNode99 left;
    private HeroNode99 right;

    public HeroNode99(int no, String name) {
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

    public HeroNode99 getLeft() {
        return left;
    }

    public void setLeft(HeroNode99 left) {
        this.left = left;
    }

    public HeroNode99 getRight() {
        return right;
    }

    public void setRight(HeroNode99 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode99{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void delNode(int no){
        if(this.left !=null && this.left.no == no){
            this.left = null;
            return;
        }
        if(this.right !=null && this.right.no == no){
            this.right = null;
            return;
        }
        if(this.left !=null){
            this.left.delNode(no);
        }
        if(this.right !=null){
            this.right.delNode(no);
        }

    }

    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode99 preOrderSearch(int no){
        if(this.no == no){
            return this;
        }
        HeroNode99 resNode = null;
        if(this.left !=null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right !=null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode99 infixOrderSearch(int no){
        HeroNode99 resNode = null;
        if(this.left !=null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.no == no){
            return this;
        }
        if(this.right !=null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode99 postOrderSearch(int no){
        HeroNode99 resNode = null;
        if(this.left !=null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right !=null){
            resNode = this.right.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.no == no){
            return this;
        }
        return resNode;
    }
}
