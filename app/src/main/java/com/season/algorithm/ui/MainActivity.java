package com.season.algorithm.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.season.algorithm.AlgorithmFactory;
import com.season.algorithm.IAlgorithm;
import com.season.algorithm.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_lv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new ItemDecoration());
        recyclerView.setAdapter(new MainAdapter(Bean.buildTestBean()){
            @Override
            protected void onItemCLicked(int position, Bean bean){
                try {
                    IAlgorithm algorithm = AlgorithmFactory.getInstance().getAlgorithm(bean.name);
                    if (algorithm != null){
                        String in = algorithm.prepare();
                        long time = System.currentTimeMillis();
                        algorithm.execute();
                        long cost = System.currentTimeMillis() - time;
                        String out = algorithm.verify();
                        final AlertDialog.Builder normalDialog =
                                new AlertDialog.Builder(MainActivity.this);
                        normalDialog.setTitle(algorithm.getName());
                        normalDialog.setMessage(algorithm.getDesc()
                                +"\n"+ "输入：" + in +""
                                +"\n"+ "输出：" + out +""
                                +"\n"+ "耗时：" + cost +"ms");
                        normalDialog.setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        normalDialog.setNegativeButton("关闭",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        normalDialog.show();

                    }else{
                        Toast.makeText(MainActivity.this, "not support" , Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        recyclerView.scrollToPosition(39);
    }
}
