package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmOther;

public class Algorithm051 extends AlgorithmOther {

    @Override
    public String getName() {
        return "051-构建乘积数组";
    }

    @Override
    public String getDesc() {
        return "给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1]," +
                "其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。";
    }

    Integer[] input = {1,3,4,5,8,6,5};

    @Override
    public String prepare() {
        return logArray(input);
    }

    @Override
    public void execute() {
        res = multiply(input);
    }

    Integer[] res;
    @Override
    public String verify() {
        return logArray(res);
    }


    public Integer[] multiply(Integer[] A) {
        /*这道题的中心思想是将返回的数据列成一个矩阵，每一个矩阵的行向量都是一个从a(0)到a(n-1)
          ,然后这个对角线都是1.那么此时B0的值就是A0为一，剩下的行向量相乘。
        */
        int length = A.length;
        Integer[] B = new Integer[length];
        B[0] = 1;
        for(int i = 1; i < length; i ++){
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for(int j = length - 2; j >= 0; j --){
            temp *= A[j + 1];//temp始终会记录值，每次只需要加上这行上三角没有乘进来的数就可以了。
            B[j] *= temp;
        }
        return B;
    }


}
