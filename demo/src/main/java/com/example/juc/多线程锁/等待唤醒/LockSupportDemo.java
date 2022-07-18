package com.example.juc.多线程锁.等待唤醒;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
//        notifyAndWait();
//        awaitAndSignal();
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t1 come in");
            LockSupport.park();
            LockSupport.park();
            System.out.println("t1被唤醒");
        }, "t1");
        t1.start();
//        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);
            System.out.println("t2发出唤醒通知");
        }, "t2").start();
    }

    private static void awaitAndSignal() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(
                ()->{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lock.lock();
                    try{
                        System.out.println(Thread.currentThread().getName() + "come in");
                        condition.await();
                        System.out.println(Thread.currentThread().getName()+"被唤醒了");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally{
                        lock.unlock();
                    }

                }
        ,"t1").start();

//        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "come in");
                condition.signal();
                System.out.println(Thread.currentThread().getName()+"发出唤醒通知");
            } finally{
                lock.unlock();
            }
        },"t2").start();
    }

    private static void notifyAndWait() {
        Object o = new Object();
        new Thread(
                ()->{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (o) {
                        System.out.println(Thread.currentThread().getName() + "come in");
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(Thread.currentThread().getName()+"被唤醒了");
                    }
                }
        ,"t1").start();

//        TimeUnit.SECONDS.sleep(1);

        new Thread(
                ()->{
                    synchronized (o) {
                        System.out.println(Thread.currentThread().getName() + "come in");
                        o.notify();
                        System.out.println(Thread.currentThread().getName()+"发出了唤醒");
                    }
                }
                ,"t2").start();
    }
}
