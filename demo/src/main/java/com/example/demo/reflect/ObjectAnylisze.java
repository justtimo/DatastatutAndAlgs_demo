package com.example.demo.reflect;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnylisze {
    private ArrayList<Object> visited = new ArrayList<>();

    @SneakyThrows
    public String toString(Object obj){
        if (obj == null)
            return "null";
        if (visited.contains(obj))
            return "...";
        visited.add(obj);
        Class<?> cl = obj.getClass();
        if (cl == String.class)
            return (String)obj;
        if (cl.isArray()){
            //cl.getComponentType(): 返回代表数组组件类型的 Class
            Class<?> componentType = cl.getComponentType();
            String r = componentType + "[]{" ;
            //Array.getLength() 获取指定数组对象的长度
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i>0) {
                    r += ",";
                }
                //返回指定数组对象中索引的值
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) {
                    r += val;
                } else {
                    r += toString(val);
                }
            }
            return r + "}";

        }

        String r = cl.getName();
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();

            //为一组对象设置accessible访问标志
            AccessibleObject.setAccessible(fields , true);
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())){
                    if (!r.endsWith("["))
                        r += ",";
                    r += f.getName() + "=";
                    Class<?> t = f.getType();
                    Object val = f.get(obj);
                    if (t.isPrimitive()) {
                        r += val;
                    } else {
                        r += toString(val);
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while (cl!=null);

        return r;

    }
}
class ObjecAnalizyTest{
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnylisze().toString(squares));

    }
}

interface A{
    default String getName(){
        return null;
    }
}
