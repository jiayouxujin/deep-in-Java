package com.example.java;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumClassDemo {

    public static void main(String[] args) {
//        println(Counting.FIVE);
//        println(CountingEnum.FIVE);

        printEachCountingEnumMembers();
        printEachCountingMembers();

//        printEnumMeta(CountingEnum.FIVE);
    }

    public static void println(Counting counting) {
        System.out.println(counting);
    }

    public static void println(CountingEnum countingEnum) {
        System.out.println(countingEnum);
    }

    public static void printEnumMeta(Enum enumeration) {
        //任何枚举都扩展了java.lang.Enum
        System.out.println("enumeration type " + enumeration.getClass());
        //成员信息Enum#name()
        //Enum#ordinal()定义的位置
        System.out.println("member : " + enumeration.name());
        System.out.println("ordinal : " + enumeration.ordinal());
        //values()方法是Java编译器给枚举提升的方法
    }

    public static void printEachCountingEnumMembers() {
        Stream.of(CountingEnum.values())
                .forEach(System.out::println);
    }

    public static void printEachCountingMembers() {
        Stream.of(Counting.values())
                .forEach(System.out::println);
    }
}

enum CountingEnum implements Cloneable{
    ONE(1){
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    },
    TWO(2){
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    },
    THREE(3){
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    },
    FOUR(4){
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    },
    FIVE(5){
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };

    private int value;

    CountingEnum(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
    @Override
    public String toString() {
        return "CountingEnum : " + value ;
    }

    public abstract String valueAsString();
}

//class ExtendedEnum extends CountingEnum{
//}


class ExtendCounting extends Counting{
    private ExtendCounting(int value){
        super(value);
    }
    @Override
    public String valueAsString() {
        return null;
    }
}
/**
 * 枚举类
 * final修饰为了不让它继承
 * 强类型约束（相对于常量）
 */
abstract class Counting implements Cloneable{
    public static final Counting ONE = new Counting(1) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };
    public static final Counting TOW = new Counting(2) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };
    public static final Counting THREE = new Counting(3) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };
    public static final Counting FOUR = new Counting(4) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };
    public static final Counting FIVE = new Counting(5) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };

    private int value;

    protected Counting(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
    public abstract String valueAsString();

    @Override
    public String toString() {
        return "Counting : " + value;
    }

    /**
     * 没有通过字节码提升的技术
     *
     * @return
     */
    public static Counting[] values() {
        Field[] fields = Counting.class.getDeclaredFields();

        //Fields -> filter -> public static final -> get
        return Stream.of(fields).filter(field -> {
            int modifiers = field.getModifiers();
            return Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        }).map(field -> {
            try {
                return (Counting) field.get(null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList()).toArray(new Counting[0]);
    }
}
