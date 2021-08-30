package com.cube007.JavaPlus.other;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 11917
 */
public class Other {

    private final int num = 8;

    public Other() {
        new Thread(() -> System.out.println(this.num)).start();
    }

    public static void main(String[] args) throws IOException {
        new Other();
    }

}
