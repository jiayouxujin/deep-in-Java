package com.example.method;

import java.util.*;

public class MethodReturnTypeDemo {

    public static void main(String[] args) {
        MethodReturnTypeDemo typeDemo=new MethodReturnTypeDemo();
        typeDemo.getWrongNumbers();

        List<Integer> res=typeDemo.getNumbers();
//        res.set(4,5);
        System.out.println(res);
    }
    //面向对象 多态、封装、继承

    //方法返回值 体现多态和封装

    /**
     * 原则1 返回类型要抽象，除Object
     * 抽象返回类型的意义，调用方（接收方）容易处理
     * 越具体 越难通用
     */

    //需求1 返回一个有序的，去重的字符串
    public TreeSet<String> getValues() {  //错误范例
        return new TreeSet<>();
    }

    //动词+形容词+名词
    //动词+名词+副词
    public SortedSet<String> getSortedValues() {
        return new TreeSet<>();
    }

    //如何返回的类型是集合的话 Collection优于List或Set
    //如果不考录写操作的话，Iterable优于Collection

    // 原则2：尽可能返回Java集合框架内的接口，尽量避免数据

    /**
     * 1.Collection 比[]而言，拥有更多的操作方法，比如add
     * 2.Collection 接口返回时，可以限制只读
     */

    public Collection<Integer> getWrongNumbers() {
        //因为asList是内部ArrayList，这个ArrayList没有实现add方法，所以是一个只读的
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        System.out.println(numbers);
        //抛出异常
//        numbers.add(6);
        //不过提供了set方法，所以不是只读的
        numbers.set(3,6);
        System.out.println(numbers);
        return numbers;
    }

    //原则三：确保集合返回只读的
    public List<Integer> getNumbers(){
        List<Integer> numbers=Arrays.asList(1,2,3,4,5);
        return Collections.unmodifiableList(numbers);
    }

    //原则4：如果需要非只读集合，那么确保返回快照
    //快照即copy
    private static List<Integer> getNumbersSnapshot(){
        List<Integer> numbers=Arrays.asList(1,2,3,4,5);
        return new ArrayList<>(numbers);
    }

    //如果需要返回快照，尽可能选额ArrayList

}
