package com.example.arithmetic.sort.ch4shell;

public class MoveShell {
    public int[] moveShell(int[] array){
        int step=array.length;
        //缩小增量
        while (step>=1){
            int temp=0;
            for (int i = step; i < array.length; i++) {
                //使用直接插入方式
                //记录最小值, 最小值索引
                int j=i;
                int min = array[j];
                if (array[j]>array[j-step]){
                    while (j-step>0 && min<array[j-step]){
                        array[j]=array[j-step];
                        j=j-step;
                    }
                    array[j]=min;
                }
            }
            step=step/2;
        }
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

        MoveShell shell = new MoveShell();
        long start = System.currentTimeMillis();
        int[] shell1 = shell.moveShell(array);
        long end = System.currentTimeMillis();
        System.out.println("耗时: "+(end-start));
    }
}