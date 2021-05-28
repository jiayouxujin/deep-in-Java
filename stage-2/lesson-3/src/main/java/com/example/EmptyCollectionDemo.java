package com.example;

import java.util.Collections;
import java.util.List;

public class EmptyCollectionDemo {
    public static void main(String[] args) {

        //所有的返回接口类型的方法，禁止返回null

        //集合方法入参
        //如果能用Iterable尽量用
        //弃此
    }

    public static List<String> getIdsList(String name) {
        if (name == null || name.length() < 1) {
            //只读的空List
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }
}
