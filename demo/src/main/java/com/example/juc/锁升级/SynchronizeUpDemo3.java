package com.example.juc.锁升级;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 锁消除
 */
public class SynchronizeUpDemo3 {
    static Object lock = new Object();

    public void m1() {
        Object o = new Object();
        synchronized (o) {
            System.out.println("锁消除演示"+"\t"+o.hashCode()+"\t"+lock.hashCode());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizeUpDemo3 demo3 = new SynchronizeUpDemo3();
        for (int i = 0; i < 10; i++) {
            new Thread(
                    ()->{
                        demo3.m1();
                    }
            ,String.valueOf(i)).start();
        }
    }
}
