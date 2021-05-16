package com.example.lesson1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Callable;

public class InnerClassDemo {

    //static block
    static {
        new Runnable(){
            @Override
            public void run() {

            }
        };
    }

    //实例block
    {
        new Callable(){
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
    }

    //构造函数
    public InnerClassDemo(){
        new Comparable(){

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
    public static void main(String[] args) {
        //方法
        PropertyChangeListener listener=new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        };
    }

    static class PropertyChangeListenerImpl implements PropertyChangeListener{

        @Override
        public void propertyChange(PropertyChangeEvent evt) {

        }
    }

}
