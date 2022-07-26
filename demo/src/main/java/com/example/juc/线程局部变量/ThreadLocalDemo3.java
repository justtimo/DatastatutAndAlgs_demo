package com.example.juc.线程局部变量;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo3 {
    public static void main(String[] args) throws InterruptedException {
//        strongRefrence();
//        softRefrence();
//        weakRefrence();
        MyObject myObject = new MyObject();
        ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
        PhantomReference<MyObject> phantomReference =
                new PhantomReference<>(myObject, referenceQueue);

        System.out.println(phantomReference.get());

    }

    private static void weakRefrence() throws InterruptedException {
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject());
        System.out.println("gc 内存够用之前:" + weakReference.get());

        System.gc();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("gc之后,内存够用: "+weakReference.get());
    }

    private static void softRefrence() throws InterruptedException {
        SoftReference<MyObject> softReference = new SoftReference<>(new MyObject());
        System.out.println("gcz之前" + softReference.get());

        System.gc();
        System.out.println("gc之后" + softReference.get());
        TimeUnit.SECONDS.sleep(1);

        try {
            byte[] bytes = new byte[10 * 1024 * 1024];
        }finally {
            System.out.println("gc, 在内存不够时:"+softReference.get());
        }
    }

    private static void strongRefrence() {
        MyObject myObject = new MyObject();
        System.out.println("gcz之前" + myObject);

        myObject = null;
        System.gc();

        System.out.println("gc之后" + myObject);
    }
}

class MyObject {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("invoke finalize method()");
    }
}