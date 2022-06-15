package com.example.demo.colletion.cha911;

import com.example.demo.fanxing.cha881.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.CollationElementIterator;
import java.util.*;
import java.util.Map.*;

public interface Quene<E> {
    void add(E elment);
    E remove();
    int size();
}
class  Test{
    public static void main(String[] args) throws IOException {
        Properties defaultSettings = new Properties();
        defaultSettings.setProperty("width", "600");
        defaultSettings.setProperty("height", "400");
        defaultSettings.setProperty("filename", "");
        Properties settings = new Properties(defaultSettings);
    }
}