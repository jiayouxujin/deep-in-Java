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
    
- 执行：某个方法
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

  ## Java函数式设计

  #### 匿名内置类

  - 没有类名

  ```java
  new PropertyChangeListener() {
              @Override
              public void propertyChange(PropertyChangeEvent evt) {
        }
  };
  
  static class PropertyChangeListenerImpl implements PropertyChangeListener{
          @Override
          public void propertyChange(PropertyChangeEvent evt) {
  
         }
  }
  ```

  - 放置位置
    - static block
    - 实例block
    - 方法里
    - 构造器
  - 与普通类一样

  缺陷

  - 代码臃肿
  - 接口升级，匿名类失效
  - 强类型约束

  #### Lambda表示式(code as data)

  ##### 函数式接口

  满足条件->有且只有一个抽象方法

  ```java
  @FunctionalInterface
      public interface Action{
          void execute();
          
      }
  ```

  ##### 输入输出

  1. 有输入无输出

  ```java
  new consumer=a->{
      xxx
      //return
  };
  ```

  2. 无输入 有输出

  ```java
  new supplier=()->{
      xxx
      return
  };
  ```

  3. 有输入+有输出

  ```java
  new function=a->{
      xxx
      return 
  };
  ```

  

  