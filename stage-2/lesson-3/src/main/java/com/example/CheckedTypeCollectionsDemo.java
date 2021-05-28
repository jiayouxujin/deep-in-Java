package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckedTypeCollectionsDemo {

    public static void main(String[] args) {
        List<Integer> values= Arrays.asList(1,2,3);
        //泛型是编译时检查，运行时擦写
        //values.add("1")
        List referencedValues=values;
        System.out.println(referencedValues==values);
        referencedValues.add("A"); //插入成功
        //typeCheck
        List<Integer> checkedTypeValues= Collections.checkedList(values,Integer.class);
        referencedValues=checkedTypeValues;
        referencedValues.add("B");//会报错
    }
}
