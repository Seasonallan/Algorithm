package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmFactory;
import com.season.algorithm.AlgorithmLog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class Algorithm029 extends AlgorithmLog {


    @Override
    public String getGroup() {
        return "Heap";
    }

    @Override
    public String getName() {
        return "029-最小的K个数";
    }

    /**
     * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * 思路1，快速排序，某一个位置，小的在左边，如果该位置<k,则右边进行快排，递归到快排的位置=k即可
     * 思路2：大小为K的容器TreeSet
     * 当数组数量小时，使用快速排序
     * @return
     */
    @Override
    public String getDesc() {
        return "输入n个整数，找出其中最小的K个数。";
    }


    Integer[] array = {2,3,4,2,6,2,5,1};
    int size = 3;
    int arraySize = 50000;
    @Override
    public String prepare() {
        array = new Integer[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = new Random().nextInt(arraySize);
        }
        return "K："+size + " \n数组大小："+arraySize;
    }

    @Override
    public void execute() {
        long time = System.currentTimeMillis();
        res = getLeastArrayVector(array, size);
        costVector = System.currentTimeMillis() - time;
        res = getLeastArrayFastRank(array, size);
        costFast = System.currentTimeMillis() - time - costVector;
    }

    ArrayList<Integer> res;
    long costFast, costVector;
    @Override
    public String verify() {
        return "快速排序耗时："+ costFast +"ms ,树容器耗时："+ costVector+"ms";
    }


    /**
     * 思路2：大小为K的容器TreeSet
     * TreeSet是一个有序的集合,它的作用是提供有序的Set集合
     * @param array
     * @param k
     * @return
     */
    public static ArrayList<Integer> getLeastArrayVector(Integer[] array, int k){
        ArrayList<Integer> list = new ArrayList<>();
        int lens = array.length;
        if(array == null || lens == 0 || k > lens || k <= 0){
            return list;
        }
        TreeSet<Integer> kSet = new TreeSet<>();
        for (int i = 0; i < lens; i++) {
            if(kSet.size() < k){
                kSet.add(array[i]);
            }else if(array[i] < kSet.last()){
                kSet.remove(kSet.last());
                kSet.add(array[i]);
            }
        }
        Iterator<Integer> iterator = kSet.iterator();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }



    /**
     * 思路1，快速排序，某一个位置，小的在左边，如果该位置<k,则右边进行快排，递归到快排的位置=k即可
     * @param array
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastArrayFastRank(Integer[] array, int k){
        ArrayList<Integer> list = new ArrayList<>();
        int lens = array.length;
        if(array == null || lens == 0 || k > lens || k <= 0){
            return list;
        }
        int start = 0;
        int end = lens - 1;
        int index = AlgorithmFactory.partition(array, start, end);
        while(index != k-1){
            if(index > k-1){
                end = index - 1;
                index = AlgorithmFactory.partition(array, start, end);
            }else{
                start = index + 1;
                index = AlgorithmFactory.partition(array, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(array[i]);
        }
        return list;
    }

}
