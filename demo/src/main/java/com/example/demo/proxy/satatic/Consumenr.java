package com.example.demo.proxy.satatic;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

public class Consumenr {
    @SneakyThrows
    public static void main(String[] args) {
//        Taobao taobao = new Taobao();
//        taobao.sell(2);

        Method method = Taobao.class.getMethod("sell", int.class);
        Object invoke = method.invoke(new Taobao(), 2);

    }
}
