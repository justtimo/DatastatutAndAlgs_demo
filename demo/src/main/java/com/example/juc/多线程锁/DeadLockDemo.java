package com.example.juc.多线程锁;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();
    public static void main(String[] args) {
        new Thread(
                ()->{
                    synchronized (o1) {
                        System.out.println("获取 o1,等待 o2");
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (o2) {
                            System.out.println("获取 o2");
                        }
                    }
                }
        ,"A").start();

        new Thread(
                ()->{
                    synchronized (o2) {
                        System.out.println("获取 o2,等待 o1");
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (o1) {
                            System.out.println("获取 o1");
                        }
                    }
                }
                ,"B").start();
    }
}
