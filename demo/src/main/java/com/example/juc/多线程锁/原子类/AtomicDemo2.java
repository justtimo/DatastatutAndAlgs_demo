package com.example.juc.多线程锁.原子类;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicDemo2 {
    static AtomicMarkableReference markableReference = new AtomicMarkableReference(100, false);
    public static void main(String[] args) throws InterruptedException {
        new Thread(
                ()->{
                    boolean marked = markableReference.isMarked();
                    System.out.println(Thread.currentThread().getName() + "\t" + "默认标识:" + marked);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    markableReference.compareAndSet(100, 1000, marked, !marked);
                }
        ,"t1").start();
        new Thread(
                ()->{
                    boolean marked = markableReference.isMarked();
                    System.out.println(Thread.currentThread().getName() + "\t" + "默认标识:" + marked);
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    boolean b = markableReference.compareAndSet(100, 2000, marked, !marked);
                    System.out.println(Thread.currentThread().getName()+"\t"+"t2线程 CASResult: "+b);
                    System.out.println(Thread.currentThread().getName() + "\t" + markableReference.isMarked());
                    System.out.println(Thread.currentThread().getName() + "\t" + markableReference.getReference());

                }
                ,"t2").start();
    }
}
