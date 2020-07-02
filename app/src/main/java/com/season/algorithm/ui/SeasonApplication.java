package com.season.algorithm.ui;

import android.app.Application;

import com.season.algorithm.AlgorithmFactory;
import com.season.algorithm.algorithm.Algorithm003;
import com.season.algorithm.algorithm.Algorithm004;
import com.season.algorithm.algorithm.Algorithm014;
import com.season.algorithm.algorithm.Algorithm015;
import com.season.algorithm.algorithm.Algorithm016;
import com.season.algorithm.algorithm.Algorithm017;
import com.season.algorithm.algorithm.Algorithm018;
import com.season.algorithm.algorithm.Algorithm022;
import com.season.algorithm.algorithm.Algorithm023;
import com.season.algorithm.algorithm.Algorithm024;
import com.season.algorithm.algorithm.Algorithm025;
import com.season.algorithm.algorithm.Algorithm026;
import com.season.algorithm.algorithm.Algorithm036;
import com.season.algorithm.algorithm.Algorithm038;
import com.season.algorithm.algorithm.Algorithm039;
import com.season.algorithm.algorithm.Algorithm055;
import com.season.algorithm.algorithm.Algorithm056;
import com.season.algorithm.algorithm.Algorithm057;
import com.season.algorithm.algorithm.Algorithm058;
import com.season.algorithm.algorithm.Algorithm059;
import com.season.algorithm.algorithm.Algorithm060;
import com.season.algorithm.algorithm.Algorithm061;
import com.season.algorithm.algorithm.Algorithm062;

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

        AlgorithmFactory.getInstance().register(new Algorithm004());
        AlgorithmFactory.getInstance().register(new Algorithm017());
        AlgorithmFactory.getInstance().register(new Algorithm018());
        AlgorithmFactory.getInstance().register(new Algorithm022());
        AlgorithmFactory.getInstance().register(new Algorithm023());
        AlgorithmFactory.getInstance().register(new Algorithm024());
        AlgorithmFactory.getInstance().register(new Algorithm026());
        AlgorithmFactory.getInstance().register(new Algorithm038());
        AlgorithmFactory.getInstance().register(new Algorithm039());
        AlgorithmFactory.getInstance().register(new Algorithm057());
        AlgorithmFactory.getInstance().register(new Algorithm058());
        AlgorithmFactory.getInstance().register(new Algorithm059());
        AlgorithmFactory.getInstance().register(new Algorithm060());
        AlgorithmFactory.getInstance().register(new Algorithm061());
        AlgorithmFactory.getInstance().register(new Algorithm062());


    }
}
