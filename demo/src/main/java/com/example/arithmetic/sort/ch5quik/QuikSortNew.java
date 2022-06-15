package com.example.arithmetic.sort.ch5quik;

import java.util.Arrays;

public class QuikSortNew {
    public void quik(int[] array, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        //轴值必须使用变量保存,而不能值保存一个轴值的索引
        int middle = array[(rightIndex + leftIndex) / 2];
//        int middle = (rightIndex + leftIndex) / 2;  error
        int temp = 0;
        while (left < right) {
            //从小到大排列. 指针移动:left在首位右移, right 在尾部左移
            //即: midlle 左边小 ; middle 右边大
            //-9,-78,0,23,0,-567,70
            while (array[left] < middle) {
                left += 1;
            }
            while (array[right] > middle) {
                right -= 1;
            }
            //左指针 大于等于 右指针 ,说明左右两部分 已经按照规则(左边的小于 middle,右边的大于 middle)排序好了
            if (left >= right) {
                break;
            }
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            //判断当前交换的数 和 middle 值相等的情况.  即 array[1 <left>] = array[2 <middle>] 或者 array[2 <middle>] = array[3 <right>] = 0; 或者都相等的情况
            //此时需要再次手动移动指针
            //这种是因为: 左半部分向middle遍历(即左半部分向右遍历),一直都符合小于 middle 的规则,导致,left 移动到了 middle, 然后与 array[right]交换, 则此时 array[left]=array[middle]
            if (array[left] == middle) {
//                left++;
                right -= 1;
            }
            //同上. 右半部分向middle 遍历,一直都符合大于 middle导致此时 array[right]=array[middle]
            if (array[right] == middle) {
//                right--;
                left += 1;
            }
        }
        //退出 while 循环时说明当前左右部分已经遍历完成,此时有两种情况
        // 情况 1: 交换完成后array[left] 或 array[right] 与 array[middle]的值相等的情况 ,因为已经对指针进行过处理.所以不再进行判断这种情况
        // 情况 2: left = right = middle
        if (left == right) {
            left += 1;
            right -= 1;
        }

        //左半部分递归
        if (leftIndex < right) {
            quik(array, leftIndex, right);
        }
        //右半部分递归
        if (rightIndex > left) {
            quik(array, left, rightIndex);
        }
    }
}
class Test1 {
    public static void main(String[] args) {
        int maxSize = 100000;
        int array[] = {-9,  -78, 0, 23, -567, 70};
//        int array[] = {-9, 11, -78, 0, 23, 0, -567, 70};
        /*int[] array=new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i]=(int)(Math.random()*maxSize);
        }*/

        QuikSortNew quikSort = new QuikSortNew();
        long start = System.currentTimeMillis();
        quikSort.quik(array, 0, array.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + "数组是:" + Arrays.toString(array));

    }
}