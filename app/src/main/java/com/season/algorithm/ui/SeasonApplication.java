package com.season.algorithm.ui;

import android.app.Application;
import android.os.Handler;

import com.season.algorithm.AlgorithmFactory;
import com.season.algorithm.algorithm.Algorithm001;
import com.season.algorithm.algorithm.Algorithm002;
import com.season.algorithm.algorithm.Algorithm003;
import com.season.algorithm.algorithm.Algorithm004;
import com.season.algorithm.algorithm.Algorithm005;
import com.season.algorithm.algorithm.Algorithm006;
import com.season.algorithm.algorithm.Algorithm007;
import com.season.algorithm.algorithm.Algorithm008;
import com.season.algorithm.algorithm.Algorithm009;
import com.season.algorithm.algorithm.Algorithm010;
import com.season.algorithm.algorithm.Algorithm011;
import com.season.algorithm.algorithm.Algorithm012;
import com.season.algorithm.algorithm.Algorithm013;
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
import com.season.algorithm.algorithm.Algorithm028;
import com.season.algorithm.algorithm.Algorithm029;
import com.season.algorithm.algorithm.Algorithm030;
import com.season.algorithm.algorithm.Algorithm031;
import com.season.algorithm.algorithm.Algorithm032;
import com.season.algorithm.algorithm.Algorithm033;
import com.season.algorithm.algorithm.Algorithm034;
import com.season.algorithm.algorithm.Algorithm035;
import com.season.algorithm.algorithm.Algorithm036;
import com.season.algorithm.algorithm.Algorithm037;
import com.season.algorithm.algorithm.Algorithm038;
import com.season.algorithm.algorithm.Algorithm039;
import com.season.algorithm.algorithm.Algorithm040;
import com.season.algorithm.algorithm.Algorithm041;
import com.season.algorithm.algorithm.Algorithm042;
import com.season.algorithm.algorithm.Algorithm043;
import com.season.algorithm.algorithm.Algorithm044;
import com.season.algorithm.algorithm.Algorithm046;
import com.season.algorithm.algorithm.Algorithm051;
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
import com.season.lib.util.LogUtil;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SeasonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();



       // checkApi();

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

        AlgorithmFactory.getInstance().register(new Algorithm035());

        AlgorithmFactory.getInstance().register(new Algorithm011());
        AlgorithmFactory.getInstance().register(new Algorithm012());
        AlgorithmFactory.getInstance().register(new Algorithm040());

        AlgorithmFactory.getInstance().register(new Algorithm002());
        AlgorithmFactory.getInstance().register(new Algorithm013());
        AlgorithmFactory.getInstance().register(new Algorithm028());
        AlgorithmFactory.getInstance().register(new Algorithm031());
        AlgorithmFactory.getInstance().register(new Algorithm032());
        AlgorithmFactory.getInstance().register(new Algorithm033());
        AlgorithmFactory.getInstance().register(new Algorithm041());
        AlgorithmFactory.getInstance().register(new Algorithm042());
        AlgorithmFactory.getInstance().register(new Algorithm043());
        AlgorithmFactory.getInstance().register(new Algorithm046());
        AlgorithmFactory.getInstance().register(new Algorithm051());
    }



    private void checkApi() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//@GET("/recommendations/city")
                    URL url;
                    HttpURLConnection connection;
                    url = new URL("https://api.vipflonline.com/recommendations/system");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    StringBuilder stringBuilder = new StringBuilder();
                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        //得到服务器响应的输入流
                        InputStream inputStream = connection.getInputStream();
                        //获取请求的内容总长度
                        int contentLength = connection.getContentLength();
                        BufferedInputStream bfi = new BufferedInputStream(inputStream);
                        //此处的len表示每次循环读取的内容长度
                        int len;
                        //已经读取的总长度
                        int totle = 0;
                        //bytes是用于存储每次读取出来的内容
                        byte[] bytes = new byte[1024];
                        while ((len = bfi.read(bytes)) != -1) {
                            //每次读取完了都将len累加在totle里
                            totle += len;
                            stringBuilder.append(bytes);
                        }
                        LogUtil.e(stringBuilder.toString());
                        inputStream.close();
                        bfi.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
