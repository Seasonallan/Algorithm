package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLinkedList;
import com.season.algorithm.ListNode;


public class Algorithm036 extends AlgorithmLinkedList {

    @Override
    public String getName() {
        return "036-两个链表的第一个公共结点";
    }

    @Override
    public String getDesc() {
        return "输入两个链表，找出它们的第一个公共结点。";
    }

    ListNode listNode1, listNode2;
    @Override
    public void prepare() {
        listNode1 = getNode(0, 2, 12);
        listNode2 = getNode(7, 2, 21);
        ListNode nodeTail = getNode(50, 4, 67);
        ListNode node1TailNode = Algorithm014.findPositionToTail(listNode1, 1);
        node1TailNode.next = nodeTail;
        ListNode node1TailNode2 = Algorithm014.findPositionToTail(listNode2, 1);
        node1TailNode2.next = nodeTail;

        logListNode(listNode1);
        logListNode(listNode2);
    }

    ListNode resultNode;
    @Override
    public void execute() {
        resultNode = findCommonNode(listNode1, listNode2);
    }

    @Override
    public void verify() {
        log(resultNode);
    }


    public ListNode findCommonNode(ListNode node1, ListNode node2){
        if (node1 == null || node2 == null){
            return null;
        }
        ListNode currentNode1 = node1;
        ListNode currentNode2 = node2;
        int count1 = getNodeCount(node1);
        int count2 = getNodeCount(node2);
        if (count1 > count2){
            int count = count1 - count2;
            while (count > 0){
                currentNode1 = currentNode1.next;
                count --;
            }
        }else{
            int count = count2 - count1;
            while (count > 0){
                currentNode2 = currentNode2.next;
                count --;
            }
        }
        ListNode pre = null;
        while (pre == null && currentNode1 != null && currentNode2 != null){
            if (currentNode1.val == currentNode2.val){
                pre = currentNode1;
            }else{
                currentNode1 = currentNode1.next;
                currentNode2 = currentNode2.next;
            }
        }
        return  pre;
    }

}
