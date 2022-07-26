package com.example.juc.多线程锁.原子类;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo1 {
    private final static int SIZE = 50;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(SIZE);
        MyNum myNum = new MyNum();
        for (int i = 0; i < SIZE; i++) {
            new Thread(
                    () -> {
                        try {
                            for (int j = 0; j < 1000; j++) {
                                myNum.add();
                            }
                        } finally {
                            countDownLatch.countDown();
                        }
                    }
            ).start();
        }
//        TimeUnit.SECONDS.sleep(2);
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t"+myNum.get());
    }
}
class MyNum{
    AtomicInteger atomicInteger = new AtomicInteger();

    public int get() {
        return atomicInteger.get();
    }
    public void add() {
        atomicInteger.getAndIncrement();
    }
}