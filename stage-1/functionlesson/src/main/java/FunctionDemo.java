import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        Function<String,Long> stringToLong=Long::valueOf;
        Long one=stringToLong.apply("1");
        System.out.println(one);
    }
}
