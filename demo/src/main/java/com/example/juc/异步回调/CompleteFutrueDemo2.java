package com.example.juc.异步回调;


import java.util.Random;
import java.util.concurrent.*;

public class CompleteFutrueDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture.supplyAsync(
                    () -> {
                        System.out.println(Thread.currentThread().getName());
                        int result = new Random().nextInt(10);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("1s after get result");
                        if (result > 2) {
                            int i = 10 / 0;
                        }
                        return result;
                    }
            ,threadPool).whenComplete(
                    (a, b) -> {
                        if (b == null) {
                            System.out.println("计算完成, 结果是" + a);
                        }
                    }
            ).exceptionally(
                    e -> {
                        e.getStackTrace();
                        System.out.println("异常信息:" + e.getMessage());
                        return null;
                    }
            );

            System.out.println("----主线程");
            //主线程不要立刻结束, 因为默认线程池会立即关闭,导致无法输出计算结果
            // TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
