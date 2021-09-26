package com.cube007.JavaPlus.other;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author 11917
 */
public class Other implements Runnable {

    private final int num = 8;

    public Other() {
        new Thread(() -> System.out.println(this.num)).start();
    }

    public void run() {

    }

    public static void main(String[] args) throws IOException {

        Map<String, String> map = new ConcurrentHashMap<>();

        map.put("a", "1");

        new Other();
    }

}
