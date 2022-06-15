package com.example.datastruct.ch6tree.ch1binaryTree;

import lombok.Data;

@Data
public class Node {
    private int number;
    private String name;
    private Node left;
    private Node right;

    public Node(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preList(){
        //输出当前节点
        System.out.println(this);
        //左
        if (this.left!=null){
            this.left.preList();
        }
        //右
        if (this.right!=null){
            this.right.preList();
        }
    }
    //中序遍历
    public void midList(){
        //左
        if (this.left!=null){
            this.left.midList();
        }
        //输出当前节点
        System.out.println(this);
        //右
        if (this.right!=null){
            this.right.midList();
        }
    }
    //后序遍历
    public void behandList(){
        //左
        if (this.left!=null){
            this.left.behandList();
        }
        //右
        if (this.right!=null){
            this.right.behandList();
        }
        //输出当前节点
        System.out.println(this);
    }

    //前序查找
    public Node preFind(int number){
        if (this.getNumber()==number){
            return this;
        }
        Node result = null;
        if (this.getLeft()!=null){
            result =  this.left.preFind(number);
        }
        if (result!=null){
            return result;
        }
        if (this.right!=null){
            result= this.right.preFind(number);
        }
        return result;
    }
    //中序查找
    public Node middleFind(int number){
        Node result = null;
        if (this.getLeft()!=null){
            result= this.left.middleFind(number);
        }
        if (result!=null){
            return result;
        }
        if (this.getNumber()==number){
            return this;
        }
        if (this.right!=null){
            result= this.right.middleFind(number);
        }
        return result;
    }
    //后序查找
    public Node behandFind(int number){
        Node result = null;
        if (this.getLeft()!=null){
            result= this.left.behandFind(number);
        }
        if (result!=null){
            return result;
        }
        if (this.right!=null){
            result= this.right.behandFind(number);
        }
        if (result!=null){
            return result;
        }
        if (this.getNumber()==number){
            return this;
        }
        return result;
    }

    public void delete(int number) {
        //判断左子节点
        if (this.left!=null && this.left.getNumber()==number){
            if (this.left.getLeft()!=null && this.left.getRight()==null){
                this.left=this.left.getLeft();
                return;
            }else if(this.left.getRight()!=null && this.left.getLeft()==null){
                this.left=this.left.getRight();
                return;
            }else if(this.left.getLeft()!=null && this.left.getRight()!=null){
                Node temp= this.left.getLeft();
                this.left=temp;
                this.left.setLeft(null);
            }

        }
        //判断是否是右节点
        if (this.right!=null&& this.right.getNumber()==number){
            if (this.right.getLeft()!=null && this.right.getRight()==null){
                this.right=this.right.getLeft();
                return;
            }else if(this.right.getRight()!=null && this.right.getLeft()==null){
                this.right=this.right.getRight();
                return;
            }else if(this.right.getLeft()!=null && this.right.getRight()!=null){
                Node temp= this.right.getLeft();
                this.right=temp;
                this.right.setLeft(null);
            }
        }
        //上面的都不是,左递归
        if (this.left!=null){
            this.left.delete(number);
        }
        //右递归
        if (this.right!=null){
            this.right.delete(number);
        }
    }
}
