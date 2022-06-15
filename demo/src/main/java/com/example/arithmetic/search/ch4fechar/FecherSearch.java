package com.example.arithmetic.search.ch4fechar;

import java.util.Arrays;

/**
 * 斐波那契(黄金分割法)查找算法
 *
 * 原理与 二分,插值类似, 只是 middle 值得取值不同
 * mid =  left+ F(k-1)-1 ;    F 表示斐波那契数列
 *
 * F(k-1)-1的解释:
 *  1. 斐波那契数列 F(k) = F(k-1) + F(k-2) --> F[k]-1 = (F[k-1]-1 + F[k-2]-1 ) +1
 *      该式子说明: 顺序表长度为 F[k]-1, 则可以将表分为 F[k-1]-1 和 F[k-2]-1 的两段. 从而中间位置 mid = left + F(k-1)-1
 *  2. 但是顺序表长度 n 不一定刚好等于F[k]-1, 所以需要将原来的顺序表长度 n 增加到 F[k]-1.
 *      k只需要能使得 F[k]-1 恰好大于或等于n 即可.
 *      while( n>fib(k)-1 ){ k++; }
 *
 * @author wubingyin
 * @date 2022/02/14
 */
public class FecherSearch {
    public int fecherSearch(int[] array, int key){
        int left = 0;
        int right =array.length-1;
        int k=0;//斐波那契数列下标
        int mid = 0;//初始化 mid 值

        int[] f= getFecher(20);

        //获取原数组对应的斐波那契数列的下标值
        while (right>f[k]-1){
            k++;
        }
        //因为符合 right>f[k] 的 f[k] 所在的下标值可能大于 array 原数组的长度, 所以需要将原数组扩展; 并使用原数组的最后一个值替换填充的 0.
        int[] temp = Arrays.copyOf(array,f[k]);
        for (int i = right+1; i < temp.length; i++) {
            temp[i] = array[right];
        }

        //找到 key
        while (left<=right){
            mid = left+f[k-1]-1;
            if (key<temp[mid]){//左
                right=mid-1;
                k--;
            }else if(key>temp[mid]){
                left=mid+1;
                k=k-2;
            }else {
                if (mid<=right){
                    return mid;
                }else {
                    return right;
                }
            }
        }

        return -1;
    }
    public int[] getFecher(int size){
        int[] f = new int[size];
        for (int i = 0; i < size; i++) {
            if (i==0){
                f[i]=1;
            }
            if (i==1){
                f[i]=1;
            }
            if (i>1){
                f[i]=f[i-1]+f[i-2];
            }
        }
        return f;
    }
}
class Test{
    public static void main(String[] args) {
        int[] array = {1,8,10,89,1000,1234};
        FecherSearch fecherSearch = new FecherSearch();
        int[] fecher = fecherSearch.getFecher(20);

        int i = fecherSearch.fecherSearch(array, 10);
        System.out.println(i);

        System.out.println(Arrays.toString(fecher));
    }
}