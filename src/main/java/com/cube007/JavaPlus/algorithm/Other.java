package com.cube007.JavaPlus.algorithm;

import java.util.ArrayList;
import java.util.List;


public class Other {
    /**
     * 对比版本号
     * @param version1
     * @param version2
     * @return String
     */
    public String getVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        for (int i = 0; i < (Math.min(a.length, b.length)); i++) {
            if (Integer.parseInt(a[i])> Integer.parseInt(b[i])) {
                return ">";
            } else if (Integer.parseInt(b[i]) > Integer.parseInt(a[i])) {
                return "<";
            }
        }
        // TODO 1.1.0-1.1
        return "=";
    }

    /**
     * 合并数组 {{0,2},{1,3},{2,7},{9,10}}
     * @param a
     * @return list
     */
    public List<int[]> merge(int[][] a) {
        //TODO 数组排序
        List<int[]> list = new ArrayList<>();
        int[] value = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i-1][1] >= a[i][0]) {
                value[1] = a[i][1];
            } else {
                list.add(value);
                value = a[i];
            }
        }
        list.add(value);
        return list;
    }
}
