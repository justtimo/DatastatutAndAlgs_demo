package com.example.juc.异步回调;

import java.util.concurrent.*;

public class CompleteFutrueDemo6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> gameA = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("A 启动");
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "A";
                });
        CompletableFuture<String> gameB = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("B 启动");
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "B";
                });
        CompletableFuture<String> result = gameA.thenCombine(gameB,
                (a,b)->{
                    System.out.println("结果合并");
                    return a+b;
                }
        );
        System.out.println(Thread.currentThread().getName()+"----"+result.join());
    }
}
