package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmOther;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Algorithm032 extends AlgorithmOther {

    @Override
    public String getName() {
        return "032-把数组排成最小的数";
    }

    @Override
    public String getDesc() {
        return "输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。" +
                "例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。";
    }

    Integer[] input = {3,32,321};
    int key;
    @Override
    public String prepare() {
        return logArray(input);
    }

    @Override
    public void execute() {
        res = getMinNumber(input);
    }

    String res;
    @Override
    public String verify() {
        return res;
    }

    public String getMinNumber(Integer[] array) {
        ArrayList<Integer> arrayList= new ArrayList<>();
        for(int j = 0; j < array.length; j++){
            arrayList.add(array[j]);
        }
        Collections.sort(arrayList, new Comparator<Integer>(){
            @Override
            public int compare(Integer s1, Integer s2){
                return (s1 +"" + s2).compareTo(s2 +"" + s1);
            }
        });
        StringBuilder s  = new StringBuilder();
        for(Integer str : arrayList){
            s.append(str);
        }
        return s.toString();
    }




}
