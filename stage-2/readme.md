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

