package com.example.java.lensson1;

import java.util.Collections;
import java.util.List;

public class GenericTypeDemo {

    /**
     * @param <S> 来源类型
     * @param <T> 目标类型
     */
    public interface Converter<S, T> {
        T convert(S source);
    }

    public static void main(String[] args) {
        Converter<Integer,String> stringConverter=new Converter<Integer, String>() {
            @Override
            public String convert(Integer source) {
                return String.valueOf(source);
            }
        };

        new Converter<String,Integer>(){

            @Override
            public Integer convert(String source) {
                return Integer.valueOf(source);
            }
        };

        List<String> strings;
        List<Integer> integers;

        List data= Collections.emptyList();
        List data2=Collections.emptyList();

        data=data2;
    }
}
