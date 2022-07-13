package com.example.juc.辅助类;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static final int NUMBER = 7;
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, () -> {
            System.out.println("所有工作都处理完毕");
        });
        for (int i = 0; i < 7; i++) {
            new Thread(
                    ()->{
                        System.out.println("第"+Thread.currentThread().getName()+"步已经处理完成");
                        try {
                            cyclicBarrier.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (BrokenBarrierException e) {
                            throw new RuntimeException(e);
                        }
                    }
            ,String.valueOf(i)).start();
        }
    }
}
