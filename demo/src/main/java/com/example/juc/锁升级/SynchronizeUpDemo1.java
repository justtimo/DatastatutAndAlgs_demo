package com.example.juc.锁升级;

import org.openjdk.jol.info.ClassLayout;

public class SynchronizeUpDemo1 {
    public static void main(String[] args) {
        Object o = new Object();
        int hashCode = o.hashCode();
        System.out.println("10进制: "+hashCode);
        System.out.println("16进制: "+Integer.toHexString(hashCode));
        System.out.println("2进制: "+Integer.toBinaryString(hashCode));
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
