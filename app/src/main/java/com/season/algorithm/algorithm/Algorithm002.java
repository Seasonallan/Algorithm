package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmOther;

public class Algorithm002 extends AlgorithmOther {

    @Override
    public String getName() {
        return "002-替换空格";
    }

    @Override
    public String getDesc() {
        return "请实现一个函数，将一个字符串中的每个空格替换成“%20”。" +
                "例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。";
    }

    String input = "We Are Happy";
    @Override
    public String prepare() {
        return input;
    }

    @Override
    public void execute() {
        res = input.replaceAll(" ", "%20");
        res = replaceSpace(input);
    }

    String res;
    @Override
    public String verify() {
        return res;
    }

    public String replaceSpace(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
