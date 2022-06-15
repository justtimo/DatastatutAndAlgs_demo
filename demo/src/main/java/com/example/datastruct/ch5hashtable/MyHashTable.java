package com.example.datastruct.ch5hashtable;

public class MyHashTable {
    public EmpLinked[] empLinkeds;
    public int size;

    public MyHashTable(int size) {
        this.size = size;
        empLinkeds=new EmpLinked[size];
        //坑. 需要初始化,否则数组中的链表对象是 null
        for (int i = 0; i < size; i++) {
            empLinkeds[i] = new EmpLinked();
        }
    }

    public void add(Employee employee){
        int hash = hash(employee.getId());
        empLinkeds[hash].add(employee);
    }
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkeds[i].list(i);
        }
    }
    public Employee find(int id){
        int hash = hash(id);
        return empLinkeds[hash].find(id);
    }
    public void delete(int id){
        int hash = hash(id);
        empLinkeds[hash].delete(id);
    }

    public int hash(int id){
        return id%size;
    }
}
class Tesst{
    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable(7);
        myHashTable.add(new Employee(0,"tom"));
        myHashTable.add(new Employee(1,"tom"));
        myHashTable.add(new Employee(2,"tom"));
        myHashTable.add(new Employee(3,"tom"));
        myHashTable.add(new Employee(4,"tom"));
        myHashTable.add(new Employee(5,"tom"));
        myHashTable.add(new Employee(6,"tom"));
        myHashTable.add(new Employee(7,"tom"));
        myHashTable.add(new Employee(8,"tom"));

        myHashTable.list();

        Employee employee = myHashTable.find(4);
        System.out.println(employee);
    }
}