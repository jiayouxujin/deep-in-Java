package com.example.java;

public class InnerClassDemo {
    private int data;
    private C c;

    public class C {
        private int data;
    }

    public void setData() {
        c.data = data;
    }

    /**
     * 内置类也是类得一种成员
     */
    public static class A {

    }

    /**
     * 在Java8+修饰interface不需要使用static
     */
    public interface B {

    }

    public static void main(String[] args) {
        A a = null;
        B b = null;
        C c = null;
    }
}
