package com.example.arithmetic.sort.ch2select;

import com.example.arithmetic.sort.ch1maopao.MaoPao;

/**
 * 每个元素与所有元素比较, 找到最大(最小)依次放在当前的(找完一轮就少遍历一轮,即最大(小)的那个不再参与比较)最后(最前)
 */
public class SelectSort {
    public int[] selectSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex=i;
            int min=array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min=array[j];//重置 min
                    minIndex=j;//重置 minIndex
                }
            }
            //如果最小值不在当前轮次的首位,则交换位置
            if (minIndex!=i){
                array[minIndex]=array[i];
                array[i]=min;
            }
//            System.out.println("第" + (i + 1) + "次排序后数组为: " + Arrays.toString(array));
        }
        return array;
    }
}

class Test {
    public static void main(String[] args) {
        int maxSize=100000;
        int[] arr=new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            arr[i]=(int)(Math.random()*maxSize);
        }
        SelectSort maoPao = new SelectSort();
        long start = System.currentTimeMillis();
        int[] maopao = maoPao.selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("耗时: "+(end-start));
//        System.out.println(Arrays.toString(maopao));
    }
}
