package com.example.demo.manyThread.cha1255;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Manager extends Employee {
    private Employee secretary;

    public Manager(String name, Double account, Date hireDay) {
        super(name, account, hireDay);
    }

}
