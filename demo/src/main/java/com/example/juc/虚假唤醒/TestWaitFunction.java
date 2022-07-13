package com.example.juc.虚假唤醒;

class Share{
    int num = 0;

    public synchronized void incr() throws InterruptedException {
        if (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"::"+num);
        notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        if (num != 1) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"::"+num);
        notifyAll();
    }
}

public class TestWaitFunction {
    public static void main(String[] args) {
        Share function = new Share();
        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            function.incr();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
                , "AA").start();

        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            function.incr();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
                , "BB").start();

        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            function.decr();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
                , "CC").start();

        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            function.decr();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
                , "DD").start();

    }
}
