package com.example.juc.线程局部变量;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo2 {
    public static void main(String[] args) throws InterruptedException {
        new Thread();
        Mydata mydata = new Mydata();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        try{
            for (int i = 0; i < 10; i++) {
                threadPool.submit(
                        () ->{
                            try {
                                Integer before = mydata.threadLocal.get();
                                mydata.saleVolumeByThreadLocal();
                                Integer after = mydata.threadLocal.get();
                                System.out.println(Thread.currentThread().getName() + "\t" + "beforeInt: " + before + "\tafterInt:" + after);
                            } finally {
//                                mydata.threadLocal.remove();
                            }
                        }
                );
            }
        }catch(Exception e ){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }
}

//资源类
class Mydata {
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public void saleVolumeByThreadLocal() {
        threadLocal.set(1 + threadLocal.get());
    }
}