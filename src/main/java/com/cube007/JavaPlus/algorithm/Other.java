package com.cube007.JavaPlus.algorithm;

import com.cube007.JavaPlus.datastructure.BinaryTree;
import com.cube007.JavaPlus.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;


public class Other {

    public static void main(String[] args) {
        ListNode listNode = reversionListNode(ListNode.getListNode());
        System.out.println(listNode);
    }


    /**
     * 对比版本号
     * @param version1:
     * @param version2:
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
     * @param a:
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

    /**
     * 判断连续三个递增的整数
     * @param a:
     * @return boolean
     */
    public boolean check3(int[] a) {

        int val = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i-1]) {
                val ++;
            } else {
                val = 0;
            }
        }
        return val > 1;
    }


    public void game(int val, List<String> list) {

        for (int i = 0; i < val; i++) {
            int m = 0;
            int n = 0;
            String s = list.get(i);
            System.out.println();
        }

    }

    public void recursion(int m, int n, String s) {
        if (!s.contains("1")) {
            return;
        }

        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i)) {
//
//            }
            System.out.println();
        }
    }


    /**
     * 反转二叉树
     * @param binaryTree:
     * @return BinaryTree
     */
    public BinaryTree reversionBinaryTree(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return null;
        }
        BinaryTree tmp = binaryTree.left;
        binaryTree.left = reversionBinaryTree(binaryTree.right);
        binaryTree.right = reversionBinaryTree(tmp.left);
        return binaryTree;
    }


    /**
     * 反转链表
     * @param listNode:
     * @return com.cube007.JavaPlus.datastructure.ListNode
     * @author Cube007
     * @date 2021/8/29 23:18
     */
    public static ListNode reversionListNode(ListNode listNode) {

        ListNode pre = null;
        ListNode next;

        while (listNode != null) {
            next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }

        return pre;
    }




}
