package com.example.java;

import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;

public class StringDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /**
         * 常量化是原生类型
         */
        String value="Hello"; //常量 对象类型常量化

        //面向对象的写法
        String value1=new String("Hello");

        System.out.println("value:"+value);
        System.out.println("value1:"+value1);

        //since Java1.5对象属性通过反射修改
        char[] chars="World".toCharArray();
        //get string value字段
        Field valueField=String.class.getDeclaredField("value");
        //set 可访问
        valueField.setAccessible(true);
        //set value
        valueField.set(value1,chars);

        System.out.println("value:"+value);
        System.out.println("value1:"+value1);

    }

    public static class ExtendableString{
        private final char value[];

        private int hash;

        public ExtendableString(String value) {
            this.value = value.toCharArray();
        }

        public final int hashCode() {
            int h = hash;
            if (h == 0 && value.length > 0) {
                char val[] = value;

                for (int i = 0; i < value.length; i++) {
                    h = 31 * h + val[i];
                }
                hash = h;
            }
            return h;
        }
    }
}
