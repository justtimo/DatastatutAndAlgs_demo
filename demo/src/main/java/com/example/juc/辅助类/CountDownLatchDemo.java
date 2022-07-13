package com.example.juc.辅助类;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(
                    ()->{
                        System.out.println("卖出了"+ (Integer.valueOf(Thread.currentThread().getName())+1) +"票");
                        countDownLatch.countDown();
                    }
            ,String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("票卖完了");
    }
}
