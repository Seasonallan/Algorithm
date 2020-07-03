package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmStackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Algorithm064 extends AlgorithmStackQueue {


    @Override
    public String getName() {
        return "064-滑动窗口的最大值(双端队列)";
    }

    /**
     * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 窗口大小为3
     * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
     * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     * ————————————————
     * @return
     */
    @Override
    public String getDesc() {
        return "给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。";
    }


    Integer[] array = {2,3,4,2,6,2,5,1};
    int size = 3;
    @Override
    public String prepare() {
        return "窗口大小："+size + " \n数组："+logArray(array);
    }

    @Override
    public void execute() {
        res = getMaxFromWindow(array, size);
    }

    ArrayList<Integer> res;
    @Override
    public String verify() {
        return logList(res);
    }

    public ArrayList<Integer> getMaxFromWindow(Integer[] num, int size){
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> deque = new LinkedList<>();

        //判断异常输入情况
        if(num==null||size<=0||size>num.length) {
            return list;
        }
        //开始滑动窗口
        for(int i=0; i<num.length; i++){
            //如果当前遍历到的数大于双端队列的末尾值（候选窗口最大值），
            //就去除掉队列的末尾值。
            while(!deque.isEmpty()&&num[i]>=num[deque.peekLast()]){
                deque.removeLast();
            }
            //若当前滑动窗口已滑出，则去掉队列首端的最大值
            if(!deque.isEmpty()&&i-deque.peekFirst()>=size){
                deque.removeFirst();
            }
            deque.addLast(i);
            //滑动索引大于size开始，每滑动一次就添加一次当前窗口极大值
            if(i>=size-1){
                list.add(num[deque.peekFirst()]);
            }
        }
        return list;

    }
}
