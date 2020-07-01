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
}
