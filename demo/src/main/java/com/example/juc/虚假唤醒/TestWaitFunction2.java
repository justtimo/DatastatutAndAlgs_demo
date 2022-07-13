package com.example.juc.虚假唤醒;

import java.util.concurrent.locks.ReentrantLock;

class Share2 {
    int num = 0;
    final ReentrantLock lock = new ReentrantLock();

    public void incr() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0) {
                lock.wait();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "::" + num);
        } finally {
            lock.unlock();
        }
    }

    public void decr() throws InterruptedException {
        lock.lock();
        try {
            while (num != 1) {
                lock.wait();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "::" + num);
        } finally {
            lock.unlock();
        }
    }
}

public class TestWaitFunction2 {
    public static void main(String[] args) {
        Share function = new Share();
        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            function.incr();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
                , "AA").start();

        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            function.incr();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
                , "BB").start();

        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            function.decr();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
                , "CC").start();

        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            function.decr();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
                , "DD").start();

    }
}
