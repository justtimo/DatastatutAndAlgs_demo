package com.example.juc.异步回调;

import java.util.concurrent.*;

public class CompleteFutrueDemo5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        CompletableFuture<String> gameA = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "A";
                });
        CompletableFuture<String> gameB = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "B";
                });
        CompletableFuture<String> result = gameA.applyToEither(gameB,
                t -> {
                    return t + " is winner";
                }
        );
        System.out.println(Thread.currentThread().getName()+"----"+result.join());
    }
}
