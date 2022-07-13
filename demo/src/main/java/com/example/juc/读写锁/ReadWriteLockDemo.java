package com.example.juc.读写锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 6; i++) {
            final  int num =i;
            new Thread(() -> {
                try {
                    myCache.put(num+"",num);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);

        for (int i = 0; i < 6; i++) {
            final  int num =i;
            new Thread(() -> {
                try {
                    myCache.get(num+"");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

    }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object value) throws InterruptedException {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        writeLock.lock();
        System.out.println(Thread.currentThread().getName()+ "正在写操作"+key);
        TimeUnit.SECONDS.sleep(1);

        map.put(key, value);
        System.out.println(Thread.currentThread().getName()+ "已经写完了"+key);
        writeLock.unlock();
    }

    public void get(String key) throws InterruptedException {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();
        System.out.println(Thread.currentThread().getName()+ "正在读操作"+key);
        TimeUnit.SECONDS.sleep(1);

        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName()+ "已经读完了"+result);
        readLock.unlock();
    }

}
