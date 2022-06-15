package com.example.demo.fanxing.char866;

import java.lang.reflect.Array;

public class ArrayList<E> {
    private Object[] elements;

    @SuppressWarnings("unckecked")
    public E get(int n){
        return (E) elements[n];
    }

    public void set(int n,E e){
        elements[n] = e;// 无需转换
    }
}

class ArrayList2<E> {
    private E[] elements;

    public ArrayList2() {
        this.elements = (E[]) new Object[10];
    }
}

class ArrayList3<E> {
    private E[] elements;

    public static <T extends Comparable> T[] minmanx(T... a){
        var result = (T[]) Array.newInstance(a.getClass().getComponentType(),2);
        return null;
    }
}
