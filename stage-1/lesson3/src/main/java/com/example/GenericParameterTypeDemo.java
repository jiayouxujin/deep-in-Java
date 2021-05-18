package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class GenericParameterTypeDemo {
    public static void main(String[] args) {
        Container<String> a=new Container("String");
//        Container<Integer> b=new Container(2);
        /**
         * 运行时会被擦写成 Object
         * 所以编译和运行都不会报错
         */
        // StringBuffer 是CharSequence的子列
        //String是CharSequence子类
        Container<StringBuffer> c=new Container("Hello,World");
        /**
         * 通过构造器传递的参数的String类型，运行都是Object所以没有问题
         */
        System.out.println(c.getElement());
        /**
         * 因为E类型为StringBuffer，所以在Set的时候只能是StringBuffer
         */
        c.setElement(new StringBuffer("hi"));
        System.out.println(c.getElement());

        add(new ArrayList<>(),"Hello,World");
        add(new ArrayList<>(),1);  // auto-boxing 1 = new Integer(1)

        //运行时擦写 Object
        forEach(Arrays.asList(1,3,4),System.out::println);
    }


    /**
     * 多界限泛型参数类型
     */
    public static class C{

    }

    public static class C2{

    }

    public interface I{

    }

    public interface I2{

    }

    public static class TemplateClass extends C implements I,I2{

    }

    /**
     * 多界限泛型绑定的extends的第一个类型可以是具体类(也可以是接口)
     * 第二个类型只能是接口(试过了)
     * @param <T>
     */
    public static class Template<T extends C & I & I2>{

    }
    /**
     * extends 声明上限 E的上限类型CharSequence
     * @param <E>
     */
    public static class Container<E extends CharSequence>{
        private E element;

        public Container(E e){
            this.element=e;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }
    }

    public static <C extends Collection<E>,E extends Serializable> void add(C target, E element){
        target.add(element);
    }

    public static <C extends Iterable<E>,E extends Serializable> void forEach(C source, Consumer<E> consumer){
        for(E e:source){
            consumer.accept(e);
        }
    }
}
