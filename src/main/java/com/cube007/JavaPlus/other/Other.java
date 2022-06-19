package com.cube007.JavaPlus.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 11917
 */
public class Other {

    public static void main(String[] args) {

        Data data = new Data();
        new Thread(()->{
            for(int i = 0; i < 50; i++) {
                try {
                    data.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(()->{
            for(int i = 0; i < 50; i++) {
                try {
                    data.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

    }

    public static void print(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
                for(int k = 1; k <= i-1; k++) {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static Map<Character, Integer> statistics(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }


}

class Data {
    private int val = 1;
    public synchronized void printA() throws InterruptedException {
        while (val%2 == 0) {
            this.wait();
        }
        System.out.println(val);
        val++;
        this.notify();
    }

    public synchronized void printB() throws InterruptedException {
        while (val%2 != 0) {
            this.wait();
        }
        System.out.println(val);
        val++;
        this.notify();
    }
}
