package com.example.arithmetic.sort.ch2select;

public class SelectSortLow {
    public int[] selectSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            //TODO 可优化: 设置一个 minIndex, 在 14行,可以添加判断,当 minIndex=i时不在需要执行赋值
            int min = 0;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    min=array[i];
                }
            }
            array[i]=min;
//            System.out.println("第" + (i + 1) + "次排序后数组为: " + Arrays.toString(array));
        }
        return array;
    }
}

class Test1 {
    public static void main(String[] args) {
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]=(int)(Math.random()*80000);
        }
        SelectSortLow maoPao = new SelectSortLow();
        long start = System.currentTimeMillis();
        int[] maopao = maoPao.selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("耗时: "+(end-start));
//        System.out.println(Arrays.toString(maopao));
    }
}
