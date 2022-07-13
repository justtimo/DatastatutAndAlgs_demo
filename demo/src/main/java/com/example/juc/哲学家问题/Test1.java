package com.example.juc.哲学家问题;

import java.util.concurrent.CountDownLatch;

/**
 * 使用门栓控制线程顺序
 *
 * @author wubingyin
 * @date 2022/07/07
 */
public class Test1 {
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        Object o = new Object();
        char[] aI = "123456".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(
                ()->{
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (o) {
                        for (char c : aI) {
                            System.out.println(c);
                            o.notify();
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        o.notify();
                    }
                }
        ).start();

        new Thread(
                ()->{
                    synchronized (o) {
                        for (char c : aC) {
                            System.out.println(c);
                            latch.countDown();
                            o.notify();
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        o.notify();
                    }
                }
        ).start();

    }
}
