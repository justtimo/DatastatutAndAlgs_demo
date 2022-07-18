package com.example.juc.多线程锁.中断线程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 中断线程演示
 *
 * ● 通过一个 volatile 变量实现
 * ● 通过 AtomicBoolean 实现
 * ● 通过 Thread 类自带的中断 api 实例方法实现
 *
 * @author wubingyin
 * @date 2022/07/15
 */
public class InterruptThreadDemo {
    static volatile  boolean isStop=false;
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    public static void main(String[] args) throws InterruptedException {
        volatileMethod();
        atomicBoolean();
        threadApiMethod();
    }

    private static void threadApiMethod() throws InterruptedException {
        //方法 3: 使用 Thread 类 API
        Thread t1 = new Thread(
                () -> {
                    while (true) {
                        if (Thread.currentThread().isInterrupted()) {
                            System.out.println(Thread.currentThread().getName() + "被修改为 truee,程序停止");
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + " is running by thread class api");
                    }
                }
                , ":thread_api_1");
        t1.start();
        TimeUnit.MILLISECONDS.sleep(10);
        new Thread(()->{
            t1.interrupt();
        },":thread_api_2").start();
        //也可以自己中断
//        t1.interrupt();
    }

    private static void atomicBoolean() throws InterruptedException {
        // 方法 2: autoic
        new Thread(
                ()->{
                    while (true) {
                        if (atomicBoolean.get()) {
                            System.out.println(Thread.currentThread().getName() + "被修改为 truee,程序停止");
                            break;
                        }
                        System.out.println(Thread.currentThread().getName()+" is running by atomicBoolean");
                    }
                }
                ,":atomicBoolean_1").start();
        TimeUnit.MILLISECONDS.sleep(10);
        new Thread(()->{
            atomicBoolean.set(true);
        },":atomicBoolean_2").start();
    }

    private static void volatileMethod() throws InterruptedException {
        // 方法 1volatile
        new Thread(
                ()->{
                    while (true) {
                        if (isStop) {
                            System.out.println(Thread.currentThread().getName() + "被修改为 truee,程序停止");
                            break;
                        }
                        System.out.println(Thread.currentThread().getName()+" is running by volatile");
                    }
                }
        ,":volatile_1").start();
        TimeUnit.MILLISECONDS.sleep(10);
        new Thread(()->{
            isStop = true;
        },":volatile_2").start();
    }
}
