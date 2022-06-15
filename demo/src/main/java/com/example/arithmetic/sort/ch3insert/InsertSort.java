package com.example.arithmetic.sort.ch3insert;

import com.example.arithmetic.sort.ch2select.SelectSort;

public class InsertSort {
    public int[] insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int insertVal = array[i];
            int insertIndex = i-1;//array[1]之前的元素

            while (insertIndex>=0 && insertVal<array[insertIndex]){//保证不越界,并且待插入的数要小于前面的数
                //交换位置
                array[insertIndex+1] = array[insertIndex];
                insertIndex--;//继续往前找
            }
            //找到了插入位置
            if (insertIndex+1 != i){
                array[insertIndex+1]=insertVal;
            }
        }
        return array;
        /*//第一轮 {101,34,119,1} -> {34,101,119,1}
        //定义待插入数,和待插入位置的索引
        int insertVal = array[1];
        int insertIndex = 1-1;//array[1]之前的元素

        while (insertIndex>=0 && insertVal<array[insertIndex]){//保证不越界,并且待插入的数要小于前面的数
            //交换位置
            array[insertIndex+1] = array[insertIndex];
            insertIndex--;//继续往前找
        }
        //找到了插入位置
        array[insertIndex+1]=insertVal;

        //第 2 轮
        insertVal = array[2];
        insertIndex = 2-1;//array[1]之前的元素

        while (insertIndex>=0 && insertVal<array[insertIndex]){//保证不越界,并且待插入的数要小于前面的数
            //交换位置
            array[insertIndex+1] = array[insertIndex];
            insertIndex--;//继续往前找
        }
        //找到了插入位置
        array[insertIndex+1]=insertVal;*/
    }
}
class Test{
    public static void main(String[] args) {
        int maxSize=100000;
        int[] arr=new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            arr[i]=(int)(Math.random()*maxSize);
        }
        InsertSort maoPao = new InsertSort();
        long start = System.currentTimeMillis();
        int[] maopao = maoPao.insertSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("耗时: "+(end-start));
    }
}