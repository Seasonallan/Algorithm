package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmStackQueue;

import java.util.Stack;


public class Algorithm005 extends AlgorithmStackQueue {


    /**
     * 栈：先进后出，一般从尾部添加，也从尾部删除。
     * 队列：先进先出，从尾部添加，从头部删除。
     * @return
     */
    @Override
    public String getName() {
        return "005-用两个栈实现队列";
    }

    @Override
    public String getDesc() {
        return "用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。";
    }


    Integer[] input = {1,2,3,4,5};
    @Override
    public String prepare() {
        return logArray(input);
    }

    @Override
    public void execute() {
        for (Integer i : input){
            push(i);
        }
    }

    @Override
    public String verify() {
        StringBuffer stringBuffer = new StringBuffer();
        while (!isEmpty()){
            stringBuffer.append(pop());
            stringBuffer.append("-");
        }
        return stringBuffer.toString();
    }

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


}
