package com.example.arithmetic.search.ch3insertSearch;

import java.text.BreakIterator;

/**
 * 插值查找
 * <p>
 * 扩展自二分查找: 但是使用的是自适应的 middle 值.
 * <p>
 * 二分查找的 middle 值: low+ 1/2 (hight-low)
 * <p>
 * 插值查找的自适应 middle 值: left + (right - left) * (searchValue - array[left]) / (array[right] - array[left]);
 * key 就是需要查找的值
 * <p>
 * 注意:
 * 1. 在数据量大,分布比较均匀的情况下, 插值速度比较快
 * 2. 分布不均匀的情况下, 插值不一定比二分查找块
 *
 * @author wubingyin
 * @date 2022/02/14
 */
public class InsertSearch {

    public int insertSearch(int[] array, int left, int right, int searchValue) {
        if (left > right) {
            return -1;
        }
        if (searchValue < array[0] || searchValue > array[array.length - 1]) {
            return -1;
        }
        int middle = left + (right - left) * (searchValue - array[left]) / (array[right] - array[left]);
        int middleValue = array[middle];
        if (searchValue > middleValue) {//右递归
            return insertSearch(array, middle + 1, right, searchValue);
        } else if (searchValue < middleValue) {
            //左递归
            return insertSearch(array, left, middle - 1, searchValue);
        } else {
            return middle;
        }
    }
}

class Test {
    public static void main(String[] args) {
        InsertSearch insertSearch = new InsertSearch();
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        int i = insertSearch.insertSearch(array, 0, array.length - 1, 47);
        System.out.println(i);
    }
}