package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm027 extends AlgorithmLog {

    @Override
    public String getGroup() {
        return "全排列";
    }

    @Override
    public String getName() {
        return "027-字符串的排列";
    }

    @Override
    public String getDesc() {
        return "输入一个字符串,按字典序打印出该字符串中字符的所有排列。" +
                "例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。";
    }

    String input;
    @Override
    public String prepare() {
        input = "abc";
        return input;
    }

    @Override
    public void execute() {
        res = new ArrayList<>();
        //getStringRandomBuilder(input.toCharArray(), new boolean[input.length()], "");
        //res = getStringRandomBuilder(input.toCharArray(), input.length() - 1);
        getStringRandom(input.toCharArray(), 0, input.length());
    }


    @Override
    public String verify() {
        return logList(res);
    }

    List<String> res;


    public void getStringRandom(char[] chars, int star, int end) {
        if (star==end-1) {
            res.add(new String(chars));
        }
        for (int i=star; i<end; i++) {
            swap(chars, star, i);
            getStringRandom(chars, star+1, end);
            swap(chars, star, i);
        }
    }
    public static void swap(char[] chars, int a, int b) {
        char tr = chars[a];
        chars[a] = chars[b];
        chars[b] = tr;
    }



    public static List<String> getStringRandomBuilder(char[] chars, int n) {
        List<String> list2 = new ArrayList<>();
        if (n==0) {
            list2.add(chars[0]+"");
            return list2;
        }
        List<String> list1 = getStringRandomBuilder(chars, n-1); // 获得上一级递归结果
        for (int i=0; i<list1.size(); i++) {
            String s = list1.get(i);
            list2.add(chars[n]+s); // 插在右边
            list2.add(s+chars[n]); // 插在左边
            for (int j=0; j<s.length()-1; j++) { // 循环插在某二个字符的中间
                String s2 = s.substring(0,j+1) +
                        chars[n] +
                        s.substring(j+1);
                list2.add(s2);
            }
        }
        return list2;
    }

    /**
     * @param chars 全排列的数组
     * @param res  存储前缀，最终结果的前一部分
     * @param jugs 用于判断前缀相应位置是否存在对应字符
     *             比如，pro="abcd" 那么jugs 只有jugs[4]=false,其他为true
     *
     */
    public void getStringRandomBuilder2(char[] chars, boolean[] jugs, String res) {
        if (res.length() == chars.length) {
            this.res.add(res);
        }
        for (int i=0; i<chars.length; i++) {
            if (!jugs[i]) {
                jugs[i] = true;
                getStringRandomBuilder2(chars, jugs, res + chars[i]);
                jugs[i] = false;  // 回溯 以免影响下次迭代
            }
        }
    }



}
