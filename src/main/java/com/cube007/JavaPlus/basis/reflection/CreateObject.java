package com.cube007.JavaPlus.basis.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 动态的创建对象
 * @author 11917
 */
public class CreateObject {

    public static void main(String[] args) throws ReflectiveOperationException {
        Class<?> c1 = Class.forName("com.cube007.JavaPlus.basis.reflection.User");

        // 构造一个对象 无参构造器
        User user = (User) c1.newInstance();
        System.out.println(user);

        // 通过构造器创建对象
        Constructor<?> declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user1 = (User) declaredConstructor.newInstance("小楠", 1, 18);
        System.out.println(user1);

        // 获取方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        // invoke：激活
        setName.invoke(user, "xiaonan");
        System.out.println(user.getName());

        System.out.println("------------------------------");

        // 通过反射操作属性
        User user2 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        // 不能直接操作私有属性 需要关闭程序的安全检测，属性方法构造器都是如此
        name.setAccessible(true);
        name.set(user2, "xiaonan");
        System.out.println(user2.getName());

    }
}
