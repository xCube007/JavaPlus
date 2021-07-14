package com.cube007.JavaPlus.basis.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 反射获取泛型
 * @author 11917
 */
public class GetGeneric {
    public void test1(Map<String, User> map, List<User> list) {
        System.out.println("test1");
    }

    public Map<String, User> test2() {
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        // 获取参数类型
        Method test1 = GetGeneric.class.getMethod("test1", Map.class, List.class);
        Type[] genericParameterTypes = test1.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("参数类型" + genericParameterType);

            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("泛型的内部类型" + actualTypeArgument);
                }
            }

        }

        System.out.println("-------------------------------");

        // 获取返回泛型类型
        Method test2 = GetGeneric.class.getMethod("test2");
        Type genericReturnType = test2.getGenericReturnType();
        System.out.println("返回的参数类型" + genericReturnType);
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("泛型的内部类型" + actualTypeArgument);
            }
        }


    }
}
