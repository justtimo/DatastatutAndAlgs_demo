package com.example.arithmetic.search.ch2birnarySerach;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找: 数组必须有序
 *
 * @author wubingyin
 * @date 2022/02/14
 */
public class BinarySerch {

    /**
     * 二分搜索
     *
     * @param array       数组
     * @param left        左
     * @param right       正确
     * @param searchValue 搜索值
     * @return int
     */
    public int search(int[] array, int left,int right,int searchValue){
        if (left>right){
            return -1;
        }
        int midlle = (left+right)/2;
        int middleValue = array[midlle];
        if (middleValue>searchValue){//向左递归
            return search(array,left,midlle-1, searchValue);
        }else if (middleValue<searchValue){//右递归
            return search(array,midlle+1,right,searchValue);
        }else {
            return midlle;
        }
    }

    public List searchAll(int[] array, int left, int right, int searchValue){
        if (left>right){
            return null;
        }
        int midlle = (left+right)/2;
        int middleValue = array[midlle];
        if (middleValue>searchValue){//向左递归
            return searchAll(array,left,midlle-1, searchValue);
        }else if (middleValue<searchValue){//右递归
            return searchAll(array,midlle+1,right,searchValue);
        }else {
            ArrayList<Integer> integers = new ArrayList<>();
            int temp= midlle-1;
            //向左扫描
            while (true){
                if (temp<0 || array[temp]!=searchValue){
                    break;
                }else {
                     integers.add(temp);
                     temp--;
                }
            }
            integers.add(midlle);
            //向右扫描
            temp = midlle+1;
            while (true){
                if (temp>array.length-1 || array[temp]!=searchValue){
                    break;
                }else {
                    integers.add(temp);
                    temp++;
                }
            }
            return integers;
        }
    }
}
class Test{
    public static void main(String[] args) {
        int[] array={2,6,8,11,23,93,101,102,102,203};
        BinarySerch binarySerch = new BinarySerch();
//        int search = binarySerch.search(array, 0, array.length - 1, 23);
        List list = binarySerch.searchAll(array, 0, array.length - 1, 102);

        System.out.println(list.toString());
    }
}
