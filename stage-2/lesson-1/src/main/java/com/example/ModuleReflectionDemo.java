package com.example;

import java.lang.module.ModuleDescriptor;

public class ModuleReflectionDemo {

    public static void main(String[] args) {
        Class Klass=ModuleReflectionDemo.class;

        Module module=Klass.getModule();

        String moduleName=module.getName();
        System.out.printf("类 %s 存在于模块 [%s]\n",moduleName,module);
        ModuleDescriptor moduleDescriptor=module.getDescriptor();
        moduleDescriptor.requires().stream().forEach(requires -> {
                //hashSet存储 并不是有序的
                System.out.println(requires.name());
             }
        );
    }
}
