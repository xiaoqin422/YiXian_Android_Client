package com.xianyu.yixian_client.Repository;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.VideoView;

import com.xianyu.yixian_client.Login.LoginService;
import com.xianyu.yixian_client.Login.LoginViewModel;
import com.xianyu.yixian_client.Model.Core;
import com.xianyu.yixian_client.Model.Log.Log.Tag;
import com.xianyu.yixian_client.Model.Room.Entity.Simple_SkillCard;
import com.xianyu.yixian_client.Model.Room.Entity.User;
import com.xianyu.yixian_client.R;
import com.xianyu.yixian_client.databinding.RepositoryActivityBinding;

import dagger.hilt.android.EntryPointAccessors;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.xianyu.yixian_client.databinding.RepositoryActivityBinding.inflate;

public class RepositoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化
        Init();
    }

    private void Init() {

    }
}