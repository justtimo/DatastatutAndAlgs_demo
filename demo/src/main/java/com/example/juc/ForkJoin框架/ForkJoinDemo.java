package com.example.juc.ForkJoin框架;

import org.springframework.validation.annotation.Validated;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0, 100);
        //创建分支合并池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(myTask);
        System.out.println(submit.get());
        forkJoinPool.shutdown();
    }
}

class MyTask extends RecursiveTask<Integer> {
    private final static Integer VALUE = 10;//相差不能超过 10的数才能相加
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    /**
     * 计算,拆分和合并
     *
     * @return {@link Integer}
     */
    @Override
    protected Integer compute() {
        //判断两个值的差是否大于 10
        if ((end - begin) <= VALUE) {
            for (int i = begin; i <= end; i++) {
                result = result + i;
            }
        } else {
            int middle = (begin + end) / 2;
            //拆分左边
            MyTask task = new MyTask(begin, middle);
            //拆分右边
            MyTask task2 = new MyTask(middle+1, end);
            //调用方法拆分
            task.fork();
            task2.fork();
            //合并
            result = task.join() + task2.join();
        }
        return result;
    }
}