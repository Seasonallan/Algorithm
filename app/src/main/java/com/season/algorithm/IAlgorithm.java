package com.season.algorithm;

public interface IAlgorithm {
    public static final String TAG = "Algorithm";
    String getGroup();
    String getName();
    String getDesc();
    String prepare();
    void execute();
    String verify();
}
