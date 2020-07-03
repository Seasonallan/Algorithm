package com.season.algorithm;

import java.util.HashMap;

public class AlgorithmFactory {

    private static AlgorithmFactory sFactory;
    static {
        sFactory = new AlgorithmFactory();
    }

    public static AlgorithmFactory getInstance(){
        return sFactory;
    }

    private HashMap<String, String> map = new HashMap<>();
    public void register(IAlgorithm iAlgorithm){
        map.put(iAlgorithm.getName(), iAlgorithm.getClass().getName());
    }


    public IAlgorithm getAlgorithm(String name){
        String className = map.get(name);
        try {
            if (className != null)
                return (IAlgorithm) Class.forName(className).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 快速排序
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(Integer[] array, int start, int end) {
        int key = array[start];
        while(start < end){
            while(start < end && key <= array[end]){
                --end;
            }
            swap(array, start, end);

            while(start < end && key >= array[start]){
                ++start;
            }
            swap(array, start, end);
        }
        return start;
    }

    public static void swap(Integer[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

}
