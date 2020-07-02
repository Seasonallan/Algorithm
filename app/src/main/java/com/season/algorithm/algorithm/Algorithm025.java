package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLinkedList;
import com.season.algorithm.support.ListNode;


public class Algorithm025 extends AlgorithmLinkedList {

    @Override
    public String getName() {
        return "025-复杂链表的复制";
    }

    @Override
    public String getDesc() {
        return "输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。";
    }

    ListNode listNode;
    @Override
    public String prepare() {
        listNode = getNode(0, 5);
        listNode = randomNode(listNode);
        return logListNode(listNode);
    }

    ListNode resultNode;
    @Override
    public void execute() {
        resultNode = copyNode(listNode);
    }

    @Override
    public String verify() {
        return logListNode(resultNode);
    }


    public ListNode copyNode(ListNode node){
        if (node == null || node.next == null){
            return node;
        }
        ListNode head = node;
        ListNode record = null;
        while (head != null){//复制next
            record = head.copy();
            record.next = head.next;
            head.next = record;
            head = record.next;
        }

        head = node;
        while (head != null){//复制random
            if (head.random != null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }

        head = node;
        ListNode res = node.next;
        ListNode current = res;

        while (head != null){//分离
            head.next = current.next;
            head = head.next;
            if (head != null){
                current.next = head.next;
                current = current.next;
            }
        }

        return  res;
    }

}
