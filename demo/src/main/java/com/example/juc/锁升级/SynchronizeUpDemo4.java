package com.example.juc.锁升级;

/**
 * 锁粗化
 */
public class SynchronizeUpDemo4 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        for (int i = 0; i < 10; i++) {
            new Thread(
                    ()->{
                        synchronized (o) {
                            System.out.println("11111");
                        }
                        synchronized (o) {
                            System.out.println("2222");
                        }
                        synchronized (o) {
                            System.out.println("3333");
                        }
                        synchronized (o) {
                            System.out.println("4444");
                        }
                        //JIT会优化
                        synchronized (o) {
                            System.out.println("11111");
                            System.out.println("2222");
                            System.out.println("33333");
                            System.out.println("44444");
                        }
                    }
            ,String.valueOf(i)).start();
        }
    }
}
