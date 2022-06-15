package com.example.datastruct.ch6tree.ch2orderBinaryTree;

/**
 * 顺序存储二叉树
 * 数组存储方式与树的存储方式可以相互转换. 遍历数组时任然可以使用树的前中后序方式遍历
 *
 * 应用:
 * 八大排序中的堆排序
 *
 * 特点:
 * 1. 通常只考虑完全二叉树
 * 2. 第 n 个元素的左子节点为 2n+1
 * 3. 第 n 个元素的右子节点为 2n+2
 * 4. 第 n 个元素的父节点为 (n-1)/2
 * n 表示 二叉树中的第几个元素,对应数组中的下标,从 0 开始
 */
public class OrderBonaryTree {
    private int[] array;

    public OrderBonaryTree(int[] array) {
        this.array = array;
    }

    /**
     * 前序遍历
     *
     * @param index 索引
     */
    public void preList(int index){
        if (array==null||array.length==0){
            System.out.println("array is null");
        }
        //输出root元素
        System.out.println(array[index]);
        //左递归: 条件:不越界
        if (index*2+1 <=array.length-1){
            preList(index*2+1);
        }
        //右递归: 条件:不越界
        if (index*2+2 <=array.length-1){
            preList(index*2+2);
        }
    }
}
class Test{
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        OrderBonaryTree orderBonaryTree = new OrderBonaryTree(array);
        orderBonaryTree.preList(0);
    }
}