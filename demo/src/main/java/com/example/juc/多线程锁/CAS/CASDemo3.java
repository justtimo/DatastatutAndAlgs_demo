package com.example.juc.多线程锁.CAS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 使用版本+CAS 解决 ABA 问题
 *
 * @author wubingyin
 * @date 2022/07/18
 */
public class CASDemo3 {
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) throws InterruptedException {

        new Thread(
                ()->{
                    int stamp = stampedReference.getStamp();
                    System.out.println(Thread.currentThread().getName()+"首次版本号"+"\t"+stamp);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    stampedReference.compareAndSet(100, 101, stampedReference.getStamp(), stampedReference.getStamp() + 1);
                    System.out.println(Thread.currentThread().getName()+"\t2 次修改"+stampedReference.getStamp());

                    stampedReference.compareAndSet(101, 100, stampedReference.getStamp(), stampedReference.getStamp()+1);
                    System.out.println(Thread.currentThread().getName()+"\t3 次修改"+stampedReference.getStamp());
                }
        ,"A").start();

        new Thread(
                ()->{
                    int stamp = stampedReference.getStamp();
                    System.out.println(Thread.currentThread().getName()+"首次版本号"+"\t"+stamp);
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    boolean b = stampedReference.compareAndSet(100, 101, stamp, stamp + 1);
                    System.out.println(Thread.currentThread().getName()+"\t"+b+"\t"+stampedReference.getStamp());
                }
                ,"B").start();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Book{
    private int id;
    private String name;
}