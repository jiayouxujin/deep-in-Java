package design;

import java.util.*;
import java.util.function.Predicate;

public class PredicateDesignDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Collection<Integer> even = filter(numbers, num -> num % 2 == 0);
        System.out.println(even);
    }

    private static <E> Collection<E> filter(Collection<E> source, Predicate<E> p) {
        //集合类操作，请不要直接利用参数
        List<E> copy = new ArrayList<E>(source);
        Iterator<E> iterable = copy.iterator();
        while (iterable.hasNext()) {
            E element = iterable.next();
            if (!p.test(element)) {
                iterable.remove();
            }
        }
        return Collections.unmodifiableList(copy);
    }
}
