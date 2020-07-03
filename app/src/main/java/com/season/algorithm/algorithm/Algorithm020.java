package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmStackQueue;

import java.util.Stack;


public class Algorithm020 extends AlgorithmStackQueue {


    @Override
    public String getName() {
        return "020-包含min函数的栈";
    }

    @Override
    public String getDesc() {
        return "定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数";
    }


    Integer[] input = {5,9,2,4,3};
    @Override
    public String prepare() {
        for (Integer i : input){
            push(i);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("stack:");
        stringBuffer.append(logStack(stackMain));
        stringBuffer.append("\n");
        stringBuffer.append("minStack:");
        stringBuffer.append(logStack(stackMin));
        return stringBuffer.toString();
    }

    @Override
    public void execute() {
    }

    @Override
    public String verify() {
        StringBuffer stringBuffer = new StringBuffer();
        while (!stackMain.isEmpty()){
            stringBuffer.append("pop->");
            stringBuffer.append(min());
            stringBuffer.append("-");
            pop();
        }
        return stringBuffer.toString();
    }



    Stack<Integer> stackMain =new Stack<>();
    Stack<Integer> stackMin =new Stack<>();

    public void push(int node) {
        stackMain.push(node);
        if(stackMin.empty() || stackMin.peek() > node) {
            stackMin.push(node);
        }else {
            stackMin.push(stackMin.peek());
        }
    }

    public void pop() {
        if(!stackMain.empty()) {
            stackMain.pop();
            stackMin.pop();
        }
    }

    public int min() {
        return stackMin.peek();
    }

}
