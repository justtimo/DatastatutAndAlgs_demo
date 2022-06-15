package com.example.demo.exception1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.EmptyStackException;
import java.util.Locale;
import java.util.Scanner;

public class FileFOrmatException  {
    public static <T extends Comparable> T min(T[] a){
        T smallest = a[0];
        for (int i = 0; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0){
                smallest = a[i];
            }
        }
        return smallest;
    }
}
