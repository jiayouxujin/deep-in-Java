package design;

import java.util.function.Supplier;

public class SupplierDesignDemo {

    public static void main(String[] args) {
        echo("hello world"); //比较固定的方式
        echo(()->{   //灵活的装配
            sleep(1000);
            return "Hello World";
        });
    }

    private static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void echo(String message){ //拉的方式
        System.out.println(message);
    }
    public static void echo(Supplier<String> message){  //推的方式
        System.out.println(message);
    }

    private static Supplier<String> supplyMessage(){
        return ()->{
          return "hi";
        };
    }
}
