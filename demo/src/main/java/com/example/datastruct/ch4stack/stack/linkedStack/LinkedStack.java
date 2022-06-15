package com.example.datastruct.ch4stack.stack.linkedStack;

public class LinkedStack<T> {
    private LinkedNode<T> head;

    public LinkedStack(LinkedNode<T> head) {
        this.head = head;
    }

    private LinkedNode getLast(){
        LinkedNode last=head;
        while (last.getNext()!=null){
            last=last.getNext();
        }
        return last;
    }
    public void addByHead(int num){
        LinkedNode first=head;
        for (int i = 0; i < num; i++) {
            if ((Integer) first.getNo()==-1){
                first=new LinkedNode(i);
                head=first;
            }else {
                first=new LinkedNode(i);
                first.setNext(head);
                head=first;
            }
        }
    }

    public void addLastByT(T obj){
        LinkedNode last = head;
        if (head.getNo().equals(-1)|| head.getNo().equals("-1")){
            head=new LinkedNode<T>(obj);
            last=head;
        }else {
            while (last.getNext()!=null){
                last=last.getNext();
            }
            last.setNext(new LinkedNode<T>(obj));
        }
    }

    public void addByLast(int num){
        LinkedNode last = head;
        for (int i = 0; i < num; i++) {
            if ((Integer) last.getNo()==-1){
                head=new LinkedNode(i);
                last=head;
            }else {
                last.setNext(new LinkedNode(i));
                last=last.getNext();
            }
        }
    }
    public void removeByLast(){
        LinkedNode last=head;
        while (last.getNext()!=null){
            if (last.getNext().getNext()==null){
                last.setNext(null);
                return;
            }
            last=last.getNext();
        }
//        while (true){
//            if (last.getNext().getNext()==null){
//                last.setNext(null);
//                return;
//            }
//            last=last.getNext();
//        }
    }

    public T removeLastByT(){
        LinkedNode last=head;
        T res =null;
        while (last.getNext()!=null){
            if (last.getNext().getNext()==null){
                res= (T) last.getNext().getNo();
                last.setNext(null);
                return (T) res;
            }
            last=last.getNext();
        }
        return (T) res;
    }

    public void removeByHead(){
        head=head.getNext();
    }

    public <T> T peek(){
        LinkedNode last=head;
        while (last.getNext()!=null){
            last=last.getNext();
        }
        return (T) last.getNo();
    }
}
class Test{
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack(new LinkedNode<Integer>(-1));
//        stack.addByLast(5);
//        stack.removeByLast();

        stack.addByHead(5);
        stack.removeByHead();

        System.out.println(stack);
    }
}