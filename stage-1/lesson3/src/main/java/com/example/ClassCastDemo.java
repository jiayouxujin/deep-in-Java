package com.example;

import java.util.ArrayList;
import java.util.List;

public class ClassCastDemo {

    public static void main(String[] args) {

        List list=new ArrayList();
        list.add("A");
        list.add(1);

        List<Object> list1=list;

        //Diamond 写法
        List<String> stringList=new ArrayList<>();
        //Java 8 var
        // var strList =new ArrayList<>();
    }

    /**
     * need use doc to introduce
     * @param a
     * @param b
     */
    private static void exchange(List a,List b){

    }
}
