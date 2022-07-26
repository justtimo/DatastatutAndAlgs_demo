package com.example.juc.多线程锁.volatile演示;

import java.util.concurrent.TimeUnit;

public class VolatileDemo1 {
    static volatile boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + "come in");
                    while (flag) {

                    }
                    System.out.println("flag值已经被修改");
                }
                , "t1").start();
        TimeUnit.SECONDS.sleep(1);
        flag = false;
        System.out.println(Thread.currentThread().getName()+" 值已经被修改为:"+flag);
    }
}
