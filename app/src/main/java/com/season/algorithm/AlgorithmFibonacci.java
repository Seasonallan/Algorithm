package com.season.algorithm;


/**
 * 第一年有一对小兔子，一年后成年。
 * 成年的兔子又可以生出一对小兔子，如此循环往复，每年的兔子数就构成了一个斐波那契数列。
 * 1       0
 * 1       1
 * 2    0       1
 * 3    1    0    1
 * 5  0  1   1   0    1
 * 8  1 0 1 0 1  1  0   1
 *
 * F(0)=1，F(1)=1, F(n)=F(n-1)+F(n-2)
 */
public abstract class AlgorithmFibonacci extends AlgorithmLog {

    @Override
    public String getGroup() {
        return "斐波那契数列";
    }

    /**
     * 递归
     * 问题：会重复计算大量相同数据
     * @param n
     * @return
     */
    public long Fibonacci(int n) {
        //（从0开始，第0项为0，第1项是1）
        if(n <= 1){
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    /**
     * 数组记录
     * @param n
     * @return
     */
    public long FibonacciArray(int n) {
        long ans[] = new long[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        for(int i=2;i<=n;i++){
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[n];
    }

    /**
     * 记录循环i前面两个位置的数据
     * @param n
     * @return
     */
    public long FibonacciRecord(int n) {
        return FibonacciRecord(n, 0, 1, 1);
    }

    /**
     * 记录循环i前面两个位置的数据
     * @param n
     * @return
     */
    public long FibonacciRecord(int n, int node0, int node1, int node2) {
        if(n == 0){
            return node0;
        }else if(n == 1){
            return node1;
        }else if(n == 2){
            return node2;
        }
        long current = node2; //i位置的值
        long record = node2;//i-2位置的值
        long last = node1;  //i-1位置的值
        for(int i=3;i<=n;i++){
            current = record + last;
            record = last;
            last = current;
        }
        return current;
    }



}
