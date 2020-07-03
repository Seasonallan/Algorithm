package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmStackQueue;

import java.util.Stack;


public class Algorithm021 extends AlgorithmStackQueue {


    @Override
    public String getName() {
        return "021-栈的压入、弹出序列";
    }

    /**
     * 假设压入栈的所有数字均不相等。例如序列1、 2、 3、 4、 5是某栈的压栈序列，
     * 序列4、 5、 3、 2 、1是该压栈序列对应的一个弹出序列， (在5还没入栈之前，4先弹出， 然后5再入栈)
     * 但4、 3 、5 、1 、2就不可能是该压栈序列的弹出序列。
     * @return
     */
    @Override
    public String getDesc() {
        return "输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。";
    }


    Integer[] input = {5,9,2,4,3};
    //Integer[] output = {4,3,2,9,5};
    Integer[] output = {4,3,2,5,9};
    @Override
    public String prepare() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("入栈队列:");
        stringBuffer.append(logArray(input));
        stringBuffer.append("\n");
        stringBuffer.append("出栈队列:");
        stringBuffer.append(logArray(output));
        return stringBuffer.toString();
    }

    @Override
    public void execute() {
        res = isArrayInOut(input, output);
    }

    boolean res;
    @Override
    public String verify() {
        return res?"是":"否，"+"在第"+checkPosition+"("+output[checkPosition]+")位置发生出栈冲突";
    }

    int checkPosition = 0;
    public boolean isArrayInOut(Integer[] in, Integer[] out){
        if(in.length == 0 || out.length == 0){
            return false;
        }
        checkPosition = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < in.length; i++) {
            stack.push(in[i]);
            while (!stack.isEmpty()){
                if (stack.peek() == out[checkPosition]){//栈顶与出栈对应，出栈
                    stack.pop();
                    checkPosition ++;
                }else{
                    break;
                }
            }
        }
        return stack.isEmpty() && checkPosition == out.length;
    }
}
