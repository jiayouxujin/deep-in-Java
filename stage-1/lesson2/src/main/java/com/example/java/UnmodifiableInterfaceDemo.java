package com.example.java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class UnmodifiableInterfaceDemo {

    public static void main(String[] args) {
        Collection<Integer> collection = of(1, 2, 3, 4, 5);
        collection.add(6);
        System.out.println(collection);

        /**
         * 线程安全问题：问是否有读写并存得情况
         */
        collection=unmodifiable(1,2,3,4,5);
        collection.add(6);
    }

    public static Collection<Integer> of(Integer... values) {
        return new ArrayList<Integer>(Arrays.asList(values));
    }

    public static Collection<Integer> unmodifiable(Integer... values) {
        /**
         * 通常用于方法得返回值，通知使用者该方法是只读得
         */
        return Collections.unmodifiableList(Arrays.asList(values));
    }
}
