package com.example.demo.proxy.donggtai;

public class UsbFactory implements UsbShell{
    @Override
    public float sell(int amount) {
        System.out.println("目标类中执行目标方法"+ amount*85.2f);
        return amount*85.2f;
    }
}
