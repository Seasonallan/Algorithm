package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLinkedList;
import com.season.algorithm.support.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Algorithm003 extends AlgorithmLinkedList {

    @Override
    public String getName() {
        return "003-从尾到头打印链表";
    }

    @Override
    public String getDesc() {
        return "输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。";
    }

    ListNode listNode;
    @Override
    public String prepare() {
        listNode = getNode(0, 20);
        return logListNode(listNode);
    }

    @Override
    public void execute() {
        arrayList = new ArrayList<Integer>();
        printListFromTailToHead(listNode);
    }

    @Override
    public String verify() {
        return logList(arrayList);
    }

    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public void printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
            //或者调换位置写法
          //  arrayList.add(0, listNode.val);
          //  printListFromTailToHead(listNode.next);
        }
    }



    public ArrayList<Integer> printListFromTailToHeadECX(ListNode listNode) {
        Stack<Integer> stack=new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }

        ArrayList<Integer> list=new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
