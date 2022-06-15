package com.example.demo.manyThread.cha1255;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Cloneable, Serializable {
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
