package com.cube007.JavaPlus.other;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 11917
 */
public class Other {
    public void other() {
        Map<String, Object> map = new HashMap<>(5);
        map.put("a", "b");

        map = new ConcurrentHashMap<>();

        map.put("", "");

    }
}
