package com.season.algorithm;

import android.util.Log;

import java.util.List;
import java.util.Stack;


public abstract class AlgorithmStackQueue implements IAlgorithm {

    @Override
    public String getGroup() {
        return "Stack & Queue";
    }


    public static <T> String logStack(Stack<T> stack){
        StringBuffer stringBuffer = new StringBuffer();
        for (T item : stack){
            stringBuffer.append(item);
            stringBuffer.append("-");
        }
        return stringBuffer.toString();
    }


    /**
     * 打印列表
     * @param listNode
     */
    public static String logList(List listNode){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < listNode.size(); i++) {
            if (listNode.get(i) instanceof List){
                stringBuffer.append("(");
                stringBuffer.append(logList((List) listNode.get(i)));
                stringBuffer.append(")");
            }else{
                stringBuffer.append(listNode.get(i));
            }
            stringBuffer.append("-");
        }
        Log.e(TAG, stringBuffer.toString());
        return stringBuffer.toString();
    }

    /**
     * 打印数组
     * @param listNode
     */
    public static <T> String logArray(T[] listNode){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < listNode.length; i++) {
            stringBuffer.append(listNode[i]);
            stringBuffer.append("-");
        }
        Log.e(TAG, stringBuffer.toString());
        return stringBuffer.toString();
    }

}
