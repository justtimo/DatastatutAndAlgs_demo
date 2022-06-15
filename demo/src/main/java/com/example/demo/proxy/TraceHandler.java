package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 包装器类存储包装对象
 */
public class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    /**
     * 打印所调用的方法的名字和参数, 用包装的对象作为隐式参数调用这个方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //打印方法名字和参数
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if (args != null){
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i<args.length - 1){
                    System.out.print(", ");
                }
            }
        }
        System.out.println(")");
        // 调用真正的方法.
        return method.invoke(target,args);
    }
}
