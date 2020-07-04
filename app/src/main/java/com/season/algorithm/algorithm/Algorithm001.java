package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmFactory;
import com.season.algorithm.AlgorithmSearch;

public class Algorithm001 extends AlgorithmSearch {

    @Override
    public String getName() {
        return "001-二维数组查找";
    }

    @Override
    public String getDesc() {
        return "在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。" +
                "请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数";
    }

    Integer[][] input;
    int key;
    @Override
    public String prepare() {
        input = new Integer[][]{{1,2,3,4,5},{6,7,8,9,10}};
        key = 4;
        return "KEY="+key +"\n数组："+logArray(input);
    }

    @Override
    public void execute() {
        res = isKeyInArray(input, key);
    }

    boolean res;
    @Override
    public String verify() {
        return res?"是" +"，位置："+ logArray(position):"否";
    }

    Integer[] position = {-1, -1};
    /**
     * 从左下角开始
     * @param array
     * @param key
     * @return
     */
    public boolean isKeyInArray(Integer[][] array, int key){
        if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0))
            return false;
        int i = array.length - 1;//定位到最后一行
        int j = 0;//定位第一列
        while (i >= 0 && j <= array[0].length-1) {
            if (key > array[i][j]) {
                j++; //如果大于目前数则往右平移
            } else if (key < array[i][j]) {
                i--; //如果小于目前数则往上平移
            } else {
                position[0] = i;
                position[1] = j;
                return true;
            }
        }
        return false;
    }

    /**
     * 从右上角开始
     * @param array
     * @param key
     * @return
     */
    public boolean isKeyInArrayRT(int[][] array, int key) {
        if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0))
            return false;
        int i = 0;//定位到第一行
        int j = array[0].length - 1;//定位到最后一列
        while (i <= array.length - 1 && j >= 0) {
            if (key < array[i][j]) {
                j--;//目标数比这个数小，列数-1
            } else if (key > array[i][j]) {
                i++;//目标数比这个数大，行数加1
            } else  {
                position[0] = i;
                position[1] = j;
                return true;
            }
        }
        return false;
    }


    /**
     * 暴力全遍历
     * @param array
     * @param key
     * @return
     */
    public boolean isKeyInArrayBS(int [][] array, int key) {
        for(int i=0; i<array.length; i++){
            if(AlgorithmFactory.binarySearch(array[i],key) >= 0){
                return true;
            }
        }
        return false;
    }


}
