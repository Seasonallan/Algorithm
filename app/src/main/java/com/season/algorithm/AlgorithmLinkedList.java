package com.season.algorithm;

import android.util.Log;

import com.season.algorithm.support.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class AlgorithmLinkedList implements IAlgorithm {

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


    public static String log(Object o){
        if (o == null){
            Log.e(TAG, "empty");
            return "empty";
        }else{
            if (o instanceof ListNode){
                Log.e(TAG, ((ListNode) o).val +"");
                return ((ListNode) o).val +"";
            }else{
                Log.e(TAG, o.toString());
                return o.toString();
            }
        }
    }

    /**
     * 打印链表
     * @param listNode
     */
    public static String logListNode(ListNode listNode, boolean circle){
        ListNode first  = listNode;
        StringBuffer stringBuffer = new StringBuffer();
        HashMap<Integer, Integer> cache = new HashMap<>();
        while(first!=null){
            if (circle && cache.containsKey(first.val)){
                stringBuffer.append("-环形-");
                stringBuffer.append(first.val);
                break;
            }
            stringBuffer.append(first.val);
            if (first.random != null){
                stringBuffer.append("("+ first.random.val+")");
            }
            stringBuffer.append("-");
            cache.put(first.val, 1);
            first = first.next;
        }
        Log.e(TAG, stringBuffer.toString());
        return stringBuffer.toString();
    }


    /**
     * 打印链表
     * @param listNode
     */
    public static String logListNode(ListNode listNode){
        return logListNode(listNode, true);
    }


    /**
     * 打印列表
     * @param listNode
     */
    public static String logList(List listNode){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < listNode.size(); i++) {
            stringBuffer.append(listNode.get(i));
            stringBuffer.append("-");
        }
        Log.e(TAG, stringBuffer.toString());
        return stringBuffer.toString();
    }


}
