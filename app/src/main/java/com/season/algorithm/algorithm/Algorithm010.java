package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmFibonacci;

public class Algorithm010 extends AlgorithmFibonacci {

    /**
     * 倒数第一列要么就是1个2**1的矩形竖着放，要么就是2个横着放的。
     * 如果是竖着放的，那么剩下的就是n-1个小矩形，放法是F(n-1)种；
     * 如果是横着放的，放法就是F*(n-2)。
     * @return
     */
    @Override
    public String getName() {
        return "010-矩形覆盖";
    }

    @Override
    public String getDesc() {
        return "我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？";
    }

    int n = 61;
    @Override
    public String prepare() {
        return "n:" + n;
    }

    long res;
    @Override
    public void execute() {
        res = FibonacciRecord(n, 0, 1, 2);
    }

    @Override
    public String verify() {
        return res+"";
    }

}
