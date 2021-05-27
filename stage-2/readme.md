# Java模块化设计

## ClassLoader

```shell
java -verbose:class
可以显示所有loader的类
```

## 模块化基础

>模块路径
>
>- 类路径的脆弱性
>  - 无法通过artifacts的Class Path区分类型
>  - 无法区分artifacts
>  - 无法提前通知artifacts缺失
>- 定义整个模块而非类型
>- 无论是运行时，还是编译时，在同一目录下不允许出现同名模块

## 模块迁移

- 凡是定义module-info.java(module-info.class)属于命名模块（Java9+模块artifact）
- Java9之前的artifact属于非命名模块
  - 自动化模块
    - 如果在`MANIFEST.MF`定义`Automatic-Module-Name`属性，那么采用该属性hi作为模块名称
    - 否则，使用jar文件的名称（如果存在"-"的话，将其替换为"."）

## 模块化反射

# Java集合

## 集合接口

- 基于`java.util.Collection`

  - 通用接口

    - `java.util.List`
    - `Set`

    ```java
    public static int hashCode(byte[] value) {
            int h = 0;
            int length = value.length >> 1;
            for (int i = 0; i < length; i++) {
                h = 31 * h + getChar(value, i);
            }
            return h;
        }
    在ASCII码得场景里，一般都是有序，但是会导致误解
    ```

    - `SortedSet`
    - `NavigableSet`
    - `Queue`
    - `Deque`

- 基于`java.util,Map`