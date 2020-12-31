package com.xianyu.yixian_client.Repository;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.xianyu.yixian_client.Login.LoginViewModel;
import com.xianyu.yixian_client.R;
import com.xianyu.yixian_client.databinding.RepositoryActivityBinding;

import org.w3c.dom.Text;

import dagger.hilt.android.EntryPointAccessors;

import static com.xianyu.yixian_client.databinding.RepositoryActivityBinding.inflate;

public class RepositoryActivity extends AppCompatActivity {
    RepositoryActivityBinding binding;
    RepositoryViewModel repositoryViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RepositoryActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //初始化
        Init();
    }

    private void Init() {
        repositoryViewModel = new RepositoryViewModel();

    }
}