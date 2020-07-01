package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLinkedList;
import com.season.algorithm.ListNode;


public class Algorithm016 extends AlgorithmLinkedList {

    @Override
    public String getName() {
        return "016-合并两个或k个有序链表";
    }

    @Override
    public String getDesc() {
        return "输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。";
    }

    ListNode listNode1,listNode2;
    @Override
    public void prepare() {
        listNode1 = getNode(0,  2, 15);
        logListNode(listNode1);
        listNode2 = getNode(1,  2,12);
        logListNode(listNode2);
    }

    ListNode resultNode;
    @Override
    public void execute() {
        //resultNode = mergeNodeRC(listNode1, listNode2);
        resultNode = mergeNodeList(new ListNode[]{listNode1, listNode2});
    }

    @Override
    public void verify() {
        logListNode(resultNode);
    }

    public ListNode mergeNodeList(ListNode[] nodeList){
        return mergeNodeList(nodeList, 0, nodeList.length - 1);
    }

    public ListNode mergeNodeList(ListNode[] nodeList, int left, int right){
        if (left == right){
            return nodeList[left];
        }
        int mid = left + (left + right)/2;

        ListNode node1 = mergeNodeList(nodeList, left, mid);
        ListNode node2 = mergeNodeList(nodeList, mid + 1, right);
        return mergeNodeRC(node1, node2);
    }

    /**
     * 递归方式
     * @param node1
     * @param node2
     * @return
     */
    public ListNode mergeNodeRC(ListNode node1, ListNode node2){
        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }
        ListNode res = null;
        if (node1.val < node2.val){
            res = node1;
            res.next = mergeNodeRC(node1.next, node2);
        }else{
            res = node2;
            res.next = mergeNodeRC(node1, node2.next);
        }
        return  res;
    }

    public ListNode mergeNode(ListNode node1, ListNode node2){
        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }
        ListNode res;
        ListNode nodeCurrent = new ListNode();
        res = nodeCurrent;
        while (node1 != null && node2 != null){
            if (node1.val < node2.val){
                nodeCurrent.next = node1;
                node1 = node1.next;
            }else{
                nodeCurrent.next = node2;
                node2 = node2.next;
            }
            nodeCurrent = nodeCurrent.next;
        }
        if (node1 == null){
            nodeCurrent.next = node2;
        }
        if (node2 == null){
            nodeCurrent.next = node1;
        }
        res = res.next;
        return  res;
    }

}
