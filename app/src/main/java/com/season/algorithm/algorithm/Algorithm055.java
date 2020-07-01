package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLinkedList;
import com.season.algorithm.ListNode;


public class Algorithm055 extends AlgorithmLinkedList {

    @Override
    public String getName() {
        return "055-链表中环的入口结点";
    }

    @Override
    public String getDesc() {
        return "给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。";
    }

    ListNode listNode;
    @Override
    public void prepare() {
        listNode = getNode(0, 10);
        ListNode node1TailNode = Algorithm014.findPositionToTail(listNode, 1);
        node1TailNode.next = listNode.next.next.next.next;
        logListNode(listNode);
    }

    ListNode resultNode;
    @Override
    public void execute() {
        resultNode = circleNode(listNode);
    }

    @Override
    public void verify() {
        logListNode(resultNode);
    }


    public ListNode circleNode(ListNode node){
        if (node == null || node.next == null || node.next.next == null){
            return null;
        }
        ListNode fast=node;
        ListNode low=node; //快指针走两步，慢指针走一步  有环则 必定相遇
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            low = low.next;
            if(fast == low)
                break;
        }
        if(fast == null || fast.next == null)
            return null;
        low = node;
        // 从相遇点出发 都走一步，如果相遇 则是环入口 a=(k-1)(b+c)+c
        // 链表头到环入口的距离=相遇点到环入口的距离+（k-1）圈环长度。
        while(fast != low){
            fast = fast.next;
            low = low.next;
        }
        return low;
    }

}
