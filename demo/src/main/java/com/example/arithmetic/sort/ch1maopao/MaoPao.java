package com.example.arithmetic.sort.ch1maopao;

/**
 * 相邻两个元素比较,大的后移
 */
public class MaoPao {
    public int[] maopao(int[] array){
        int temp;
        //标识变量: 看是否交换过
        boolean flag =false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j]>array[j+1]){
                    flag=true;
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            if (flag){//交换过, 重置 flag
                flag=false;
            }else {//在一次排序中,一次都没有交换过,说明已经有序
                break;
            }
//            System.out.println("第"+(i+1)+"次排序后数组为: "+ Arrays.toString(array));
        }
        return array;
    }
}
class Test{
    public static void main(String[] args) {
        int maxSize=100000;
        int[] arr=new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            arr[i]=(int)(Math.random()*maxSize);
        }
//        int[] arr=new int[]{4,7,9,1,3,22,5,2};
        MaoPao maoPao = new MaoPao();
        long start = System.currentTimeMillis();
        int[] maopao = maoPao.maopao(arr);
        long end = System.currentTimeMillis();
        System.out.println("耗时: "+(end-start));
//        System.out.println(Arrays.toString(maopao));


    }
}