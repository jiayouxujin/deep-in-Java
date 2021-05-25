package stream;

import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
//        count(1,2,3,4,5,6,7,8,9,10);
//        sort(3,5,1,2,6,7,9);

        parallelSort(1,2,3,4,5,6,7,8,9);
    }

    private static void parallelSort(Integer... numbers){
        Stream.of(numbers)
                .sorted()
                .parallel()
                .forEach(StreamDemo::println);
    }

    private static void println(Object object){
        System.out.printf("[%s] : %s\n",Thread.currentThread().getName(),object);
    }
    private static void sort(Integer... numbers){
        Stream.of(numbers)
                .sorted()
                .forEach(System.out::println);
    }

    private static void count(Integer... numbers){
        Stream.of(numbers).reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}
