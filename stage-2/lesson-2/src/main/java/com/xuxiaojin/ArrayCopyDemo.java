package com.xuxiaojin;

public class ArrayCopyDemo {
    public static void main(String[] args) {
        String[] strings=new String[]{"Hello","World"};
        arrayCopy(strings,strings);

        int value=Integer.MAX_VALUE;
        //int 在Java只有4字节（32位）
        System.out.println(value+1);
        System.out.println(value+1==Integer.MIN_VALUE);
    }

    public static void arrayCopy(Object[] src,Object[] destination){

    }
}
