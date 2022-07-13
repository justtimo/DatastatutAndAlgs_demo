package com.example.juc.多线程锁;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Runnable 接口有实现类 FutureTask, FutureTask 构造可以传递 Callable
 *
 * @author wubingyin
 * @date 2022/07/11
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(
                () -> {
                    TimeUnit.SECONDS.sleep(1);
                    return 1024;
                }
        );
        new Thread(task,"aaa").start();

        while (!task.isDone()) {
            System.out.println("waiting...");
        }
        System.out.println(task.get());
        System.out.println(task.get());
    }
}
