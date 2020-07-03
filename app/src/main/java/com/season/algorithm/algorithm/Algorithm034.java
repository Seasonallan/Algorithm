package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLog;

import java.util.Collection;
import java.util.LinkedHashMap;

public class Algorithm034 extends AlgorithmLog {


    @Override
    public String getGroup() {
        return "Hash Table";
    }

    @Override
    public String getName() {
        return "034-第一个只出现一次的字符";
    }


    @Override
    public String getDesc() {
        return "在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, " +
                "如果没有则返回 -1（需要区分大小写）";
    }


    String input = "需要区分大小写第一个只出现一次的字符区在一个字符串中找需要到第分大小写第一个只出现一次的字符,并返回它的位置";

    @Override
    public String prepare() {
        return "字符串："+input;
    }

    @Override
    public void execute() {
        index = findPosition(input, true);
    }

    int index;
    @Override
    public String verify() {
        return index < 0?"not found":""+ index +""+ input.charAt(index);
    }

    public static int findPosition(String string, boolean recordAll){
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            if (map.containsKey(character)){
                if (recordAll)
                    //记录所有字符出现的数量
                    map.put(character, map.get(character)+ 1);
                else
                    //只记录出现一次的字符
                    map.put(character, Integer.MIN_VALUE);
            }else{
                if (recordAll)
                    map.put(character, 1);
                else
                    map.put(character, i);
            }
        }
        if (recordAll){
            for (int i = 0; i < string.length(); i++) {
                Character character = string.charAt(i);
                if (map.get(character) == 1){
                    return i;
                }
            }
        }else{
            //LinkedHashMap是有序性的，与put顺序一致
            Collection<Integer> values = map.values();
            for (Integer value : values){
                if (value != Integer.MIN_VALUE){
                    return value;
                }
            }
        }
        return -1;
    }

}
