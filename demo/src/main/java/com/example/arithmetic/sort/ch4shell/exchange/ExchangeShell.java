package com.example.arithmetic.sort.ch4shell.exchange;

/**
 * 希尔排序也是一种插入排序: 为了改进插入排序的问题: 如果插入的数是较小的数, 后移的次数太多
 * {2,3,4,5,6,1}
 * {2,3,4,5,6,6}
 * {2,3,4,5,5,6}
 * {2,3,4,4,5,6}
 * {2,3,3,4,5,6}
 * {2,2,3,4,5,6}
 * {1,2,3,4,5,6}
 *
 * 交换法: 效率慢. 10万条: 插入排序 1.4s,  希尔交换排序 12s
 */
public class ExchangeShell {
    public int[] shell(int[] array){
        //{8,9,1,7,2,3,5,4,6,0}; 10个数据
        int step=array.length;
        while (step>=1){
            int temp=0;
            for (int i = step; i < array.length; i++) {
                //5组,每组 2 各元素,步长 5 : {0,5}{1,6}{2,7}{3,8}{4,9}
                for (int j = i-step; j >=0; j-=step) {
                    //如果当前元素大于 +5 后的元素,交换位置
                    if (array[j]>array[j+step]){
                        temp=array[j];
                        array[j]=array[j+step];
                        array[j+step]=temp;
                    }
                }
            }
            step=step/2;
//            System.out.println("第一轮后数组为: "+ Arrays.toString(array));
        }
        /*//第一轮: 分成 10/2=5 组
        int temp=0;

        for (int i = 5; i < array.length; i++) {
            //5组,每组 2 各元素,步长 5 : {0,5}{1,6}{2,7}{3,8}{4,9}
            for (int j = i-5; j >=0; j-=5) {
                //如果当前元素大于 +5 后的元素,交换位置
                if (array[j]>array[j+5]){
                    temp=array[j];
                    array[j]=array[j+5];
                    array[j+5]=temp;
                }
            }
        }
        System.out.println("第一轮后数组为: "+ Arrays.toString(array));

        //第二轮: 分成 10/2/2=5/2=2 组
        for (int i = 2; i < array.length; i++) {
            //2组,每组 5 各元素,步长 2 : {0,2,4,6,8}{1,3,5,7,9}
            for (int j = i-2; j >=0; j-=2) {
                //如果当前元素大于 +2 后的元素,交换位置
                if (array[j]>array[j+2]){
                    temp=array[j];
                    array[j]=array[j+2];
                    array[j+2]=temp;
                }
            }
        }
        System.out.println("第二轮后数组为: "+ Arrays.toString(array));*/

        return array;
    }
}
class Test{
    public static void main(String[] args) {
        int maxSize=100000;
        int[] array=new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i]=(int)(Math.random()*maxSize);
        }
        ExchangeShell shell = new ExchangeShell();
        long start = System.currentTimeMillis();
        int[] shell1 = shell.shell(array);
        long end = System.currentTimeMillis();
        System.out.println("耗时: "+(end-start));
    }
}