package com.example.juc.多线程锁.原子类;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicDemo3 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(
                    ()->{
                        try {
                            for (int j = 0; j < 1000; j++) {
//                                bankAccount.add();
                                bankAccount.transfer(bankAccount);
                            }
                        }finally {
                            countDownLatch.countDown();
                        }
                    }
            ).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t"+bankAccount.money);
    }
}
class BankAccount{
    String name="CCB";
    public volatile int money=0;

    public /*synchronized*/ void add() {
        money++;
    }

    AtomicIntegerFieldUpdater<BankAccount> fieldUpdater =
            AtomicIntegerFieldUpdater.newUpdater(BankAccount.class, "money");

    public void transfer(BankAccount bankAccount) {
        fieldUpdater.getAndIncrement(bankAccount);
    }
}