package com.example.datastruct.ch2queue;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

/**
 * front == rear (空)
 * rear == maxSize-1 (满)
 */
@Data
@AllArgsConstructor
public class ArrayQueue {
    private int maxSize;
    private int front;//头
    private int rear;//尾
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头位置
        rear = 0;//指向队列尾部 即队列最后一个数据
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmplty() {
        return rear == front;
    }

    public void addElement(int element) {
        if (isFull()) {
            return;
        }
        arr[rear] = element;
        rear++;//rear 后移
    }

    public void addElementbyIndex(int element,int index){
        if (isFull()) {
            throw new RuntimeException("数组已满");
        }
        if (index-1>arr.length){
            throw new RuntimeException("越界");
        }
        if (index-1 == arr.length){

        }
        for (int i = index-1; i < arr.length; i++) {
            arr[i+1] = arr[i];
        }
        arr[index-1] = element;
    }

    public int removeElement() {
        if (isEmplty()) {
            front=0;
            rear=0;
            throw new RuntimeException("队列空, 不能取出数据");
        }
        arr[front] = 0;
        front++;//front 后移
        return arr[front];
    }

    public String getList(){
        if (isEmplty()){
            throw new RuntimeException("队列空, 不能打印数据");
        }
        for (int i = 0; i < arr. length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
        return Arrays.toString(arr);
    }
    public int getHead(){
        if (isEmplty()){
            throw new RuntimeException("队列空, 不能打印数据");
        }
        return arr[front];
    }
}
class Test{
    public static void main(String[] args) {
        int i=4%5;
//        ArrayQueue queue = new ArrayQueue(10);
//        queue.addElement(1);
//        queue.addElement(2);
//        queue.addElement(12);
//        queue.addElement(1000);
//        String list = queue.getList();
//        queue.removeElement();
//        queue.removeElement();
//        queue.removeElement();
//        queue.removeElement();
//        System.out.println(queue.getHead());
//        queue.removeElement();
//        String list2 = queue.getList();
    }
}