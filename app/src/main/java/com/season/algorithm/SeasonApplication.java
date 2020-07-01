package com.season.algorithm;

import android.app.Application;

import com.season.algorithm.algorithm.Algorithm003;
import com.season.algorithm.algorithm.Algorithm014;
import com.season.algorithm.algorithm.Algorithm015;
import com.season.algorithm.algorithm.Algorithm016;
import com.season.algorithm.algorithm.Algorithm025;
import com.season.algorithm.algorithm.Algorithm036;
import com.season.algorithm.algorithm.Algorithm055;
import com.season.algorithm.algorithm.Algorithm056;

public class SeasonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AlgorithmFactory.getInstance().register(new Algorithm003());
        AlgorithmFactory.getInstance().register(new Algorithm014());
        AlgorithmFactory.getInstance().register(new Algorithm015());
        AlgorithmFactory.getInstance().register(new Algorithm016());
        AlgorithmFactory.getInstance().register(new Algorithm025());
        AlgorithmFactory.getInstance().register(new Algorithm036());
        AlgorithmFactory.getInstance().register(new Algorithm055());
        AlgorithmFactory.getInstance().register(new Algorithm056());

    }
}
