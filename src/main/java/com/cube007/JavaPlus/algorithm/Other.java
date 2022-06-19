package com.cube007.JavaPlus.algorithm;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.cube007.JavaPlus.dataStructure.BinaryTree;
import com.cube007.JavaPlus.dataStructure.ListNode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Other {

    public static void main(String[] args) {
        ListNode listNode = reverse(ListNode.getListNode());
        System.out.println(listNode);

        System.out.println(selectNode(ListNode.getListNode(), 2).val);
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
     * @return com.cube007.JavaPlus.dataStructure.ListNode
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

    /**
     * 反转链表递归法
     * @param head:
     * @return com.cube007.JavaPlus.dataStructures.ListNode
     * @author Cube007
     * @date 2021/8/29 23:28
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head.next;
        ListNode newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }


    /**
     * 查找链表倒数第k个节点
     * @param head:
     * @param k:
     * @return com.cube007.JavaPlus.dataStructure.ListNode
     * @author Cube007
     * @date 2021/9/3 18:43
     */
    public static ListNode selectNode(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }

        ListNode one = head;
        ListNode two = head;

        while (k > 1 && one.next != null) {
            one = one.next;
            k--;
        }

        if (k > 1) {
            return null;
        }
        while (one.next != null) {
            one = one.next;
            two = two.next;
        }
        return two;

    }

    /**
     * 寻找1000w个数里面最小的10个数
     * @param arr:
     * @author Cube007
     * @date 2021/10/8 21:55
     */
    public static void select(int[] arr) {
        int[] val = new int[10];
        System.arraycopy(arr, 0, val, 0, 10);
        // 快速排序
        Sort.quickSort01(val, 0, val.length-1);
        for (int l = 10; l < arr.length; l++) {
            int j = -1;
            for (int i = 0; i < 10; i++) {
                if (val[i] > arr[l]) {
                    j = i;
                    break;
                }
            }

            if (j != -1) {
                int t = arr[l];
                for (int i = j; i < val.length; i++) {
                    if (val[i] > t) {
                        int tmp = val[i];
                        val[i] = t;
                        t = tmp;
                    }
                }
            }
        }
        for (int i : val) {
            System.out.println(i);
        }
    }

    /**
     * 生成未来一百年以及星期和是否周末
     * @author Cube007
     * @date 2022/1/19 15:23
     */
    public static void getDate() throws IOException {
        FileWriter fileWriter = new FileWriter("/Users/liuxiaonan/other/date.txt");
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String start = "20230101";
        int val = 7;

        DateTime dateTime = DateUtil.parse(start);
        List<String> list = new ArrayList<>();

        list.add(0, "");
        list.add(1, "星期一");
        list.add(2, "星期二");
        list.add(3, "星期三");
        list.add(4, "星期四");
        list.add(5, "星期五");
        list.add(6, "星期六");
        list.add(7, "星期日");

        while (!"21000101".equals(DateUtil.format(dateTime, "yyyyMMdd"))) {

            writer.write(DateUtil.format(dateTime, "yyyyMMdd") + "," + list.get(val) + "," + ((val == 7) || (val == 6) ? 1 : 0));
            writer.newLine();
            dateTime = DateUtil.offsetDay(dateTime, 1);
            if (val == 7) {
                val = 1;
            } else {
                val++;
            }
        }
        writer.flush();
        writer.close();
    }




}
