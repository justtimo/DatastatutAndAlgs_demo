package com.example.demo.fanxing.cha881;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PairExtends<T> {
    private T first;
    private T second;

    public void setFirst(T first) {
        this.first = first;
    }
}
class Test{
    public static void main(String[] args) {
        PairExtends<Manager> managerPairExtends = new PairExtends<>();
        managerPairExtends.setFirst(new Manager());
        managerPairExtends.setSecond(new Manager());
        PairExtends<? extends Employee> wild = managerPairExtends;
        Manager first = (Manager) wild.getFirst();
        //wild.setFirst(new Employee());

        PairSuper<Manager> managerPairSuper = new PairSuper<>();
        managerPairSuper.setFirst(new Manager());
        managerPairSuper.setSecond(new Manager());
        PairExtends<? super Manager> managerSuper = managerPairExtends;
        Manager first1 = (Manager) managerSuper.getFirst();
        managerPairExtends.setFirst(new Manager());
    }
}