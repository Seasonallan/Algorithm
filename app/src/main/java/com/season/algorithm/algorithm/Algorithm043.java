package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmOther;

public class Algorithm043 extends AlgorithmOther {

    @Override
    public String getName() {
        return "043-左旋转字符串(矩阵翻转)";
    }

    /**
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
     * @return
     */
    @Override
    public String getDesc() {
        return "对于一个给定的字符序列S，请你把其循环左移K位后的序列输出";
    }

    String input = "abcXYZdef";
    int count = 3;
    @Override
    public String prepare() {
        return "左移："+count +"\n字符串："+input;
    }

    @Override
    public void execute() {
       res = getLRString(input, count);
    }

    String res;
    @Override
    public String verify() {
        return res;
    }

    public String getLRString(String str,int n) {
        return (str + str).substring(n, str.length() + n % str.length());
    }


}
