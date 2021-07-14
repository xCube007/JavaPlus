package com.cube007.JavaPlus.basis.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 反射操作注解
 * @author 11917
 */
public class ReflectionAnnotation {

    public static void main(String[] args) throws ReflectiveOperationException {

        // 通过反射获得注解
        Class<?> c1 = Class.forName("com.cube007.JavaPlus.basis.reflection.Student");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获得注解value值
        TableCube annotation = c1.getAnnotation(TableCube.class);
        System.out.println(annotation.value());

        // 获得类的指定注解
        Field name = c1.getDeclaredField("name");
        FieldCube annotation1 = name.getAnnotation(FieldCube.class);
        System.out.println(annotation1.columnName());
        System.out.println(annotation1.type());
        System.out.println(annotation1.length());

    }

}

@TableCube("db_student")
class Student{

    @FieldCube(columnName = "db_name", type = "varchar", length = 20)
    private String name;

    @FieldCube(columnName = "db_name", type = "int", length = 20)
    private int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


/**
 * 自定义表类注解
 * @author 11917
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface TableCube{
    String value();
}


/**
 * 自定义表属性注解
 * @author 11917
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@interface FieldCube{
    String columnName();
    String type();
    int length();
}
