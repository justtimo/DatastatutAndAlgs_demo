package com.example.datastruct.ch4stack.stack.linkedStack;

public class LinkedNode<T> {
    private T no;
    private LinkedNode next;

    public T getNo() {
        return no;
    }

    public void setNo(T no) {
        this.no = no;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public LinkedNode(T no) {
        this.no = no;
    }
}
