package com.xuxiaojin;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LegacyCollectionDemo {
    public static void main(String[] args) {
        vectorVsList();
        stackVsVector();
        hashtableVsHashMap();
        enumerationVsEnum();
    }

    private static void enumerationVsEnum() {
        //主要用于迭代，由于java.util.Iterator从Java1.2引入
        String value = "1,2,3";
        StringTokenizer tokenizer = new StringTokenizer(value, ",");
        Enumeration enumeration = tokenizer;
        while (enumeration.hasMoreElements()) {
            String element = (String) enumeration.nextElement();
            System.out.println(element);
        }

        //Iterable从Java5用for-each
    }

    private static void hashtableVsHashMap() {
        //synchronized修饰 属于线程安全
        //key or value 都不允许为空，会抛出空指针的exception
        Hashtable<Long, Long> hashtable = new Hashtable<>();
        //hashMap在读的时候是线程安全的，在写的时候不是线程安全
        HashMap<Long, Long> hashMap = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        map.put(null, null);

        //key or value 都不允许为空，在线程安全的情况下，如果value为空，在查询数据时，会产生歧义
        //到底是值为空，还是线程不可见
        ConcurrentHashMap<Long, Long> concurrentHashMap = new ConcurrentHashMap<>();
    }

    private static void stackVsVector() {
        Stack<String> stack = new Stack<>();
    }

    private static void vectorVsList() {
        Vector<String> vector = new Vector<>();
        List<String> list = new ArrayList<>();
    }
}
