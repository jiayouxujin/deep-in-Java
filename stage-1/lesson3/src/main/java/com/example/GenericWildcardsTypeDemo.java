package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class GenericWildcardsTypeDemo {

    public static void main(String[] args) {

        //泛型上界通配符
        List<Number> numbers = new ArrayList<>();
        upperBoundedWildcards(numbers);
    }

    private static void lowerBoundedWildcards(List<Number> numbers){

    }
    private static void upperBoundedWildcards(List<Number> numbers){

        numbers.add(Byte.valueOf((byte) 1));
        numbers.add(Short.valueOf((short) 2));
        numbers.add(Integer.valueOf(3));
        numbers.add(Long.valueOf(4L));

        List<Byte> bytes = Arrays.asList((byte) 5);
        List<Short> shorts = Arrays.asList((short) 6);
        numbers.addAll(bytes);
        numbers.addAll(shorts);
        //被操作的对象，需要更为抽象的类型，Number类似底层，然后可以整合它的上层东西(这是一种设计的方式)
        forEach(numbers,System.out::println);

        //完全通配
        println(numbers);
    }
    /**
     * 这里的两个?不是同一个东西
     * 通配符少用
     *类型是object
     * @param list
     * @param consumer
     */
    public static void forEach(Iterable<? extends Number> list, Consumer<Object> consumer) {
        for (Object e : list) {
            consumer.accept(e);
        }
    }

    /**
     * 完全通配可以在运行的时候与其它的任意类型都会产生方法签名的冲突
     * 如果使用具体类型，在编译的时候会限制使用的类型
     * @param iterable
     */
    public static void println(Iterable<?> iterable){
        for(Object e:iterable){
            System.out.println(e);
        }
    }
}
