package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmFibonacci;

public class Algorithm007 extends AlgorithmFibonacci {

    @Override
    public String getName() {
        return "007-斐波拉契数列";
    }

    @Override
    public String getDesc() {
        return "现在要求输入一个整数n，请你输出斐波那契数列的第n项" +
                "";
    }

    int n = 61;
    @Override
    public String prepare() {
        return "n:" + n;
    }

    long res;
    @Override
    public void execute() {
        res = FibonacciRecord(n);
    }

    @Override
    public String verify() {
        return res+"";
    }

}
