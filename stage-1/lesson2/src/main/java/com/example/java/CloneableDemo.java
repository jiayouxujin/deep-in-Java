package com.example.java;

/**
 * Cloneable是个标记接口，用来表示该对象可以使用clone否则会抛出异常
 */
public class CloneableDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        String desc="Hello";
        Data data=new Data();
        data.setValue(1);
        data.setDec(desc);

        Data copy=data.clone();
        //浅copy
        //深浅copy是在于对象类型
        System.out.println("data==copy： "+(data==copy));
        System.out.println(copy.getValue());
        System.out.println(copy.getDec()==desc);
        System.out.println(copy.getDec().equals(desc));
    }

}

class Data extends Object implements Cloneable{
    private int value;

    private String dec;

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 把protected提升访问性 public
     * @return
     * @throws CloneNotSupportedException
     */
    public Data clone() throws CloneNotSupportedException {
        Data copy = (Data) super.clone();
        //对象类型需要复制
        copy.dec=new String(this.dec);
        return copy;
    }
}
