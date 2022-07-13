package com.example.juc.集合安全;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * 集合不安全, list 演示
 *
 * @author wubingyin
 * @date 2022/07/11
 */
public class ThreadDEmo1 {

    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<>();
//        List<String> strings = new Vector<>();  //不推荐
//        List strings = Collections.synchronizedList(new ArrayList<>());//不推荐
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                strings.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(strings);//此处造成并发修改问题
            },String.valueOf(i)).start();
        }
    }
}
