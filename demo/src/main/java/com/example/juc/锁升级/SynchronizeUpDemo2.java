package com.example.juc.锁升级;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 锁升级中,hashCOde 去哪了?
 */
public class SynchronizeUpDemo2 {
    public static void main(String[] args) throws InterruptedException {
        qinglaingjisuo();

        zhonglaingjisuo();

    }

    private static void qinglaingjisuo() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);

        Object o = new Object();
        System.out.println("此时是偏向锁");
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        int hashCode = o.hashCode();//计算 hash 后, 他就无法再进入偏向锁状态
        synchronized (o) {
            System.out.println("本是偏向锁, 计算过 hash 后会升级为轻量级锁");
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

    private static void zhonglaingjisuo() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);

        Object o = new Object();
        System.out.println("此时是偏向锁");
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            o.hashCode();//计算 hash 后, 他就无法再进入偏向锁状态
            System.out.println("本是偏向锁, 偏向锁过程中计算 hash 后会膨胀为重量级锁");
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
