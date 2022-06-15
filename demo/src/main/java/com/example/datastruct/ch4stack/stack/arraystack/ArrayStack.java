package com.example.datastruct.ch4stack.stack.arraystack;

/**
 * 应用场景:
 * 1. 子程序调用: 跳往子程序前,会先将下个指令的地址存到堆栈中, 直到子程序执行完再将地址取出,以回到原来的程序中.
 * 2. 处理递归调用: 和子程序调用类似, 除了存储下一个指令地址外, 还存储参数,区域变量等数据到堆栈中
 * 3. 表达式的转换[中缀表达式 转 后缀表达式]与求值
 * 4. 二叉树的遍历
 * 5. 图形的深度优先(depth-first)搜索法
 */
public class ArrayStack {
    private int maxSize;
    private int index;
    private String[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize=maxSize;
        stack=new String[maxSize];
        index=-1;
    }
    private boolean isFull(){
        return index==maxSize-1;
    }
    public boolean ifEmpty(){
        return index==-1;
    }

    public void add(String s){
        if (isFull()){
            throw new RuntimeException("已经满了");
        }
        stack[index+1]=s;
        index++;
    }

    public void add(int num){
        for (int i = 0; i < num; i++) {
            if (stack[i]==null){
                stack[i]=String.valueOf(i);
                index++;
            }
        }
    }
    public void remove(){
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] != null && stack[i+1]==null){
                stack[i]=null;
                index--;
            }
        }
    }
}
class Test{
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(20);
        stack.add(10);
        stack.remove();

        System.out.println(stack);
    }
}