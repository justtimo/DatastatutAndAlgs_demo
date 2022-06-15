package com.example.datastruct.ch6tree.ch3threadedBinaryTree;


/**
 * 线索二叉树.
 *
 * 重点:
 *  1. 线索化: 设置后继时 是在下一轮中设置. pre=node 使 pre 指针移动
 *  2. 遍历: 线性遍历:  找到没有左子树节点--->右节点 type=1 输出 ; 否则node向右移动
 *
 * @author wubingyin
 * @date 2022/02/17
 */
public class ThreadedBinaryTree {
    private Node root;
    //线索化使用
    private Node pre =null;

    public ThreadedBinaryTree(Node root) {
        this.root = root;
    }

    //线索化
    public void threadMiddle(Node node){
        if (node==null){
            return;
        }
        //1. 线索化左子树
        threadMiddle(node.getLeft());
        //2. 线索化当前节点
        //处理前驱: 以 8 为例, 前驱为 null,因为 pre 并没有动过
        if (node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继: 其实是在下一次处理时执行"设置后继" . 以 8 为例, 8 的下一次处理是 3, 此时 pre=8, node=3.
        if (pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        //让当前节点 是 下一个节点 的前驱
        pre=node;
        //3. 线索化右子树
        threadMiddle(node.getRight());
    }

    //线索化中序遍历: 因为节点指向已经变化, 所以原来的方式不再可用. 通过线性方式遍历,无需使用递归 . 区别在于 type 的类型
    public void threadList(){
        Node node = root;
        while (node!=null){
            //向左: 直到找到没有子树的节点
            while (node.getLeftType()==0){
                node=node.getLeft();
            }
            System.out.println(node);
            //如果当前右指针是后继,就一直输出
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }
            //例如此时是 3: 那么就用 3 的 right 10 替换 3 这个节点
            node=node.getRight();
        }

    }

    //前序遍历
    public void preList(){
        if (this.root!=null){
            this.root.preList();
        }else {
            System.out.println("null");
        }
    }
    //中序遍历
    public void midList(){
        if (this.root!=null){
            this.root.midList();
        }else {
            System.out.println("null");
        }
    }
    //后序遍历
    public void behandList(){
        if (this.root!=null){
            this.root.behandList();
        }else {
            System.out.println("null");
        }
    }

    public Node preFind(int number){
        if (root!=null){
            return this.root.preFind(number);
        }else {
            return null;
        }
    }
    public Node midFind(int number){
        if (root!=null){
            return this.root.middleFind(number);
        }else {
            return null;
        }
    }
    public Node behandFind(int number){
        if (root!=null){
            return this.root.behandFind(number);
        }else {
            return null;
        }
    }

    public void delete(int number){
        if (root!=null){
            if (root.getNumber()==number){
                root=null;
            }else {
                root.delete(number);
            }
        }else {
            System.out.println("root is null");
        }
    }
}
class Test{
    public static void main(String[] args) {
        Node root = new Node(1, "uzi");
        Node node2 = new Node(3, "rookei");
        Node node3 = new Node(6, "theshy");
        Node node4 = new Node(8, "koobe");
        Node node5 = new Node(10, "james");
        Node node6 = new Node(14, "boolan");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(root);
        threadedBinaryTree.threadMiddle(root);

        threadedBinaryTree.threadList();
    }
}