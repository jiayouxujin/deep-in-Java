package com.example.lesson1;

import java.sql.Connection;
import java.util.logging.Logger;

public class ModularDemo {

    public static void main(String[] args) {
        Connection connection=null;
        //java.sql通过transitive传递
        Logger logger=Logger.getLogger("abc");
    }
}
