package com.example.demo.manyThread.cha121;

public class ThreadTest {
    public static void main(String[] args) {
        Bank bank = new Bank(4, 10000);
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < 100; i++) {
                    double amount = Math.random() * 1000;
                    bank.transfer(0, 1, amount);

                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            try {
                for (int i = 0; i < 100; i++) {
                    double amount = Math.random() * 1000;
                    bank.transfer(2, 3, amount);

                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();

    }
}
