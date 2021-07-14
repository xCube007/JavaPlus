package com.cube007.JavaPlus.basis.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射获取类的信息
 * @author 11917
 */
public class GetClassInfo {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.cube007.JavaPlus.basis.reflection.User");

        // 获得类名
        System.out.println(c1.getName());

        // 获得public属性
        Field[] fields = c1.getFields();
        // 获得所有属性
        fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("---------------------------");

        // 获得类的方法
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("本类和父类的public方法" + method);
        }
        methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("本类的方法" + method);
        }

        System.out.println("---------------------------");

        // 获得构造器
        Constructor<?>[] constructors = c1.getConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }


    }
}
