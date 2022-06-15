package com.example.datastruct.ch3.linked.singleLink;

import lombok.ToString;

/**
 * 单链表
 */
@ToString
public class SingleLinked {
    //头结点
    private Node head = new Node(-1, "", "");

    public void addNode(Node node) {
        //创建辅助结点
        Node temp = head;
        //找最后一个结点
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void addNodeByNumber(Node node) {
        Node temp = head;

        while (true){
            if (temp.getNext()==null){
                temp.setNext(node);
                break;
            }
            if (temp.getNext().getNo()>node.getNo()){
                node.setNext(temp.getNext());
                temp.setNext(node);
                temp=node;
                break;
            }else

            if (temp.getNext().getNo()==node.getNo()){
                throw new RuntimeException("此位置数据已存在");
            }
            temp=temp.getNext();
        }
    }

    public void modifyNode(Node node){
        Node temp=head;
        while (temp.getNext()!=null){
            if (temp.getNext().getNo()==node.getNo()){
                temp.setNext(node);
            }
            temp=temp.getNext();
        }
        System.out.println("链表无此节点");
    }

    public void deleteNode(int no){
        Node temp=head;
        while (true){
            if (temp.getNext().getNo()==no){
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp=temp.getNext();
        }
    }

    public int size(){
        Node temp=head;
        int size=0;
        while (temp.getNext()!=null){
            size++;
            temp=temp.getNext();
        }
        System.out.printf("链表有效结点个数: %d",size);
        return size;
    }
    public Node getDaoshuKNode(int k){
        int length = size();
        Node temp=head;
        int i=0;
        while (temp.getNext()!=null){
            if ((length-k)==i){
                return temp.getNext();
            }
            i++;
            temp=temp.getNext();
        }
        return null;
    }

    //翻转链表:方式一:会改变原本数据结构.    还有方式二: 使用栈先进后出的特性.
    public static SingleLinked reverse(SingleLinked old){
        Node oldHead= old.head;
        if (oldHead.getNext()==null||oldHead.getNext().getNext()==null){
            return old;
        }
        SingleLinked newLinked = new SingleLinked();
        Node newLinkHead = newLinked.head;

        Node oldCurrentNode = oldHead.getNext();
        Node oldNextNode=null;

        while (oldCurrentNode!=null){
            oldNextNode=oldCurrentNode.getNext();
            oldCurrentNode.setNext(newLinkHead.getNext());//后继
            newLinkHead.setNext(oldCurrentNode);//前驱
            oldCurrentNode=oldNextNode;
        }
        return newLinked;
    }

    public void list() {
        Node temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            //指针后移
            temp = temp.getNext();
        }
        System.out.println("LinkedList is null");

    }
}

class Test {
    public static void main(String[] args) {
        Node node = new Node(0, "rookie", "zhogndan");
        Node node1 = new Node(1, "theShy", "shangdan");
        Node node2 = new Node(2, "uzi", "adc");
        Node node3 = new Node(3, "baolan", "fuzhu");
        Node node4 = new Node(4, "pdd", "shangdan");

//        SingleLinked linked = new SingleLinked();
//        linked.addNode(node);
//        linked.addNode(node1);
//        linked.addNode(node2);
//        linked.addNode(node3);
//        linked.addNode(node4);

        SingleLinked linked1 = new SingleLinked();
        linked1.addNodeByNumber(node);
        linked1.addNodeByNumber(node1);
        linked1.addNodeByNumber(node3);
        linked1.addNodeByNumber(node2);
        linked1.addNodeByNumber(node4);
//        linked1.addNodeByNumber(node4);
        node4 = new Node(4, "lubenwei", "chuibiwang");
        linked1.modifyNode(node4);

        Node daoshuKNode = linked1.getDaoshuKNode(3);

        SingleLinked reverse = SingleLinked.reverse(linked1);
        System.out.println(reverse);

//        linked1.list();
//        linked1.size();
//
//        linked1.deleteNode(2);
//        linked1.list();
//        linked1.deleteNode(4);
//        linked1.list();
//        linked1.deleteNode(0);
//        linked1.list();


    }
}