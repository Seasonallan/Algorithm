package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmStackQueue;

import java.util.Stack;

public class Algorithm044 extends AlgorithmStackQueue {


    @Override
    public String getName() {
        return "044-翻转单词顺序列(栈)";
    }

    /**
     * “student. a am I”。 翻转为 “I am a student.”
     * 先翻转单词部分，后翻转整个句子和先翻转句子再翻转单词，效果一样。
     * @return
     */
    @Override
    public String getDesc() {
        return "“student. a am I”。 翻转为 “I am a student.”";
    }


    String input = "student a am I";
    @Override
    public String prepare() {
        return input;
    }

    @Override
    public void execute() {
        res = reverseWord(input);
    }

    String res;
    @Override
    public String verify() {
        return res;
    }

    public String reverseWord(String input){
        String[] splits = input.split(" ");
        if (splits == null || splits.length == 0){
            return input;
        }
        Stack<String> stack = new Stack<>();
        for (String item:splits){
            stack.push(item);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()){
            stringBuffer.append(stack.pop());
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }
}
