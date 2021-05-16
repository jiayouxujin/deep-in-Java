package com.example.java.lensson1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LambdaDemo {

    //Supplier模式  无输入 有输出
    private static void showSupplier(){
        String s="Hello World";
        Supplier<String> stringSupplier=()-> "Hello World";
        Supplier<String> stringSupplier1=()->new Integer(2).toString();
    }

    //Action模式（无）
    //Consumer模式 有输入 无输出
    //Function模式 有输入和输出
    public static void main(String[] args) {
        Action b=a->{
            return a;
        };

        //传统写法 匿名类写法
        PropertyChangeListener listener1=new PropertyChangeListener(){
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                println(evt);
            }
        };

        //Lambda基本写法
        PropertyChangeListener listener2=evt -> {
            println(evt);
        };

        //Lambda简略写法
        PropertyChangeListener listener3=LambdaDemo::println;
    }


    private static void println(Object object){
        System.out.println(object);
    }
    @FunctionalInterface
    public interface Action{
        int execute(int a);

    }

    private static void stream(){
        Stream.of(1,2,3,4,5)
                .map(String::valueOf);
    }
}
