package com.cube007.JavaPlus.dataStructure;

/**
 * @ClassName: ListNode
 * @Description: 链表
 * @Author: Liu Xiaonan
 * @Date: 2021/6/25 16:13
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getListNode() {

        return new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

    }
}
