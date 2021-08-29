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

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getListNode() {
//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);

        return new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

    }
}
