package com.example;

import org.springframework.core.ResolvableType;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class QuestionAndAnswer<T extends Serializable> {

    private List<Map<String, List<Object>>> value = Collections.emptyList();

    public static void main(String[] args) {
        quersion1();
    }

    private static void quersion1() {
        /**
         * 如果泛型参数在类型上，可以通过反射获取到
         */
        try {
            //成员泛型参数获取
            Field field=QuestionAndAnswer.class.getDeclaredField("value");
            ResolvableType resolvableType=ResolvableType.forField(field);
            System.out.println(resolvableType.getGeneric(0));

            //类成员泛型参数获取
            TypeVariable[] parameters=QuestionAndAnswer.class.getTypeParameters();
            for(TypeVariable typeVariable:parameters){
                System.out.println(typeVariable);
            }

            //具体类型（可以通过父类获取)
//            QuestionAndAnswer<String> a=new QuestionAndAnswer<>();
//            TypeVariable[] parameters2=a.getClass().getTypeParameters();
//            for(TypeVariable typeVariable:parameters2){
//                System.out.println(typeVariable);
//            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
