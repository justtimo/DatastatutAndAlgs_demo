package com.example.datastruct.ch3.linked.doubleLink;

import com.example.datastruct.ch3.linked.singleLink.Node;
import lombok.ToString;

@ToString
public class DoubleLinked {
    private DoubleNode head=new DoubleNode(-1,"");

    public void list(){
        DoubleNode temp = head.getNext();
        while (temp!=null){
            System.out.println(temp);
        }
    }

    public void add(DoubleNode node){
        DoubleNode temp = head;
        while (temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(node);
        node.setPre(temp);
    }

    public void modify(DoubleNode node){
        DoubleNode temp = head.getNext();
        while (temp!=null){
            if (node.getNo().equals(temp.getNo())){
                temp.setData(node.getData());
                break;
            }
            temp=temp.getNext();
        }
    }
    public void size(){
        DoubleNode temp = head.getNext();
        int count =0;
        while (temp!=null){
            count++;
            temp=temp.getNext();
        }
    }

    public void delete(Integer no){
        DoubleNode temp = head.getNext();
        while (temp!=null){
            if (temp.getNo().equals(no)){
                //后继
                DoubleNode next = temp.getNext();
                //qianqu
                DoubleNode pre = temp.getPre();

                temp.getPre().setNext(temp.getNext());
                if (next!=null){
                    temp.getNext().setPre(temp.getPre());
                }
                break;
            }
            temp=temp.getNext();
        }
    }

}
class Test{
    public static void main(String[] args) {
        DoubleNode node1 = new DoubleNode(0, "rookie");
        DoubleNode node2 = new DoubleNode(1, "theShy");
        DoubleNode node3 = new DoubleNode(2, "uzi");
        DoubleNode node4 = new DoubleNode(3, "pdd");


        DoubleLinked doubleLinked = new DoubleLinked();
        doubleLinked.add(node1);
        doubleLinked.add(node2);
        doubleLinked.add(node3);
        doubleLinked.add(node4);

        doubleLinked.modify(new DoubleNode(3,"wy"));

        doubleLinked.delete(2);

        System.out.println(doubleLinked);

    }
}