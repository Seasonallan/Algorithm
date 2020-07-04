package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmSearch;

public class Algorithm037 extends AlgorithmSearch {

    @Override
    public String getName() {
        return "037-数字在排序数组中出现的次数（二分查找）";
    }

    /**
     * 找到第一个 和 最后一个的位置 然后就可以统计次数了
     * @return
     */
    @Override
    public String getDesc() {
        return "统计一个数字在排序数组中出现的次数。";
    }

    Integer[] input;
    int key = 3;
    @Override
    public String prepare() {
        input = new Integer[]{1,2,3,3,3,3,3,3,3,3,3,4,5,9,9,9,9,9,11,16};
        return "K="+key + "\n数组："+logArray(input);
    }

    @Override
    public void execute() {
        res = countInArray(input, key);
    }

    int res;
    @Override
    public String verify() {
        return res+"";
    }

    /**
     * 利用二分法先找到某个k然后往前往后找k并计数，直到不是k为止，适用于k比较小的情况，k比较大时会退化成O(N)
     */
    public int countInArrayBS(Integer[] array, int k) {
        if (array == null || array.length == 0) return 0;
        int left = 0;
        int right = array.length - 1;
        int mid = ((right - left) >> 1) + left;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (array[mid] == k) {
                break;
            } else if (array[mid] > k) {
                right = mid - 1;
            } else left = mid + 1;
        }
        int count = 0;
        int temp = mid + 1;
        while (mid >= 0 && array[mid--] == k) count++;
        while (temp < array.length && array[temp++] == k) count++;
        return count;
    }


    /**
     * 利用二分法找到k+1 与k 第一次出现的位置，差
     */
    public int countInArray(Integer[] array, int k) {
        if (array == null || array.length == 0) return 0;
        return getLeft(array,k+1) - getLeft(array, k);
        //return getRight(array,k) - getLeft(array, k);
    }

    /**
     * 找出数字在数组中最左边出现的位置;
     */
    public int getLeft(Integer[] array, int k) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (array[mid] >= k) {
                right = mid - 1;//找到k后向左走
            } else {
                left = mid + 1;
            }
        }
        return ((right - left) >> 1) + left;
    }

    /**
     * 找出数字在数组中最右边出现的位置;
     */
    public int getRight(Integer[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (array[mid] > k) {
                right = mid - 1;//找到k后向右走
            } else {
                left = mid + 1;
            }
        }
        return ((right - left) >> 1) + left;
    }


}
