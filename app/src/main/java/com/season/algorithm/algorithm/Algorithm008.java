package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmFibonacci;

public class Algorithm008 extends AlgorithmFibonacci {

    /**
     * 类斐波那契数列算法，只是前几个项不符合>>F(0)=-1，F(1)=1,F(2)=2, F(n)=F(n-1)+F(n-2)
     * @return
     */
    @Override
    public String getName() {
        return "008-跳台阶";
    }

    @Override
    public String getDesc() {
        return "一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法";
    }

    int n = 61;
    @Override
    public String prepare() {
        return "n:" + n;
    }

    long res;
    @Override
    public void execute() {
        res = FibonacciRecord(n, -1, 1, 2);
    }

    @Override
    public String verify() {
        return res+"";
    }

}
