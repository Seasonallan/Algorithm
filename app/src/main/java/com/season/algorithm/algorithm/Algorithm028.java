package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmOther;

import java.util.HashMap;

public class Algorithm028 extends AlgorithmOther {

    @Override
    public String getName() {
        return "028-数组中出现次数超过一半的数字";
    }

    @Override
    public String getDesc() {
        return "数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。" +
                "例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。" +
                "由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。";
    }

    Integer[] input = {1,2,3,2,2,2,5,4,2};
    @Override
    public String prepare() {
        return logArray(input);
    }

    @Override
    public void execute() {
        res = findHalfMan(input);
    }

    int res;
    @Override
    public String verify() {
        return "" + res;
    }

    public int findHalfMan(Integer[] array) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<array.length;i++){
            if (map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1);
                if(map.get(array[i]) > array.length/2) {
                    return array[i];
                }
            }else{
                map.put(array[i], 1);
            }
        }
        return 0;
    }


}
