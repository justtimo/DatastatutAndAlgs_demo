package com.example.juc.多线程锁.原子类;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderDemo1 {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.add(1);//1
        longAdder.add(1);//2
        longAdder.add(1);//3
        System.out.println(longAdder);

        LongAccumulator longAccumulator = new LongAccumulator(
                (x,y)-> x+y,100
        );
        longAccumulator.accumulate(1);//101
        longAccumulator.accumulate(100);//201
        System.out.println(longAccumulator);
    }
}
