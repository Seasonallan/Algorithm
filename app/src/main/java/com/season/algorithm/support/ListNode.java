package com.season.algorithm.support;

/**
 * 链表结构
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode random;

    public ListNode(){

    }

    public ListNode(int val){
        this.val = val;
    }

    public ListNode copy(){
        return new ListNode(val);
    }
}
