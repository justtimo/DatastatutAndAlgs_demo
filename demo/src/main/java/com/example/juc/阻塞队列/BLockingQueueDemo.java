package com.example.juc.阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;

public class BLockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(3);
        //第一组
        /*System.out.println(strings.add("1"));
        System.out.println(strings.add("2"));
        System.out.println(strings.add("3"));
//        System.out.println(strings.add("4"));

        System.out.println(strings.remove());
        System.out.println(strings.remove());
        System.out.println(strings.remove());
        System.out.println(strings.remove());*/

        /*//第二组
        System.out.println(strings.offer("1"));
        System.out.println(strings.offer("2"));
        System.out.println(strings.offer("3"));
        System.out.println(strings.offer("4"));

        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll());*/

        //第三组
        strings.put("1");
        strings.put("2");
        strings.put("3");
//        strings.put("4");

        System.out.println(strings.take());
        System.out.println(strings.take());
        System.out.println(strings.take());
//        strings.take();
    }
}
