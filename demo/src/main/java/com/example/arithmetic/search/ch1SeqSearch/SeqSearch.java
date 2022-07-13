package com.example.arithmetic.search.ch1SeqSearch;


import java.nio.ByteBuffer;
import java.util.concurrent.locks.LockSupport;

/**
 * 线性查找: 找到一个就返回
 *
 * @author wubingyin
 * @date 2022/02/14
 */
public class SeqSearch {
    public int search(int[] array,int value){
        for (int i = 0; i < array.length; i++) {
            if (array[i]==value){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        ByteBuffer.allocateDirect(1024);
    }
}
