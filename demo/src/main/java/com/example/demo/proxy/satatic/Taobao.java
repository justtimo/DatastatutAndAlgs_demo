package com.example.demo.proxy.satatic;

/**
 * 商家: 即代理对象
 */
public class Taobao implements UsbSell{
    private UsbSell factory = new UsbFactory();
    @Override
    public float sell(int amount) {
        float sell = factory.sell(amount);
        System.out.println("出厂价:"+sell);
        //商家加价的行为, 即: 增强功能
        System.out.println("商家卖: "+ sell*1.25f);
        return sell * 1.25f;//商家加价卖

    }
}
