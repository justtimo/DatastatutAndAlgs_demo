package com.example.demo.proxy.donggtai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MySellhandler implements InvocationHandler {
    private Object target;

    /**
     * 动态代理是动态的, 通过构造器传入目标对象
     * @param target
     */
    public MySellhandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行目标方法
        Object result = method.invoke(target, args);
        //增强功能
        result = (float)result * 1.25f;
        System.out.println("代理类方法执行了:"+result);
        return result;
    }
}
