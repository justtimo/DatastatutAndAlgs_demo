package com.example.datastruct.ch5hashtable;

public class EmpLinked {
    private Employee head;

    public void add(Employee employee){
        if (head==null){
            head=employee;
            return;
        }
        /*if (head.getNext()==null){
            head.setNext(employee);
            return;
        }*/
        Employee cur = head;
        while (cur.getNext()!=null){
            cur=cur.getNext();
        }
        cur.setNext(employee);
    }

    public void list(int number){
        if (head==null){
            System.out.println("第"+number+"条链表为空");
            return;
        }
        if (head.getNext()==null){
            System.out.printf("第%d条链表: id=%d  name=%s\t",number,head.getId(),head.getName());
            System.out.println();
            return;
        }
        Employee cur = head;
        while (true){
            System.out.printf("第%d条链表: id=%d  name=%s\t",number,cur.getId(),cur.getName());
            if (cur.getNext()==null){
                break;
            }
            cur=cur.getNext();
        }
        System.out.println();
    }

    public void delete(int id){
        if (head==null){
            System.out.println("空");
            return;
        }
        if (head.getNext()==null && head.getId()!=id){
            System.out.println("删除的数据不存在");
            return;
        }
        Employee cur = head;
        while (cur.getNext()!=null){
            if (cur.getId()==id){
                System.out.println("找到了");
                return;
            }
            cur=cur.getNext();
        }
        if (cur.getId()!=id){
            System.out.println("不存在");
        }
    }

    public Employee find(int id){
        if (head==null){
            System.out.println("null");
            return null;
        }
        Employee cur = head;
        while (true){
            if (cur.getId()==id){
                System.out.println("find");
                return cur;
            }
            if (cur==null){
                System.out.println("null");
                return null;
            }
            cur=cur.getNext();
        }
    }
    //二叉树
}
