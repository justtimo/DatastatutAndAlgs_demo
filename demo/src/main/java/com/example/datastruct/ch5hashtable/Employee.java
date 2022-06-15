package com.example.datastruct.ch5hashtable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee {
    private Integer id;
    private String name;
    private Employee next;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
