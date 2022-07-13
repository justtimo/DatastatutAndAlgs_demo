package com.example.juc.读写锁;

import org.springframework.beans.factory.annotation.AnnotationBeanWiringInfoResolver;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁降级过程
 *
 * @author wubingyin
 * @date 2022/07/12
 */
public class ReadWriteLockDemo2 {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

        //读锁不能升级为写锁
        //2.获取读锁
        readLock.lock();
        System.out.println("获取读锁.......");
        //1.获取写锁
        writeLock.lock();
        System.out.println("获取写锁...");


        /*//锁降级过程
        //1.获取写锁
        writeLock.lock();
        System.out.println("获取写锁...");
        //2.获取读锁
        readLock.lock();
        System.out.println("获取读锁.......");
        //3.释放写锁
        writeLock.unlock();
        System.out.println("释放写锁.....");
        //4.释放读锁
        readLock.unlock();
        System.out.println("释放读锁.....");*/

    }
}
