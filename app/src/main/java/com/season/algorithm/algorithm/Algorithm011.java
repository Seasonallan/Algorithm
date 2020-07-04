package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmBitOp;

public class Algorithm011 extends AlgorithmBitOp {

    @Override
    public String getName() {
        return "011-二进制中1的个数";
    }

    @Override
    public String getDesc() {
        return "输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。";
    }

    int n = 61;
    @Override
    public String prepare() {
        return "" + n;
    }

    long res;
    @Override
    public void execute() {
        stringBuffer = new StringBuffer();
        res = NumberOf1_(n);
    }

    @Override
    public String verify() {
        return res+"个1 :"+stringBuffer.toString();
    }

    StringBuffer stringBuffer;
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag <= n) {
            if ((n & flag) != 0) {
                count++;
                stringBuffer.append(1);
            }else{
                stringBuffer.append(0);
            }
            flag = flag << 1;   //左移    例如1  变成10
        }
        return count;
    }

    /**
     * 把一个整数减1，再和原来的整数做与运算，会把该整数最右边的1变成0。
     * 这种方法，整数中有几个1，就只需要循环判断几次。
     * @param n
     * @return
     */
    public int NumberOf1_(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

}
