package com.example.juc.多线程锁.中断线程;

import java.util.concurrent.TimeUnit;

/**
 * 中断线程演示
 *
 * 正常活动线程
 * 非正常活动线程
 *
 * @author wubingyin
 * @date 2022/07/15
 */
public class InterruptThreadDemo3 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(
                () -> {
                    System.out.println("初始中断标识: "+Thread.currentThread().isInterrupted());
                    while (Thread.currentThread().isInterrupted()) {
                        System.out.println("中断了, 程序结束");
                        break;
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(2000);
                    } catch (InterruptedException e) {
                        //阻塞状态的线程被中断, 将会被清除之前的中断标识(导致 while 死循环)
                        //需要重新设置中断标识
                        Thread.currentThread().interrupt();
                        System.out.println("t1 阻塞状态被中断, 重新设置中断标识");
                        throw new RuntimeException(e);
                    }

                }
                , "t1");
        t1.start();

        TimeUnit.MILLISECONDS.sleep(50);
        new Thread(
                ()->{
                    t1.interrupt();
                    System.out.println("设置 t1 的中断标识位 true");
                }
        ).start();
    }

}
