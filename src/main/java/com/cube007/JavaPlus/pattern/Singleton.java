package com.cube007.JavaPlus.pattern;

/**
 * @ClassName: singleton
 * @Description: 单例模式
 * @Author: Liu Xiaonan
 * @Date: 2021/7/8 10:44
 */
public class Singleton {

    // volatile保证有序性，防止指令重排序
    private volatile static Singleton INSTANCE;

    private String Name;

    private Singleton () {}

    public static Singleton getInstance() {
        // 双重检查
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }

        }
        return INSTANCE;
    }

    //
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                new Singleton();
            }
        }).start();
    }
}
