package com.example.juc.多线程锁.原子类;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * 50 个线程, 每个 100W 次, 总点赞数
 *
 * @author wubingyin
 * @date 2022/07/19
 */
public class LongAdderDemo2 {
    public static final int SIZE =50;
    public static final int _1W=10000;
    public static void main(String[] args) throws InterruptedException {
        ClickNumber clickNumber = new ClickNumber();
        long starTime;
        long endTime;
        CountDownLatch countDownLatch = new CountDownLatch(SIZE);
        CountDownLatch countDownLatch1 = new CountDownLatch(SIZE);
        CountDownLatch countDownLatch2= new CountDownLatch(SIZE);
        CountDownLatch countDownLatch3= new CountDownLatch(SIZE);

        starTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            new Thread(
                    ()->{
                        try {
                            for (int j = 0; j < 100*_1W; j++) {
                                clickNumber.clickBySynch();
                            }
                        }finally {
                            countDownLatch.countDown();
                        }
                    }
            ,String.valueOf(i)).start();
        }
        countDownLatch.await();
        endTime = System.currentTimeMillis();
        System.out.println("clickBySynch"+"耗时: "+(endTime-starTime)+ "\tsize"+clickNumber.number);

        starTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            new Thread(
                    ()->{
                        try {
                            for (int j = 0; j < 100*_1W; j++) {
                                clickNumber.clickByAtomicLong();
                            }
                        }finally {
                            countDownLatch1.countDown();
                        }
                    }
                    ,String.valueOf(i)).start();
        }
        countDownLatch1.await();
        endTime = System.currentTimeMillis();
        System.out.println("clickByAtomicLong"+"耗时: "+(endTime-starTime)+ "\tsize"+clickNumber.atomicLong.get());

        starTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            new Thread(
                    ()->{
                        try {
                            for (int j = 0; j < 100*_1W; j++) {
                                clickNumber.clickByLongAdder();
                            }
                        }finally {
                            countDownLatch2.countDown();
                        }
                    }
                    ,String.valueOf(i)).start();
        }
        countDownLatch2.await();
        endTime = System.currentTimeMillis();
        System.out.println("clickByLongAdder"+"耗时: "+(endTime-starTime)+ "\tsize"+clickNumber.longAdder.sum());

        starTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            new Thread(
                    ()->{
                        try {
                            for (int j = 0; j < 100*_1W; j++) {
                                clickNumber.clickByLongAccumulator();
                            }
                        }finally {
                            countDownLatch3.countDown();
                        }
                    }
                    ,String.valueOf(i)).start();
        }
        countDownLatch3.await();
        endTime = System.currentTimeMillis();
        System.out.println("clickByLongAccumulator"+"耗时: "+(endTime-starTime)+ "\tsize"+clickNumber.longAccumulator.get());
    }
}
class ClickNumber{
    int number = 0;
    public synchronized void clickBySynch() {
        number++;
    }

    AtomicLong atomicLong = new AtomicLong(0);
    public void clickByAtomicLong() {
        atomicLong.getAndIncrement();
    }

    LongAdder longAdder=new LongAdder();
    public void clickByLongAdder() {
        longAdder.add(1);
    }

    LongAccumulator longAccumulator = new LongAccumulator(
            (x,y)->x+y,0
    );
    public void clickByLongAccumulator() {
        longAccumulator.accumulate(1);
    }
}