package com.cube007.JavaPlus.basis.reflection;

/**
 * 反射测试类
 * @author 11917
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.cube007.JavaPlus.basis.reflection.User");
        System.out.println(c1);

    }

}

/**
 * 实体类
 */
class User {
    private String name;
    private int id;
    private int age;

    public User() {

    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
