package com.example.arithmetic.sort.ch6merge;

import com.example.arithmetic.sort.ch5quik.QuikSortWrong;

public class MergeSort {

    /**
     * 分割+合并
     *
     * @param array 原始数组
     * @param left  左边界
     * @param right 右边界
     * @param temp  临时数组
     */
    public void partition(int[] array,int left,int right,int[] temp){
        if (left<right){
            int middel = (left+right)/2;
            //1. 左递归
            partition(array,left,middel,temp);
            //2. 右递归
            partition(array,middel+1,right,temp);
            //3. 合并
            merge(array,left,middel,right,temp);
        }
    }

    /**
     * 合并
     *
     * @param array  原始数组
     * @param left   左边有序序列的初始索引
     * @param middle 中间索引
     * @param right  右边索引
     * @param temp   做中转的数组
     */
    public void merge(int[] array,int left,int middle,int right,int[] temp){
        int i=left;//初始化 i,左边有序序列的初始索引
        int j=middle+1;//初始化 j,右边有序序列的初始索引
        int t=0;//指向 temp 数组的当前索引.

        //1. 按顺序填充到临时数组 temp
        while (i<=middle && j<=right){
            if (array[i]<=array[j]){
                temp[t]=array[i];
                t++;
                i++;
            }else {
                temp[t]=array[j];
                t++;
                j++;
            }
        }
        //2. 把剩余的元素依次填充到临时数组 temp
        while (i<=middle){
            temp[t]=array[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t]=array[j];
            j++;
            t++;
        }
        //3.将临时数组的数据拷贝到原数组
        t=0;
        int mergeLeft=left;
        while (mergeLeft<=right){
            array[mergeLeft]=temp[t];
            t++;
            mergeLeft++;
        }
    }
}
class Test{
    public static void main(String[] args) {
        int maxSize = 200000;
//        int[] array= {8,4,5,7,1,3,6,2};
        int[] array=new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i]=(int)(Math.random()*maxSize);
        }

        int[] temp=new int[array.length];
        MergeSort mergeSort = new MergeSort();
        long start = System.currentTimeMillis();
        mergeSort.partition(array,0,array.length-1,temp);
        long end = System.currentTimeMillis();

        System.out.println("耗时: " + (end - start) /*+ "数组是:" + Arrays.toString(array)*/);
    }
}
