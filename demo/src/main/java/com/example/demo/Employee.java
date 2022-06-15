package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Cloneable{
    private String name;
    private Double account;
    private Date hireDay;

    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee)super.clone();

        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }
}
