package com.example.datastruct.ch2queue;

import lombok.Data;

@Data
public class CircleArrayQueue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        if ((rear + 1) % maxSize == front) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    public int count() {
        return (rear - front + maxSize)%maxSize;
    }

    public void addElement(int element) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[rear] = element;
//        rear++;
//        if (rear > maxSize-1) {
//            rear = 0;
//        }
        rear=(rear+1)%maxSize;
    }

    public void removeElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空, 无法删除元素");
        }
        arr[front] = 0;
//        front++;
//        if (front > maxSize-1) {
//            front=0;
//        }
        front=(front+1)%maxSize;
    }
}
class Test1{
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);
        boolean empty = circleArrayQueue.isEmpty();
        boolean full = circleArrayQueue.isFull();
        circleArrayQueue.addElement((int) (Math.random()*100));
        circleArrayQueue.addElement((int) (Math.random()*100));
        circleArrayQueue.addElement((int) (Math.random()*100));
        circleArrayQueue.addElement((int) (Math.random()*100));
        int count = circleArrayQueue.count();
//        circleArrayQueue.addElement((int) (Math.random()*100));
        boolean empty1 = circleArrayQueue.isEmpty();
        boolean full1 = circleArrayQueue.isFull();

        circleArrayQueue.removeElement();
        int count1 = circleArrayQueue.count();
        circleArrayQueue.addElement((int) (Math.random()*100));
        int count2 = circleArrayQueue.count();
//        circleArrayQueue.addElement((int) (Math.random()*100));
        circleArrayQueue.removeElement();
        int count3 = circleArrayQueue.count();
        circleArrayQueue.removeElement();
        int count4 = circleArrayQueue.count();
        circleArrayQueue.removeElement();
        int count5 = circleArrayQueue.count();
        circleArrayQueue.removeElement();
        int count6 = circleArrayQueue.count();
        boolean empty11 = circleArrayQueue.isEmpty();
        boolean full11 = circleArrayQueue.isFull();
        circleArrayQueue.removeElement();
        int count7 = circleArrayQueue.count();
    }
}