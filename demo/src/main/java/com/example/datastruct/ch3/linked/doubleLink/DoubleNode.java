package com.example.datastruct.ch3.linked.doubleLink;

import lombok.Data;
import lombok.ToString;

@Data
public class DoubleNode {
    private Integer no;
    private String data;
    private DoubleNode next;
    private DoubleNode pre;

    public DoubleNode(Integer no, String data) {
        this.no = no;
        this.data = data;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "no=" + no +
                ", data='" + data + '\'' +
                '}';
    }
}
