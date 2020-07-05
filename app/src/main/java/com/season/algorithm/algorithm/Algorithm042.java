package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmOther;

public class Algorithm042 extends AlgorithmOther {

    @Override
    public String getName() {
        return "042-和为S的两个数字(双指针思想)";
    }

    /**
     * （相差越远乘积越小）
     * @return
     */
    @Override
    public String getDesc() {
        return "输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，" +
                "如果有多对数字的和等于S，输出两个数的乘积最小的。" ;
    }

    Integer[] input = {1,5,8,11,16,19,22,34,65};
    int key = 27;
    @Override
    public String prepare() {
        return "KEY="+key +"\n数组："+logArray(input);
    }

    @Override
    public void execute() {
        res = getSumEquals(input, key);
    }

    Integer[] res;
    @Override
    public String verify() {
        return logArray(res);
    }

    /**
     * 数列满足递增，设两个头尾两个指针i和j，
     * 若ai + aj == sum，就是答案
     * 若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
     * 若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
     * @param array
     * @param sum
     * @return
     */
    public Integer[] getSumEquals(Integer[] array, int sum) {
        int i = 0;
        int j = array.length - 1;
        while( i < j ){
            if(array[i] + array[j] == sum){
                return new Integer[]{array[i], array[j]};
            }
            if(array[i] + array[j] > sum){
                j --;
            }
            if(array[i] + array[j] < sum){
                i ++;
            }
        }
        return null;
    }

}
