package com.cube007.JavaPlus.algorithm;

import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description: Main
 * @Author: Liu Xiaonan
 * @Date: 2021/4/21 18:37
 */
public class Main {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {

        Easy easy =  new Easy();
        Medium medium = new Medium();
        Difficult difficult = new Difficult();

        while(true){
            System.out.print("输入：");
            Scanner scanner = new Scanner(System.in);
            String x = scanner.next();
//            String[] strings = new String[]{"strsin","aipost","strshz","aiget"};
            int[] a = {1,2};
            int[] b = {3,4};
//            System.out.println(easy.strStr("bba", "a"));
//            System.out.println(difficult.findMedianSortedArrays(a, b));
            System.out.println(medium.convert(x, 4));
        }


    }
}
