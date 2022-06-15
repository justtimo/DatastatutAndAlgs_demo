package com.example.demo.stream;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version 1.02 2019-08-28
 * @author Cay Horstmann
 */
public class CountLongWords
{
   public  Path getPath(){
      File file = new File("alice30.txt");
      String path = file.getPath();
      Path of = Path.of(path);
      return of;
   }
   public static Stream<String> codePoints(String s){
      ArrayList<String> strings = new ArrayList<>();
      int i = 0;
      while (i < s.length()) {
         int j = s.offsetByCodePoints(i, 1);
         strings.add(s.substring(i, j));
         i = j;
      }
      return strings.stream();
   }
   public static ArrayList<String> codePointsList(String s){
      ArrayList<String> strings = new ArrayList<>();
      int i = 0;
      while (i < s.length()) {
         int j = s.offsetByCodePoints(i, 1);
         strings.add(s.substring(i, j));
         i = j;
      }
      return strings;
   }
   public static void main(String[] args) throws IOException
   {
      List<String> words = List.of("121","ww","www","qqq","qweqwe","1","2","3");
      Stream<Stream<String>> result = words.stream().map(s -> codePoints(s));

      Stream<Double> limit = Stream.generate(()->Math.random()).limit(2);
      //无限流 --> 只包含两个元素的流
      List<Double> collect = limit.collect(Collectors.toList());

      Stream<ArrayList<String>> arrayListStream = Stream.of(codePointsList("we are chainpian, lalalal"),codePointsList("you are losers, hahaha"));
      List<ArrayList<String>> collect2 = arrayListStream.collect(Collectors.toList());
      //skip(1)去除了第一个"we are chainpian, lalalal"列表
      Stream<ArrayList<String>> skip = Stream.of(codePointsList("we are chainpian, lalalal"),codePointsList("you are losers, hahaha")).skip(1);
      List<ArrayList<String>> collect3 = skip.collect(Collectors.toList());

      //条件为真时,获取流中的所有元素,然后停止. strings=["w","e"]
      List<String> strings = codePointsList("we are chainpian, lalalal").stream().takeWhile(t -> !t.isBlank()).collect(Collectors.toList());
      //条件为真时丢弃元素,产生由第一个使条件为假的元素开始的所有元素组成的流: strings1 = [去除"w"和"e"之外的, 包含空格的所有字符]
      List<String> strings1 = codePointsList("we are chainpian, lalalal").stream().dropWhile(t -> !t.isBlank()).collect(Collectors.toList());

      List<ArrayList<String>> collect1 =
              Stream.concat(Stream.of(codePointsList("we are chainpian, lalalal")), Stream.of(codePointsList("you are losers, hahaha"))).collect(Collectors.toList());

      System.out.println(collect);

   }
}
