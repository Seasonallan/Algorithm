package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLinkedList;
import com.season.algorithm.support.ListNode;


public class Algorithm014 extends AlgorithmLinkedList {

    @Override
    public String getName() {
        return "014-链表中倒数第k个结点";
    }

    @Override
    public String getDesc() {
        return "输入一个链表，输出该链表中倒数第k个结点。";
    }

    ListNode listNode;
    @Override
    public String prepare() {
        listNode = getNode(0, 20);
        return logListNode(listNode) + "\n k=3";
    }

    ListNode resultNode;
    @Override
    public void execute() {
        resultNode = findPositionToTail(listNode, 3);
    }

    @Override
    public String verify() {
        return log(resultNode);
    }


    public static ListNode findPositionToTail(ListNode node, int position){
        if (node == null || position <= 0){
            return null;
        }
        ListNode p = node;
        ListNode q = node;
        for (int i = 0; i < position - 1; i++) {
            if (p.next != null){
                p = p.next;
            }else{
                return null;
            }
        }
        while (p.next != null){
            p = p.next;
            q = q.next;
        }
        return  q;
    }

}
