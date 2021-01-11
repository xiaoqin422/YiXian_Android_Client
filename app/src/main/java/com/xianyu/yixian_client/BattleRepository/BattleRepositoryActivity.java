package com.xianyu.yixian_client.BattleRepository;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.xianyu.yixian_client.Model.Repository.RepositoryFactory;
import com.xianyu.yixian_client.R;

public class BattleRepositoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle_repository);
        //初始化
        Init();

    }

    private void Init() {
//        //Service 初始化
//        Intent intentOne = new Intent(packageContext:this,RepositoryService.class);
//        startService(intentOne);
    }

}