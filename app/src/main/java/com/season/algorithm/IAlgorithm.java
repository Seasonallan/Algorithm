package com.season.algorithm;

public interface IAlgorithm {
    public static final String TAG = "Algorithm";
    String getGroup();
    String getName();
    String getDesc();
    void prepare();
    void execute();
    void verify();
}
