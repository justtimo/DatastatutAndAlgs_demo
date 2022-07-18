package com.example.juc.多线程锁.中断线程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 中断线程演示
 *
 * 正常活动线程
 * 非正常活动线程
 *
 * @author wubingyin
 * @date 2022/07/15
 */
public class InterruptThreadDemo2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 300; i++) {
                        System.out.println("---" + i);
                    }
                    System.out.println("t1线程调用 interrupt 后的中断标识 02: " + Thread.currentThread().isInterrupted());
                }
                , "t1");
        t1.start();

        System.out.println("t1 默认的中断标识: " + t1.isInterrupted());

        TimeUnit.MILLISECONDS.sleep(1);
        t1.interrupt();
        System.out.println("t1线程调用 interrupt 后的中断标识 01 : " + t1.isInterrupted());

        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("t1线程调用 interrupt 后的中断标识 03: "+t1.isInterrupted());
    }

}
