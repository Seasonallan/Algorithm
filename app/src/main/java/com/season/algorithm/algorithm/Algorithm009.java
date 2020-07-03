package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmFibonacci;

public class Algorithm009 extends AlgorithmFibonacci {

    /**
     * 如果有n-1个台阶 则 有   f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) 个方法
     * 如果有n个台阶 则 有   f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) 个方法
     * 两个式子 化简就可以得到  f(n) = 2*f(n-1)；
     *
     * @return
     */
    @Override
    public String getName() {
        return "009-变态跳台阶";
    }

    @Override
    public String getDesc() {
        return "一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。" +
                "求该青蛙跳上一个n级的台阶总共有多少种跳法。";
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

    @Override
    public long FibonacciRecord(int n) {
        if(n <= 1){
            return n;
        }
        long current = 0; //i位置的值
        long last = 1;  //i-1位置的值
        for(int i=2;i<=n;i++){
            current = 2 * last;
            last = current;
        }
        return current;
    }



}
