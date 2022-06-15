package com.example.arithmetic.sort.ch5quik;

/**
 * 对冒泡排序的改进: 通过一趟排序将数据分割为两部分, 其中一部分的所有数据都比另一部分的所有数据小; 然后再对两部分重复上述操作(即,递归)
 */
public class QuikSortWrong {
    public void quik(int[] array, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        int middle = array[(rightIndex + leftIndex) / 2];
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
            if (left == right) {
                break;
            }
            if (array[left]!=array[right]){
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

            //判断当前交换的数 和 middle 值相等的情况.  即 array[1 <left>] = array[2 <middle>] 或者 array[2 <middle>] = array[3 <right>] = 0; 或者都相等的情况
            //此时需要再次手动移动指针
            //这种是因为: 左半部分向middle遍历(即左半部分向右遍历),一直都符合小于 middle 的规则,导致,left 移动到了 middle, 然后与 array[right]交换, 则此时 array[left]=middle
            if (array[left] == middle) {
                //当左指针移动到了中
                right -= 1;
            }
            //同上. 右半部分向middle 遍历,一直都符合大于 middle导致此时 array[right]=middle
            if (array[right] == middle) {
                left += 1;
            }
        }
        //此时左右部分已经处理过了, 分别移动一次, 当做递归的新边界
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

class Test {
    public static void main(String[] args) {
        int maxSize = 100000;
//        int array[] = {-9, 11, -78, 0, 23, 0, -567, 70};
        int[] array=new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i]=(int)(Math.random()*maxSize);
        }

        QuikSortWrong quikSortWrong = new QuikSortWrong();
        long start = System.currentTimeMillis();
        quikSortWrong.quik(array, 0, array.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) /*+ "数组是:" + Arrays.toString(array)*/);

    }
}