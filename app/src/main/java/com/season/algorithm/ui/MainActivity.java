package com.season.algorithm.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.season.algorithm.AlgorithmFactory;
import com.season.algorithm.IAlgorithm;
import com.season.algorithm.R;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.BlockChain;
import org.bitcoinj.core.CheckpointManager;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.store.SPVBlockStore;
import org.bitcoinj.wallet.KeyChain;
import org.bitcoinj.wallet.Wallet;
import org.bitcoinj.wallet.WalletFiles;
import org.bitcoinj.wallet.WalletProtobufSerializer;
import org.spongycastle.pqc.math.ntru.polynomial.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NetworkParameters NETWORK_PARAMETERS = NetworkParameters.prodNet();
        File walletFile = getFileStreamPath("wallet-protobuf");
//创建钱包
        Wallet wallet = new Wallet(NETWORK_PARAMETERS);
//创建WalletFiles，设置自动保存Wallet
        WalletFiles walletFiles = wallet.autosaveToFile(walletFile, 3 * 1000, TimeUnit.MILLISECONDS, null);
//立即保存
        try {
            walletFiles.saveNow();

            Address address = wallet.currentAddress(KeyChain.KeyPurpose.RECEIVE_FUNDS);
            address.toString();

Log.e("mmm", address.toString());

            //读取钱包文件
            walletFile = getFileStreamPath("wallet-protobuf");
            if (walletFile.exists()) {
                InputStream inputStream = new FileInputStream(walletFile);
                //反序列化
                wallet  = new WalletProtobufSerializer().readWallet(inputStream);
                //设置自动保存
                wallet.autosaveToFile(walletFile, 3 * 1000, TimeUnit.MILLISECONDS, null);


                Log.e("mmm", wallet.toString());

                //清理钱包
                wallet.cleanup();





                //创建区块链文件
                File blockChainFile = new File(getDir("blockstore", Context.MODE_PRIVATE), "blockchain");
//创建SPVBlockStore，管理区块数据
                SPVBlockStore  blockStore = new SPVBlockStore(NETWORK_PARAMETERS, blockChainFile);
//加载检查点
                final InputStream checkpointsInputStream = getAssets().open("checkpoints-testnet.txt");
                CheckpointManager.checkpoint(NETWORK_PARAMETERS, checkpointsInputStream,
                        blockStore, System.currentTimeMillis() - 24 * 60 * 60 * 1000);

                Log.e("mm", checkpointsInputStream.toString());
//创建区块链对象
                BlockChain blockChain = new BlockChain(NETWORK_PARAMETERS, wallet, blockStore);

                Log.e("mm", blockChain.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


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
        //recyclerView.scrollToPosition(50);
    }
}
