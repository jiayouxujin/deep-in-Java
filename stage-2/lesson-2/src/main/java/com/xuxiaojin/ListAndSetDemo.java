package com.xuxiaojin;

import java.util.HashSet;
import java.util.Set;

public class ListAndSetDemo {

    public static void main(String[] args) {
        Set<String> values=new HashSet<>();
        values.add("a");
        values.add("b");
        values.add("c");

        values.forEach(System.out::println);
    }
}
