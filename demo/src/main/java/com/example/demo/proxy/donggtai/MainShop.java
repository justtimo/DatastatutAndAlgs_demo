package com.example.demo.proxy.donggtai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainShop {
    public static void main(String[] args) {
        //1.创建爱你目标对象
        UsbShell usbFactory = new UsbFactory();
        //2.创建 InvocationHandler 对象
        InvocationHandler handler = new MySellhandler(usbFactory);
        //3.创建代理对象
        UsbShell proxy = (UsbShell) Proxy.newProxyInstance(
                usbFactory.getClass().getClassLoader(),
                usbFactory.getClass().getInterfaces(),
                handler
        );
        proxy.sell(2);
    }
}
