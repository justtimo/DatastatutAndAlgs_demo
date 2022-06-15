package com.example.demo.proxy.satatic;

/**
 * usb厂家, 不接受用户单独购买. 厂家: 目标对象
 */
public class UsbFactory implements UsbSell{
    @Override
    public float sell(int amount) {
        return amount*85.0f;
    }
}
