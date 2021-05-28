package com.xuxiaojin;

import java.util.Arrays;
import java.util.List;

public class AbstracCollectionDemo {
    public static void main(String[] args) {
        abstrctList();
    }

    private static void abstrctList() {
        //不支持add操作，但是允许通过index来进行修改
        List<Integer> numbers= Arrays.asList(1,2,3,4,5);
    }
}
