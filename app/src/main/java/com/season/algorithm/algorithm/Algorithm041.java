package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmOther;

import java.util.ArrayList;

public class Algorithm041 extends AlgorithmOther {

    @Override
    public String getName() {
        return "041-和为S的连续正数序列(滑动窗口思想)";
    }

    @Override
    public String getDesc() {
        return "输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序";
    }

    int sum = 100;
    @Override
    public String prepare() {
        return ""+sum;
    }

    @Override
    public void execute() {
        res = getSumCSequence(sum);
    }

    ArrayList<ArrayList<Integer>> res;
    @Override
    public String verify() {
        return logList(res);
    }

    public ArrayList<ArrayList<Integer>> getSumCSequence(int sum) {
        int pL = 1, pR = 2;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(pL < pR) {
            int cur = (pL + pR) * (pR - pL + 1) / 2;
            if(cur == sum) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for(int i = pL; i <= pR; i++) {
                    tmp.add(i);
                }
                res.add(tmp);
                pL++;
            } else if(cur < sum) {
                pR++;
            } else {
                pL++;
            }
        }
        return res;
    }


}
