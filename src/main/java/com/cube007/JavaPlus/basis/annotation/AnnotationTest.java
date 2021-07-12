package com.cube007.JavaPlus.basis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解测试类
 * @author 11917
 */
public class AnnotationTest {

    @MyAnnotation(name = "Lxn", schools = {"清华"})
    public void test() {

    }
    @MyAnnotation2("val")
    public void test2() {

    }
}

/**
 * @author 11917
 */
// 作用域
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {

    // 注解的参数 default：默认值
    String name() default "";

    int age() default 0;

    int id() default -1;

    String[] schools();

}

/**
 * @author 11917
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    String value();
}