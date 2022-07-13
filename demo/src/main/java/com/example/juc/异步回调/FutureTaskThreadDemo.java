package com.example.juc.异步回调;

import java.util.concurrent.*;

public class FutureTaskThreadDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //3个任务, 一个线程, 耗时多久
        mthod1();
        //3 个任务, 多个线程, 耗时多久
        long startTIme = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        FutureTask<String> task1 = new FutureTask<String>(
                ()->{
                    TimeUnit.MILLISECONDS.sleep(500);
                    return "task1 over";
                }
        );
        FutureTask<String> task2 = new FutureTask<String>(
                ()->{
                    TimeUnit.MILLISECONDS.sleep(300);
                    return "task2 over";
                }
        );

        executorService.submit(task1);
        executorService.submit(task2);
        System.out.println(task1.get());
        System.out.println(task2.get());
        executorService.shutdown();
        TimeUnit.MILLISECONDS.sleep(300);

        long endTIme = System.currentTimeMillis();
        System.out.println("花费"+(endTIme-startTIme)+"毫秒");
    }

    private static void mthod1() throws InterruptedException {
        long startTIme = System.currentTimeMillis();
        TimeUnit.MILLISECONDS.sleep(500);
        TimeUnit.MILLISECONDS.sleep(300);
        TimeUnit.MILLISECONDS.sleep(300);

        long endTIme = System.currentTimeMillis();

        System.out.println("花费"+(endTIme-startTIme)+"毫秒");
        System.out.println(Thread.currentThread().getName()+"\t-----end");
    }
}
