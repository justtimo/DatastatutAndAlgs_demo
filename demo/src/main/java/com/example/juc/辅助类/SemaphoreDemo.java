package com.example.juc.辅助类;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(
                    ()->{
                        try {
                            semaphore.acquire();
                            System.out.println("第"+Integer.valueOf(Thread.currentThread().getName())+"抢占了车位");
                            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }finally {
                            System.out.println("第"+Integer.valueOf(Thread.currentThread().getName())+"离开了了车位");
                            semaphore.release();
                        }
                    }
            ,String.valueOf(i)).start();
        }
    }
}
