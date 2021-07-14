package com.cube007.JavaPlus.basis.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 分析反射性能
 * @author 11917
 */
public class AnalyzePerformance {

    public static void main(String[] args) throws ReflectiveOperationException {
        test1();
        test2();
        test3();
    }
    /**
     * 正常调用
     */
    public static void test1() {
        User user = new User();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("普通执行10亿次方法" + (endTime - startTime) + "ms");
    }

    /**
     * 反射调用
     */
    public static void test2() throws ReflectiveOperationException{
        User user = new User();
        Class<? extends User> c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射调用执行10亿次方法" + (endTime - startTime) + "ms");
    }

    /**
     * 反射调用 关闭检测
     */
    public static void test3() throws ReflectiveOperationException{
        User user = new User();
        Class<? extends User> c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);

        long startTime = System.currentTimeMillis();
        getName.setAccessible(true);
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射调用 关闭检测执行10亿次方法" + (endTime - startTime) + "ms");
    }
}
