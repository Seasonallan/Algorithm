package com.season.algorithm;

public interface IAlgorithm {
    String getGroup();
    String getName();
    String getDesc();
    String prepare();
    void execute();
    String verify();
}
