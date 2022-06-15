package com.example.demo.staticcc;

import lombok.Getter;

public class StaticInnerClass {
    public static void main(String[] args) {
        double[] values = new double[5];
        for (int i = 0; i < values.length; i++) {
            values[i] = 100*Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.Pair.minmax(values);
        System.out.println("min= "+p.getFirst());
        System.out.println("max= "+p.getSecond());

        ArrayNormal arrayNormal = new ArrayNormal();
        ArrayNormal.Pair pair = arrayNormal.new Pair(1.1,2.2);
        ArrayAlg.Pair minmax = pair.minmax(values);
        System.out.println("min1= "+p.getFirst());
        System.out.println("max1= "+p.getSecond());
    }
}
class ArrayNormal{
    public class Pair{
        @Getter
        private double first;
        @Getter
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
            System.out.println(this.getClass());
        }

        public ArrayAlg.Pair minmax(double[] values){
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            for (double value : values) {
                if (min > value){
                    min = value;
                }
                if (max < value){
                    max = value;
                }
            }
            return new ArrayAlg.Pair(min,max);
        }
    }
}
class ArrayAlg{
    //使用静态内部类原因:
    //1. 不生成外围类对象的引用
    //2. minmax 方法时静态的
    public static class Pair{
        @Getter
        private double first;
        @Getter
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }
        public static Pair minmax(double[] values){
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            for (double value : values) {
                if (min > value){
                    min = value;
                }
                if (max < value){
                    max = value;
                }
            }
            return new Pair(min,max);
        }
    }
}