package com.example.java;

import java.io.Serializable;

public class InterfaceDemo {
    public static void main(String[] args) {
        /**
         * 接口确认了通讯锲约
         * 强类型约束
         */
        println(1);
        /**
         * String 即是Serializable和CharSequence
         * println("hello") 会出现错误
         */
        println((CharSequence) "hello");
    }

    private static void println(Serializable object) {

    }

    private static void println(CharSequence ob) {
        System.out.println(ob.toString());
    }

    public interface A {
        int VALUE = 1;
    }
}
