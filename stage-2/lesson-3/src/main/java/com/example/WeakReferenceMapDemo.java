package com.example;

import java.lang.ref.WeakReference;

public class WeakReferenceMapDemo {

    public static void main(String[] args) {
        demoWeakHashMap();
    }

    private static void demoWeakHashMap() {

        //强引用
        //value 变量是局部变量，存放再栈
        String value="abc";

    }

    private static class User{
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
