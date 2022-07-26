package com.example.juc.多线程锁.原子类;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicDemo4 {
    public static void main(String[] args) throws InterruptedException {
        ResoutDemo resoutDemo = new ResoutDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                try {
                    resoutDemo.init(resoutDemo);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            },String.valueOf(i)).start();
        }
    }
}

class ResoutDemo{
    public volatile Boolean isInit = Boolean.FALSE;
    AtomicReferenceFieldUpdater fieldUpdater =
            AtomicReferenceFieldUpdater.newUpdater(ResoutDemo.class, Boolean.class, "isInit");

    public void init(ResoutDemo resoutDemo) throws InterruptedException {
        if (fieldUpdater.compareAndSet(resoutDemo, Boolean.FALSE, Boolean.TRUE)) {
            System.out.println(Thread.currentThread().getName() + "\t" + "strart inti");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + "\t" + "init over");
        } else {
            System.out.println(Thread.currentThread().getName() + "\t" + "已经有起其他线程初始化了");
        }
    }
}