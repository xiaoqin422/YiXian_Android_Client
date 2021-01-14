package com.xianyu.yixian_client.Main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.google.android.material.textfield.TextInputEditText;
import com.xianyu.yixian_client.Core;
import com.xianyu.yixian_client.Login.LoginService;
import com.xianyu.yixian_client.Model.Room.Entity.User;
import com.xianyu.yixian_client.R;
import com.xianyu.yixian_client.databinding.MainActivityBinding;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    MainActivityBinding binding;
    @Inject
    MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //视窗绑定
        binding = MainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init() {
        Intent intentOne = new Intent(this, LoginService.class);
        startService(intentOne);
        //视频初始化
        VideoView videoView = findViewById(R.id.videoView_main);
        videoView.setVideoPath(Uri.parse("android.resource://" + getPackageName() + "/raw/" + R.raw.cg_bg).toString());//路径
        videoView.setOnPreparedListener(mp -> mp.setLooping(true));//循环
        videoView.start();//开始

        //置透明
        View v = findViewById(R.id.GameType_button1);//找到你要设透明背景的layout 的id
        View v1 = findViewById(R.id.GameType_button2);//找到你要设透明背景的layout 的id
        View v2 = findViewById(R.id.button_enjoy);//找到你要设透明背景的layout 的id
        View v3 = findViewById(R.id.button_official);//找到你要设透明背景的layout 的id
        View v4 = findViewById(R.id.button_Shopping);//找到你要设透明背景的layout 的id
        View v5 = findViewById(R.id.button_notice);//找到你要设透明背景的layout 的id
        v.getBackground().setAlpha(10);//0~255透明度值
        v1.getBackground().setAlpha(250);//0~255透明度值
        v2.getBackground().setAlpha(20);//0~255透明度值
        v3.getBackground().setAlpha(20);//0~255透明度值
        v4.getBackground().setAlpha(20);//0~255透明度值
        v5.getBackground().setAlpha(20);//0~255透明度值
        TextView text1 = binding.getRoot().findViewById(R.id.textView_experience);
        TextView text2 = binding.getRoot().findViewById(R.id.textView_username);

        viewModel.repository.queryUserById(123456)
                .subscribeOn(Schedulers.io())//查询数据时的线程
                .observeOn(AndroidSchedulers.mainThread())//数据查找完毕的线程
                .subscribe(users -> {
                    if(users.size()>0){
                        Core.liveUser.setValue(users.get(0));
                        text1.setText(Integer.toString(Core.liveUser.getValue().getExp()));
                    }
                });

    }
}
