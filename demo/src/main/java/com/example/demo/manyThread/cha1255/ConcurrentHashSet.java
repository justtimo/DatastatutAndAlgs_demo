package com.example.demo.manyThread.cha1255;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentHashSet {
    public static void main(String[] args) {
        /**
         * java文档说明了以下这点:
         * 当通过Iterator 、 Spliterator或Stream遍历返回的列表时，用户必须手动同步它
         */
        List<String> strings = Collections.synchronizedList(new ArrayList<String>());
        Map<String, Object> stringObjectMap = Collections.synchronizedMap(new HashMap<String, Object>());
        strings.add("1");

        synchronized (stringObjectMap){
            Iterator<String> iterator = stringObjectMap.keySet().iterator();
            while (iterator.hasNext()){

            }
        }
    }
}
