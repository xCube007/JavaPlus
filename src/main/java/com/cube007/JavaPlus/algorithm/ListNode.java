package com.cube007.JavaPlus.algorithm;

/**
 * @ClassName: ListNode
 * @Description: 链表
 * @Author: Liu Xiaonan
 * @Date: 2021/6/25 16:13
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
