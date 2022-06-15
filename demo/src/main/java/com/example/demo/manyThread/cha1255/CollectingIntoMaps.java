package com.example.demo.manyThread.cha1255;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author Cay Horstmann
 * @version 1.00 2016-05-10
 */
@Slf4j
public class CollectingIntoMaps {

    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return getClass().getName() + "[id=" + id + ",name=" + name + "]";
        }
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "Peter"), new Person(1002, "Paul"),
                new Person(1003, "Mary"));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Files.copy(fromPath, toPath, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
//        Files.move(fromPath, toPath, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
//        Files.move(fromPath, toPath, StandardCopyOption.ATOMIC_MOVE);


    }
}
