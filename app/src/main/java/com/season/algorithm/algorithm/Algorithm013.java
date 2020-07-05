package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmOther;

public class Algorithm013 extends AlgorithmOther {

    @Override
    public String getName() {
        return "013-调整数组顺序使奇数位于偶数前面";
    }

    @Override
    public String getDesc() {
        return "输入一个整数数组，实现一个函数来调整该数组中数字的顺序，" +
                "使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，" +
                "并保证奇数和奇数，偶数和偶数之间的相对位置不变。";
    }

    Integer[] input = {1,2,3,4,5,6,7,8,9};
    @Override
    public String prepare() {
        return logArray(input);
    }

    @Override
    public void execute() {
        reOrderArray(input);
    }

    boolean res;
    @Override
    public String verify() {
        return logArray(input);
    }

    public void reOrderArray(Integer[] array) {

        int oddCnt = 0;
        //算出所有奇数的个数
        for (int x : array)
            if (x % 2 != 0)
                oddCnt++;
        Integer[] copy = array.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1)
                array[i++] = num;
            else
                array[j++] = num;
        }
    }

    public void reOrderArray_(Integer[] array) {

        for (int i = 0; i < array.length;i++)
        {
            for (int j = 0; j<array.length-1; j++)
            {
                if (array[j+1] % 2 == 1 && array[j]%2 == 0) //前偶后奇交换
                {
                    int t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
    }

}