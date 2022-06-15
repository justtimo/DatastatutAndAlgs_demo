package com.example.datastruct.ch3.linked.singleLink;

import lombok.Data;

@Data
//@ToString
public class Node {
    private int no;
    private String name;
    private String nickName;
    private Node next;//下一个结点

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
