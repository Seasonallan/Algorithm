package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm030 extends AlgorithmLog {

    @Override
    public String getGroup() {
        return "动态规划";
    }

    @Override
    public String getName() {
        return "030-连续子数组的最大和";
    }

    @Override
    public String getDesc() {
        return "给定一个一维整型数组，请这个数组中连续子数组的最大和。";
    }

    Integer[] input = {6,-3,-2,7,-15,1,2,2};
    @Override
    public String prepare() {
        input = new Integer[]{1,-2,3,10,-4,7,2,-5};
        return logArray(input);
    }

    @Override
    public void execute() {
        res = getMaxSumInArray(input);
        log( ">>"+ firstIndex +", "+ lastIndex);
    }


    @Override
    public String verify() {
        return ""+res +",数组"+logArray(Arrays.copyOfRange(input, firstIndex, lastIndex));
    }

    int res;
    int firstIndex, lastIndex;

    public int getMaxSumInArray(Integer nums[]){
        int lens = nums.length;
        if(nums == null || lens == 0){
            return 0;
        }
        int nCurSum = 0;
        int nGreatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < lens; i++) {
            if(nCurSum <= 0){
                nCurSum = nums[i]; //前排部分和小于零时，初始位置修正
                firstIndex = i;
            }else{
                nCurSum += nums[i];
            }
            if(nCurSum > nGreatestSum){
                nGreatestSum = nCurSum;
                lastIndex = i;
            }
        }
        return nGreatestSum;
    }


}
