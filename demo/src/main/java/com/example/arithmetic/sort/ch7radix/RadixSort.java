package com.example.arithmetic.sort.ch7radix;

/**
 * 基数排序: 分配式排序,又称作"桶子法". 通过键值的各个位的值, 将要排序的元素分配到某些桶中,达到排序的作用
 *
 * 稳定性排序(3,4,1,2,1->排序后, 在前面的 1 依旧在前面), 是一种高效的稳定性排序
 *
 * 基数排序是桶排序的扩展
 *
 * 实现: 将整数按位数切割为不同的数字,然后按每个位数分别比较
 *
 * @author wubingyin
 * @date 2022/02/14
 */
public class RadixSort {

    public void radix(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i]>max){
                max=array[i];
            }
        }
        int maxLength = (max+"").length();

        //桶: 10 个 array.length 的桶
        int[][] bucket = new int[10][array.length];
        //存储 bucket 对应几号桶放入了几个元素
        int[] bucketCount = new int[10];
        for (int i = 0; i < maxLength; i++) {
            //按照位的大小放入对应的桶中
            for (int j = 0; j < array.length; j++) {
                //计算对应位是几
                int bucketNumber = (int) (array[j]/(Math.pow(10,i))%10);
                //放入对应的桶中
                bucket[bucketNumber][bucketCount[bucketNumber]] = array[j];
                //对应桶的数量+1
                bucketCount[bucketNumber]++;
            }

            //取出桶中的元素,放入原数组中
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {// 几个桶
                if (bucketCount[k]!=0){
                    for (int j = 0; j < bucketCount[k]; j++) {//当前桶的元素个数
                        array[index] = bucket[k][j];
                        index++;
                    }
                }
                //把当前计数桶的数量重置
                bucketCount[k]=0;
            }
        }
        //System.out.println("bucket 中的数据是"+Arrays.deepToString(bucket));

    }
}
class Test{
    public static void main(String[] args) {
//        int[] array= {53,3,542,748,14,214};

        int maxSize = 200000;
        int[] array=new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i]=(int)(Math.random()*maxSize);
        }

        int[] temp=new int[array.length];
        RadixSort radixSort = new RadixSort();
        long start = System.currentTimeMillis();
        radixSort.radix(array);
        long end = System.currentTimeMillis();

        System.out.println("耗时: " + (end - start) /*+ "数组是:" + Arrays.toString(array)*/);



//        System.out.println(Arrays.toString(array));
    }
}