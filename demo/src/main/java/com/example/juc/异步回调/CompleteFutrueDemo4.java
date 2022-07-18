package com.example.juc.异步回调;

import java.util.concurrent.*;

public class CompleteFutrueDemo4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("1 号任务 " + Thread.currentThread().getName());
                    return "11";
                }
                , threadPool).thenRun(
                () -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("2 号任务 " + Thread.currentThread().getName());
                }
        ).thenRunAsync(
                () -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("3 号任务 " + Thread.currentThread().getName());
                }
        ).thenRun(
                () -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("4 号任务 " + Thread.currentThread().getName());
                }
        );
        System.out.println(completableFuture.get(2L,TimeUnit.SECONDS));
        
    }
}
