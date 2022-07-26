package com.example.juc.JMM;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class JOLDemo1 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        Customer customer = new Customer();
        System.out.println(ClassLayout.parseInstance(customer).toPrintable());
    }
}

class Customer {//只有对象头的实例对象, 16 字节(忽略压缩指针)
    //1. 没有实例字段.只有对象头 16 字节

    //2. 有两个属性, int 4 字节, boolean 1 字节, 默认满足对其填充, 24 bytes
    int id;
    boolean flag = false;
}
