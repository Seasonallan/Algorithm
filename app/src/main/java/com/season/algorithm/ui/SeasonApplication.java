package com.season.algorithm.ui;

import android.app.Application;

import com.season.algorithm.AlgorithmFactory;
import com.season.algorithm.algorithm.Algorithm001;
import com.season.algorithm.algorithm.Algorithm003;
import com.season.algorithm.algorithm.Algorithm004;
import com.season.algorithm.algorithm.Algorithm005;
import com.season.algorithm.algorithm.Algorithm006;
import com.season.algorithm.algorithm.Algorithm007;
import com.season.algorithm.algorithm.Algorithm008;
import com.season.algorithm.algorithm.Algorithm009;
import com.season.algorithm.algorithm.Algorithm010;
import com.season.algorithm.algorithm.Algorithm014;
import com.season.algorithm.algorithm.Algorithm015;
import com.season.algorithm.algorithm.Algorithm016;
import com.season.algorithm.algorithm.Algorithm017;
import com.season.algorithm.algorithm.Algorithm018;
import com.season.algorithm.algorithm.Algorithm020;
import com.season.algorithm.algorithm.Algorithm021;
import com.season.algorithm.algorithm.Algorithm022;
import com.season.algorithm.algorithm.Algorithm023;
import com.season.algorithm.algorithm.Algorithm024;
import com.season.algorithm.algorithm.Algorithm025;
import com.season.algorithm.algorithm.Algorithm026;
import com.season.algorithm.algorithm.Algorithm027;
import com.season.algorithm.algorithm.Algorithm029;
import com.season.algorithm.algorithm.Algorithm030;
import com.season.algorithm.algorithm.Algorithm034;
import com.season.algorithm.algorithm.Algorithm036;
import com.season.algorithm.algorithm.Algorithm037;
import com.season.algorithm.algorithm.Algorithm038;
import com.season.algorithm.algorithm.Algorithm039;
import com.season.algorithm.algorithm.Algorithm044;
import com.season.algorithm.algorithm.Algorithm052;
import com.season.algorithm.algorithm.Algorithm055;
import com.season.algorithm.algorithm.Algorithm056;
import com.season.algorithm.algorithm.Algorithm057;
import com.season.algorithm.algorithm.Algorithm058;
import com.season.algorithm.algorithm.Algorithm059;
import com.season.algorithm.algorithm.Algorithm060;
import com.season.algorithm.algorithm.Algorithm061;
import com.season.algorithm.algorithm.Algorithm062;
import com.season.algorithm.algorithm.Algorithm064;
import com.season.algorithm.algorithm.Algorithm065;
import com.season.algorithm.algorithm.Algorithm066;

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

        AlgorithmFactory.getInstance().register(new Algorithm005());
        AlgorithmFactory.getInstance().register(new Algorithm020());
        AlgorithmFactory.getInstance().register(new Algorithm021());
        AlgorithmFactory.getInstance().register(new Algorithm044());
        AlgorithmFactory.getInstance().register(new Algorithm064());

        AlgorithmFactory.getInstance().register(new Algorithm029());

        AlgorithmFactory.getInstance().register(new Algorithm034());

        AlgorithmFactory.getInstance().register(new Algorithm065());
        AlgorithmFactory.getInstance().register(new Algorithm066());

        AlgorithmFactory.getInstance().register(new Algorithm007());
        AlgorithmFactory.getInstance().register(new Algorithm008());
        AlgorithmFactory.getInstance().register(new Algorithm009());
        AlgorithmFactory.getInstance().register(new Algorithm010());

        AlgorithmFactory.getInstance().register(new Algorithm001());
        AlgorithmFactory.getInstance().register(new Algorithm006());
        AlgorithmFactory.getInstance().register(new Algorithm037());

        AlgorithmFactory.getInstance().register(new Algorithm027());

        AlgorithmFactory.getInstance().register(new Algorithm030());
        AlgorithmFactory.getInstance().register(new Algorithm052());

    }
}
