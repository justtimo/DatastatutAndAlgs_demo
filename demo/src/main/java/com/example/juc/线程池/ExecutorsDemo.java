package com.example.juc.线程池;

import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(10);
        Executors.newSingleThreadExecutor();
    }
}
