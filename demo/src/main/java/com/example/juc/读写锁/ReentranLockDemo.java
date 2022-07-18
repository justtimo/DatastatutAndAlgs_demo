package com.example.juc.读写锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(
                () -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + "外层");
                        try {
                            lock.lock();
                            System.out.println(Thread.currentThread().getName() + "内层");
                        } finally {
//                            lock.unlock();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                }
                , "t1").start();

        new Thread(
                () -> {
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + "外层");
                    } finally {
                        lock.unlock();
                    }
                }
                , "t2").start();

    }
}
