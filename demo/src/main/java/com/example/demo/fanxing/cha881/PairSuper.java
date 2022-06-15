package com.example.demo.fanxing.cha881;

import com.example.demo.exception1.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PairSuper <T>{
    private T first;
    private T second;
}
class Tst{
    public static <T> boolean hasNull(PairSuper<T> p){
        return p.getFirst() == null || p.getSecond()==null;
    }
}