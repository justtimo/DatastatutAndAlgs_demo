package com.example.datastruct.ch1;

public class LimitArray {
    public static void main(String[] args) {
        //创建二维数组
        int[][] chessArr1 = init2Array(11, 11);
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 3;

        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

        System.out.println("~~~~~~~~~~~~~~");

        int[][] limitArray = TWOArrayToLimitArray(chessArr1);
        for (int[] ints1 : limitArray) {
            for (int anInt : ints1) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        System.out.println("~~~~~~~~~~~~~~");


        int[][] to2Array = limitArrayTo2Array(limitArray);
        for (int[] ints1 : to2Array) {
            for (int anInt : ints1) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

    }

    public static int[][] init2Array(int row, int lie) {
        return new int[row][lie];
    }

    public static int[][] TWOArrayToLimitArray(int[][] twoArray) {

        int sum = 0;
        int row = 0;//行
        int line = 0;// 列
        for (int i = 0; i < twoArray.length; i++) {
            for (int i1 = 0; i1 < twoArray[i].length; i1++) {
                if (twoArray[i][i1] != 0) {
                    sum++;
                }
            }
            line = twoArray[i].length;
        }
        row = twoArray.length;//如果是方阵, 可以直接使用.length 方法获取行列.

        int[][] ints = new int[sum + 1][3];
        ints[0][0] = row;
        ints[0][1] = line;
        ints[0][2] = sum;
        int init = 1;
        for (int i = 0; i < twoArray.length; i++) {
            for (int i1 = 0; i1 < twoArray[i].length; i1++) {
                if (twoArray[i][i1] != 0) {
                    ints[init][0] = i;
                    ints[init][1] = i1;
                    ints[init][2] = twoArray[i][i1];
                    init++;
                }
            }
        }

        System.out.println(sum);
        return ints;
    }

    public static int[][] limitArrayTo2Array(int[][] limitArray){
        int row = 0;
        int line = 0;
        for (int i = 0; i < limitArray.length; i++) {
            if (i==0){
                row = limitArray[0][0];
                line = limitArray[0][1];
            }
        }
        int[][] ints = new int[row][line];

        int rowIndex = 0;
        int lineIndex = 0;
        int result = 0;
        for (int i = 0; i < limitArray.length; i++) {
            if (i!=0){
                rowIndex = limitArray[i][0];
                lineIndex = limitArray[i][1];
                result = limitArray[i][2];
                ints[rowIndex][lineIndex] = result;
            }
        }
        return ints;
    }
}
