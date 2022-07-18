package com.example.juc.多线程锁;

public class LockCompierDemo {
    Object o = new Object();

    public void m1(){
        synchronized (o) {
            System.out.println("同步代码块");
            throw new RuntimeException("111");
        }
    }
    public synchronized void m2(){
            System.out.println("同步方法");
//            throw new RuntimeException("111");
    }
    public static synchronized void m3(){
        System.out.println("静态同步方法");
//            throw new RuntimeException("111");
    }
    public static void main(String[] args) {

    }
}
