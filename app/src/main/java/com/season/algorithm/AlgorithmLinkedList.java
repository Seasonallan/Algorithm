package com.season.algorithm;

import com.season.algorithm.support.ListNode;
import java.util.Random;

public abstract class AlgorithmLinkedList extends AlgorithmLog {

    @Override
    public String getGroup() {
        return "LinkedList链表";
    }


    public static ListNode randomNode(ListNode node){
        ListNode head = node;
        while (head != null){
            if (new Random().nextBoolean()){
                head.random = get1RandomNode(node);
            }
            head = head.next;
        }
        return node;
    }

    public static ListNode get1RandomNode(ListNode node){
        ListNode head = node;
        ListNode recordNode = null;
        while (head != null){
            if (new Random().nextBoolean()){
                recordNode = head;
            }
            head = head.next;
        }
        return recordNode;
    }

    public static ListNode getNode(int i, int max){
        return getNode(i, 1, max);
    }

    public static ListNode getNode(int i, int skip, int max){
        if (i > max){
            return null;
        }
        ListNode node = new ListNode();
        node.next = getNode(i + skip, skip, max);
        node.val = i;
        return node;
    }

    public static int getNodeCount(ListNode listNode){
        ListNode first  = listNode;
        int count = 0;
        while(first!=null){
            first = first.next;
            count ++;
        }
        return count;
    }


}
