package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmSearch;

public class Algorithm006 extends AlgorithmSearch {

    @Override
    public String getName() {
        return "006-旋转数组的最小数字（二分查找";
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * @return
     */
    @Override
    public String getDesc() {
        return "输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。";
    }

    Integer[] input;
    @Override
    public String prepare() {
        input = new Integer[]{3,4,5,1,2};
        input = new Integer[]{3,4,2,2,2};
        return logArray(input);
    }

    @Override
    public void execute() {
        res = minInArray(input);
    }

    int res;
    @Override
    public String verify() {
        return res+"";
    }


    public int minInArray(Integer[] array){
        int low = 0;
        int high = array.length - 1;
        //二分法搜索
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]) {
                //1.最小数一定在mid右边
                low = mid + 1;
            } else if(array[mid] == array[high]) {
                //2.不确定在mid的哪一侧，high-1继续判断
                high--;
            } else {
                //3.mid < high mid右边为非递减，最小数一定在mid或者mid左边
                high = mid;
            }
        }
        return array[low];
    }

}
