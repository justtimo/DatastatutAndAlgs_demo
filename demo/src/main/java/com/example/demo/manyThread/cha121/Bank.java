package com.example.demo.manyThread.cha121;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    public void transfer(int from, int to, double amount){
        if (accounts[from] < amount){
            return;
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d",amount,from,to);
        accounts[to]+=amount;
        System.out.printf("total balance: %10.2f%n",getTotalBalance());
    }

    private double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum+=a;
        }
        return sum;
    }
    public int size(){
        return accounts.length;
    }
}
