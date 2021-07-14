package com.cube007.JavaPlus.datastructure;

/**
 * @ClassName: ListNode
 * @Description: 链表
 * @Author: Liu Xiaonan
 * @Date: 2021/6/25 16:13
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
