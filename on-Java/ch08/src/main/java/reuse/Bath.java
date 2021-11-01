package reuse;

class Soap {
    private String s;
    Soap(){
        System.out.println("Soap()");
        s="Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

public class Bath {
    //定义时初始化
    private String s1="Happy",s2="Happy",s3,s4;
}
