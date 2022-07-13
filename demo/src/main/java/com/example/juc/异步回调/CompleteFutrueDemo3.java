package com.example.juc.异步回调;


import java.util.Random;
import java.util.concurrent.*;

public class CompleteFutrueDemo3 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
                () -> {
                    return "hello 111";
                }
                , threadPool);
        // completableFuture.get();
        completableFuture.join();
    }
}
