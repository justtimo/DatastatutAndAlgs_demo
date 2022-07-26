package com.example.juc.线程局部变量;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo1 {
    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 6; i++) {
                executorService.submit(
                        () -> {
                            int size = new Random().nextInt(5) + 1;
                            try {
                                for (int j = 0; j < size; j++) {
                                    house.saleHouse();
                                    house.saleVolumeByThreadLocal();
                                }
                                System.out.println(Thread.currentThread().getName() + "\t号销售共卖出: " + house.threadLocal.get());
                            } finally {
                                house.threadLocal.remove();
                            }
                        }
                        , String.valueOf(i));
            }
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + "\t共卖出" + house.saleCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }


    }
}

//资源类
class House {
    int saleCount = 0;

    public synchronized void saleHouse() {
        saleCount++;
    }

    /*//JDK1.8 不推荐使用此方式
    ThreadLocal<Integer> threadLocal=new ThreadLocal<>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };*/
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public void saleVolumeByThreadLocal() {
        threadLocal.set(1 + threadLocal.get());
    }
}