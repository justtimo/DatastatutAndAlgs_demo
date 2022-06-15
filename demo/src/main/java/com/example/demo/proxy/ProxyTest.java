package com.example.demo.proxy;

import java.lang.reflect.Proxy;
import java.security.Key;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[100];

        //用代理对象填充数据
        for (int i = 0; i < elements.length; i++) {
            Integer value = i+1;
            //构造器包装
            TraceHandler handler = new TraceHandler(value);
            //为一个或多个接口构造代理
            Class[] interfaces = new Class[] {Comparable.class};
            elements[i] = Proxy.newProxyInstance(
                    ClassLoader.getSystemClassLoader(),
                    interfaces ,
                    handler
            );
        }

        //构造随机数
        int key = new Random().nextInt(elements.length) + 1;
        //查找. binarySearch方法会有以下调用:elemerts[i].compareTo(key) < 0, 由于数组填充了代理对象,compareTo方法会调用 Tracehandler 中的 invoke 方法
        int result = Arrays.binarySearch(elements, key);
        //如果匹配就打印
        if (result >= 0){
            System.out.println(elements[result]);
        }
    }
}
