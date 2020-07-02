package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLinkedList;
import com.season.algorithm.support.ListNode;


public class Algorithm015 extends AlgorithmLinkedList {

    @Override
    public String getName() {
        return "015-反转链表";
    }

    @Override
    public String getDesc() {
        return "输入一个链表，反转链表后，输出新链表的表头。";
    }

    ListNode listNode;
    @Override
    public String prepare() {
        listNode = getNode(0, 5);
        return logListNode(listNode);
    }

    ListNode resultNode;
    @Override
    public void execute() {
        resultNode = reverseNode(listNode);
    }

    @Override
    public String verify() {
        return logListNode(resultNode);
    }


    public ListNode reverseNode(ListNode node){
        if (node == null || node.next == null){
            return node;
        }
        ListNode pre = null, next;
        while (node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return  pre;
    }

}
