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

  ## Java模块化

  >Java9之前采用了.jar文件管理，Java9模块化后，采用了module-info.java

  #### 强封装性

  - 不是所有public class 都可以直接使用，只能用过`require`
  - `exports`只能在有class那一层才能够导出

  # Java面向对象设计

  ## Java接口设计

  ### 类设计

  - (形容词)+名词

  ### 可访问性

  - public:公开的API
  - protected:不能修饰**外部**class
  - default：**只能在当前的package使用，属于私有API**
  - private:不能修饰**外部**class

  >内置类是类的成员

  ### 可继承性

  - `final`不具备继承性，只能实现类，不能与abstract共用

    - String

      >`不变性`private final char[] value;
      >
      >可以通过`反射`进行修改
      >
      >```java
      >   //get string value字段
      >        Field valueField=String.class.getDeclaredField("value");
      >        //set 可访问
      >        valueField.setAccessible(true);
      >        //set value
      >        valueField.set(value1,chars);
      >```

  - 非`final`可以继承

  ### 具体类设计

  - 功能组件HashMap
  - 接口/抽象类实现HashMap<-AbstractMap<-Map
  - 数据对象POJO
  - 工具辅助Helper

  ### 抽象类实现

  抽象类是介于接口和类之间

  >抽象类里可以有实现方法的
  >
  >Java8有default后可以有实现方法，不过还是不能有字段

  **以Abstract和Base为前缀**

  - 接口通用设计（模板设计）AbstractList

  ### 接口设计

  - 常见场景

    - 通讯契约`FeignClient`

      - API
      - RPC

    - 常量定义

      ```java
      interface A{
          int VALUE=1;
      }
      ```

    - 标记接口`标记语义`
      - Clonable

  - 常见模式

    - 无状态
    - Java8 完全抽象，Java8+局部抽象(`default`方法)
    - 单一抽象 （函数式接口`只有一个抽象方法`）

  ### 内置类设计

  - Builder 
  - ThreadLocalMap 临时存储
  - UnmodifiableCollection
  
  具体设计
  
  >如果需要公开得时候，public和

