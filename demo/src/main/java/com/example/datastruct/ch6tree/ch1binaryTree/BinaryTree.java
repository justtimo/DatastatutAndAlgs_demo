package com.example.datastruct.ch6tree.ch1binaryTree;


/**
 * 树: 提高了存储,读取的效率 ; 二叉排序树则既可以保证数据的查找,同时也可以保证数据的插入,删除,修改的速度
 *
 * 二叉树: 每个节点最多只能有两个子节点的形式的树称为 二叉树
 * 满二叉树: 所有叶子节点都在最后一层, 且节点总数与层数为: 2^n-1 的关系
 * 完全二叉树: 所有叶子节点都在最后一层或倒数第二层, 且最后一层的叶子节点在左边连续,倒数第二层的叶子节点在右边连续
 *
 * 数组缺点: 插入数据: 先扩容(底层创建新数组,将数据拷贝), 再插入到适当的位置(要移动数据) ; 删除时也需要移动数据
 * 链表的缺点: 查找满
 *
 * @author wubingyin
 * @date 2022/02/16
 */
public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
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
class Tst{
    public static void main(String[] args) {
        Node root = new Node(1, "uzi");
        Node node2 = new Node(2, "rookei");
        Node node3 = new Node(3, "theshy");
        Node node4 = new Node(4, "koobe");
        Node node5 = new Node(5, "james");
//        Node node6 = new Node(6, "boolan");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        BinaryTree tree = new BinaryTree(root);
        System.out.println("前List");//1234
        tree.preList();

        System.out.println("中List");//2134
        tree.midList();
        System.out.println("后List");//2431
        tree.behandList();

        /*System.out.println("前 find");
        Node preFind = tree.preFind(5);
        System.out.println(preFind);

        System.out.println("中 find");
        Node midFind = tree.midFind(5);
        System.out.println(midFind);

        System.out.println("hou find");
        Node behandFind = tree.behandFind(5);
        System.out.println(behandFind);*/

        System.out.println("delete");
        tree.delete(5);
        tree.preList();
    }
}
