package com.example.juc.多线程锁.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 自定义自旋锁
 *
 * @author wubingyin
 * @date 2022/07/18
 */
public class CASDemo2 {
    private AtomicReference<Thread> thread = new AtomicReference<>();
    public void lock(){
        Thread thread1 = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\tcome in");
        while (!thread.compareAndSet(null, thread1)) {

        }
        System.out.println(Thread.currentThread().getName() + "\tget lock");
    }

    public void unlcok() {
        Thread thread1 = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t task over");
        thread.compareAndSet(thread1, null);
    }

    public static void main(String[] args) throws InterruptedException {
        CASDemo2 demo2 = new CASDemo2();
        new Thread(
                ()->{
                    demo2.lock();
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    demo2.unlcok();
                }
        ,"A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(
                ()->{
                    demo2.lock();
                    demo2.unlcok();
                }
                ,"B").start();
    }
}
