package com.cube007.JavaPlus.basis.reflection;

/**
 * 类加载测试
 * @author 11917
 */
public class ClassLoading {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("m = " + A.m);
//        synchronized ()
    }
}


class A {

    // 改变static顺序影响结果
    static {
        System.out.println("代码块加载");
        m = 300;
    }
    static int m = 100;

    A() {
        System.out.println("构造加载");
    }
}