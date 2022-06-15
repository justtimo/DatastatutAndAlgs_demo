package com.example.demo.fanxing.Chap853;


import com.example.demo.fanxing.Pair;
import org.springframework.cglib.core.Local;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class DateInterval extends Pair<LocalDate> {
    @Override
    public void setSecond(LocalDate second){
        if (second.compareTo(getFirst()) >= 0){
            super.setSecond(second);
        }
    }

    @Override
    public LocalDate getSecond(){
        return (LocalDate) super.getSecond();
    }

    @SafeVarargs
    public static <T> void addAll(Collection<T> coll, T...ts){
        for(T t: ts){
            coll.add(t);
        }
    }

    public static <T> Pair<T> makePair(Class<T> cl){
        try {
            return new Pair<>( cl.getConstructor().newInstance(),cl.getConstructor().newInstance() );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

class Test{
    public static void main(String[] args) {
//        DateInterval dateInterval = new DateInterval();
//        dateInterval.setSecond(LocalDate.now());
//        System.out.println(dateInterval);

        ArrayList<Pair<String>> pairs = new ArrayList<>();
        Pair<String> stringPair = new Pair<>("a", "b");
        Pair<String> stringPair1 = new Pair<>("c", "bd");
        DateInterval.addAll(pairs,stringPair,stringPair1);

    }
}