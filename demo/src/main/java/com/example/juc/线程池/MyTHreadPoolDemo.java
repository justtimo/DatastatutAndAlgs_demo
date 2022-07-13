package com.example.juc.线程池;

import java.util.concurrent.*;

public class MyTHreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()

        );
        executor.execute(
                ()->{
                    System.out.println("1111");
                }
        );

    }
}
