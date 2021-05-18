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

        collection=unmodifiable(1,2,3,4,5);
        collection.add(6);
    }

    public static Collection<Integer> of(Integer... values) {
        return new ArrayList<Integer>(Arrays.asList(values));
    }

    public static Collection<Integer> unmodifiable(Integer... values) {
        return Collections.unmodifiableList(Arrays.asList(values));
    }
}
