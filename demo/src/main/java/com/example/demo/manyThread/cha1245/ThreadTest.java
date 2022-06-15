package com.example.demo.manyThread.cha1245;


import com.example.demo.manyThread.cha1244.Bank;

public class ThreadTest {
    public static void main(String[] args) {
        com.example.demo.manyThread.cha1244.Bank bank = new Bank(4, 10000);
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < 100; i++) {
                    int toAccount = (int) (bank.size()*Math.random());
                    int fromAccount = (int) (bank.size()*Math.random());
                    double amount = Math.random() * 1000;
                    bank.transfer(fromAccount, toAccount, amount);

                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            try {
                for (int i = 0; i < 100; i++) {
                    int toAccount = (int) (bank.size()*Math.random());
                    int fromAccount = (int) (bank.size()*Math.random());
                    double amount = Math.random() * 1000;
                    bank.transfer(fromAccount, toAccount, amount);

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
