package com.example.juc.异步回调;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteFutrueDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //同步调用
        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.runAsync(
                ()->{
                    System.out.println("没有返回值");
                }
        );
        voidCompletableFuture1.get();
        //异步调用
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("异步调用");
                    return 1;
                }
        );
        //a: 返回值 b:异常信息
        completableFuture2.whenComplete(
                (a,b)->{
                    System.out.println(a);
                    System.out.println(b);
                }
        ).get();
    }
}
