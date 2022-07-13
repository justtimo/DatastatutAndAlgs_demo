package com.example.juc.哲学家问题;

import java.io.PipedInputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 ReentranLock 唤醒指定的线程
 *
 * @author wubingyin
 * @date 2022/07/07
 */
public class TestLock {
    public static void main(String[] args) {
        new PipedInputStream();
        char[] aI = "123456".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        ReentrantLock lock = new ReentrantLock();
        Condition number = lock.newCondition();
        Condition text = lock.newCondition();

        CountDownLatch latch = new CountDownLatch(1);

        new Thread(
                () -> {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lock.lock();
                    try {
                        for (char c : aI) {
                            System.out.println(c);
                            text.signal();
                            number.await();
                        }
                        text.signal();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }

                }
                , "t1").start();

        new Thread(
                () -> {
                    lock.lock();
                    try {
                        for (char c : aC) {
                            System.out.println(c);
                            latch.countDown();
                            number.signal();
                            text.await();
                        }
                        number.signal();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }

                }
        ,"t2").start();
    }
}
