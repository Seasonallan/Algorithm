package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLinkedList;
import com.season.algorithm.ListNode;


public class Algorithm056 extends AlgorithmLinkedList {

    @Override
    public String getName() {
        return "056-删除链表中重复的结点";
    }

    @Override
    public String getDesc() {
        return "在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。";
    }

    ListNode listNode;
    @Override
    public void prepare() {
        listNode = new ListNode(2);
        ListNode node = new ListNode(2);
        listNode.next = node;
        ListNode node2 = new ListNode(3);
        node.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(4);
        node4.next = node5;
        ListNode node6 = new ListNode(5);
        node5.next = node6;

        logListNode(listNode, false);
    }

    ListNode resultNode;
    @Override
    public void execute() {
        resultNode = clearRepeatNode(listNode);
    }

    @Override
    public void verify() {
        logListNode(resultNode);
    }


    public ListNode clearRepeatNode(ListNode pHead){
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode p = pHead;
        ListNode last = first;
        while(p != null && p.next != null){
            if(p.val == p.next.val){
                int val = p.val;
                while(p != null && p.val == val){
                    p = p.next;
                }
                last.next = p;
            }else{
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }

}
