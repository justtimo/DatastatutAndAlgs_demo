package com.example.datastruct.ch4stack.recursion.eightqueen;

/**
 * 八皇后
 * 一维数组 arr[8] res={0,4,7,5,6,1,2,3} 表示正确解的位置
 * res[0] = 0; 下表表示行 , 值表示列
 */
public class EightQueen {
    private int[] res;

    private final int MAX_SIZE;

    public EightQueen(int max_size) {
        MAX_SIZE = max_size;
        this.res=new int[MAX_SIZE];
    }

    public int getCount() {
        return count;
    }

    int count=0;

    public int getJudgCcount() {
        return judgCcount;
    }

    int judgCcount=0;


    public void print(){
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.print(res[i]+"");
        }
        count++;
        System.out.println();
    }

    /**
     * 判断是否和之前的位置冲突
     *
     * @param n  第几个皇后
     * @return boolean
     */
    public boolean judge(int n){
        judgCcount++;
        for (int i = 0; i < n; i++) {
            if (res[i]==res[n] || Math.abs(n-i)==Math.abs(res[n]-res[i])){
                //同一列  //同一个斜线
                return false;
            }
            //不用判断是否在同一行, 因为 n 就表示行, n 他在递增
        }
        return true;
    }

    /**
     * 放置皇后
     *
     * @param n 第几个皇后
     */
    public void setQueen(int n){
        if (n==MAX_SIZE){
            //说明已经放置了 8 个皇后了
            print();
            return;
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            //从该行第一列开始放置皇后, 并判断是否冲突.
            res[n]=i;
            if (judge(n)){
                //接着放 n+1 个皇后
                setQueen(n+1);
            }
        }

    }
}
class Test{
    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen(8);
        eightQueen.setQueen(0);
        int count = eightQueen.getCount();
        System.out.println("共有:"+count+"种方案. 一共判断了:"+ eightQueen.judgCcount+"次");
    }
}