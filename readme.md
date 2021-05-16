# Java基础
## 访问性
### Before Java 9
-   public :all
-   protected: 继承+包
-   default: 同包
-   private: 当前类
## 面向对象
### 方法设计
-   单元：类或者组件
    -   类 采用*名词*结构
        -   动词过去式+名词
        -   动词ing+名词
        -   形容词+名词
    
-   执行：某个方法
    -   命名：动词
    -   参数：名词
    -   异常：
        -   根异常
            -   Throwable
                -   Exception
                -   RuntimeException
        -   `StackTraceElement`
            -   添加异常原因cause
                -   反模式 吞掉某个异常
                -   性能：`fillInStackTrace`方法开销，避免栈的深度
                    -   JVM参数控制
                    -   logback日志框架控制输出深度
    
    ### 泛型设计
    
    Java泛型属于编译时处理，运行时擦写
    
    >运行时擦写指的是 在运行过程中，无法知道具体类型，所以需要将泛型去掉
    >
    >泛型检查是发生在编译过程中的
    
    ```java
    public static class doCovert(List<String> v)
    public static class doCovert(List v)
    ```
    
    上面这两个方法会有冲突，原因就在：运行时擦写，所以这两个方法的签名一样。
    
    > 方法签名:完整的方法名+访问限定符+参数
    
    