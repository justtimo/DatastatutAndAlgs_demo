package com.example.datastruct.ch3.linked.circleSingleLinked;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CircleSingleNode {
    private Integer no;
    private String name;
    private CircleSingleNode next;

    public CircleSingleNode(Integer no, String name) {
        this.no = no;
        this.name = name;
        next=null;
    }

    @Override
    public String toString() {
        return "CircleSingleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CircleSingleNode getNext() {
        return next;
    }

    public void setNext(CircleSingleNode next) {
        this.next = next;
    }
}
