package com.example.juc.异步回调;

import java.util.concurrent.*;

public class FutureTaskThreadDemo2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //3个任务, 一个线程, 耗时多久
//        mthod1();
        //3 个任务, 多个线程, 耗时多久
        long startTIme = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        FutureTask<String> task1 = new FutureTask<String>(
                ()->{
                    TimeUnit.SECONDS.sleep(5);
                    return "task1 over";
                }
        );
        executorService.submit(task1);
        executorService.shutdown();

        System.out.println("主线程做其他事情");
        while (true) {
            if (task1.isDone()) {
                System.out.println(task1.get());
                break;
            } else {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("正在处理");
            }
        }
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
