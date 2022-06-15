package com.example.arithmetic.sort.ch8heap;

import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 堆排序
 *
 * 利用堆数据结构设计的排序算法, 是一种选择排序, 不稳定排序. 最坏最好平均的时间复杂度都是 nlogn
 *
 * 堆: 是具有以下性质的二叉树: 每个节点的值都大于或等于左右孩子节点的值(大顶堆. 小顶堆反之). 注意:没有要求左节点的值 和 右节点的值 的大小关系
 *
 * 一般,升序使用大顶堆, 降序使用小顶堆
 *
 * 使用数组的形式表示树
 * 下标与节点的关系为:  大顶堆:a[i]>=a[2i+1]  a[i]>=a[2i+2]     小顶堆换成小于等于即可
 *
 * @author wubingyin
 * @date 2022/02/18
 */
public class HeapSort {
    /**
     * 将一个数组(完全二叉树) 调整为一个 堆
     * @param array 数组 {4,6,8,5,9}
     */
    public void init(int[] array,int index){
        for (int i = index/2-1; i <array.length; i++) {

        }

        //获取最后一个非叶子节点的索引
        int firstNode = array.length/2-1;

        int temp = 0;
        //获得左右
        if (array[firstNode*2+1] > array[firstNode*2+2]){
            temp = array[firstNode*2+1];
            array[firstNode*2+1] = array[firstNode*2+2];
            array[firstNode*2+2] = temp;
        }
        //上下比较
        if (array[firstNode* 2+2] > array[firstNode] ){
            temp = array[firstNode*2+2];
            array[firstNode*2+2] = array[firstNode];
            array[firstNode]  = array[firstNode*2+2];
        }

        //2. 再和该子树
//        if ()
    }
}
class Test{
    public static void main(String[] args) {
        //使用堆排序,升序排列
        /*int array[]= {4,6,8,5,9};
        double floor = Math.ceil(3 / 2 - 1);
        double floor1 = Math.ceil(1 / 2 - 1);
        System.out.println(floor);
        System.out.println(floor1);*/
        LoggingWidget loggingWidget = new LoggingWidget();
//        loggingWidget.doSometthing();
        loggingWidget.name();
        Vector<Object> objects = new Vector<>();
        objects.add("123");
    }
}
class Widget{
    public synchronized void name(){
        System.out.println("Widget中的this 引用:" + this.getClass().getName());
    }
    public synchronized void doSometthing(){
        System.out.println("Widget中的this 引用:" + this.getClass().getName());
    }
}
class LoggingWidget extends Widget{
    @Override
    public void name() {
        super.name();
        System.out.println("LoggingWidget中的 this 引用:"+this.getClass().getName());
        System.out.println("LoggingWidget中的 super 引用:"+super.getClass().getName());
    }

    @Override
    public synchronized void doSometthing() {
        super.doSometthing();
        System.out.println("LoggingWidget中的 this 引用:"+this.getClass().getName());
        System.out.println("LoggingWidget中的 super 引用:"+super.getClass().getName());
        LoggingWidget log1= this;
    }
}

class Test2{
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new ReaderThread().start();
            number = 42;
            ready = true;
        }

    }
}