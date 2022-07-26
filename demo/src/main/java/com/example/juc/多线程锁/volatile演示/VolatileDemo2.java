package com.example.juc.多线程锁.volatile演示;

import java.util.concurrent.TimeUnit;

/**
 * 读多邪少, 结合内部锁和 volatile 变量减少同步开销
 * 理由: 利用 volatile 保证去操作可见性, 利用 Synchronize 保证复合操作原子性
 */
public class VolatileDemo2 {
    private volatile int value;

    public int getValue() {
        return value; //利用 volatile 保证读取操作可见性
    }

    public synchronized int increment() {
        return value++;//利用 Synchronize 保证复合操作原子性
    }
}
