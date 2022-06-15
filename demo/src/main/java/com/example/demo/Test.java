package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.compara.LengthComparator;
import lombok.Data;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
    @SneakyThrows
    public static void main(String[] args) {
        Test test = new Test();
        Test.printLine("hhhh");
    }
    public static void printLine(String text){
    }

    public static void repeatMessage(String text,int delay){
        ActionListener listener = e -> {
            System.out.println(text);
        };
    }


}
@FunctionalInterface
interface Supply<T>{
    <T> T getString(T t);
}

class Application{
    public void intit(){
        ActionListener listener = e -> {
            System.out.println(this.getClass().toString());
        };
    }
}
class Test1{
    public static void repeat(int n, IntConsumer intConsumer){
        for (int i = 0; i < n; i++) {
            intConsumer.accept(i);
        }
    }

    public static void main(String[] args) {
        repeat(10,i-> System.out.println("count: "+ i));
    }
}

interface IntConsumer{
    void accept(int value);
}
class Test2{
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        HashMap<Integer, String> map = new HashMap<>();
        List<Object> collect = arrayList.parallelStream().map(
                t -> {
                    map.put(t, t.toString());
                    return null;
                }
        ).collect(Collectors.toList());
        System.out.println(map);
    }
}
@Data
class User{
    private String name;
    private String address;
}
class Test3{
    public static void main(String[] args) {
        User user=null;
        user= getUser();
        System.out.println(user);
    }
    static User getUser(){
        User user = new User();
        user.setName("1");
        user.setAddress("addd");
        return user ;
    }
}