package com.xianyu.yixian_client.PersonalInformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.xianyu.yixian_client.Login.Fragment.Bind.DepthPageTransformer;
import com.xianyu.yixian_client.Model.Room.Entity.History;
import com.xianyu.yixian_client.PersonalInformation.Fragment.Bind.PersonalInformation_Fragment_Adapter;
import com.xianyu.yixian_client.PersonalInformation.Fragment.PersonalInformationViewModel;
import com.xianyu.yixian_client.R;
import com.xianyu.yixian_client.databinding.PersonalInformationActivityBinding;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PersonalInformation_Activity extends AppCompatActivity {
    PersonalInformationActivityBinding personalInformationActivityBinding;
    @Inject
    PersonalInformationViewModel viewModel;
    ViewPager2 paper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        personalInformationActivityBinding = PersonalInformationActivityBinding.inflate(getLayoutInflater());
        setContentView(personalInformationActivityBinding.getRoot());
        //fragment绑定初始化
        paper = findViewById(R.id.paper);
        paper.setPageTransformer(new DepthPageTransformer());
        paper.setAdapter(new PersonalInformation_Fragment_Adapter(this,viewModel));
    }

    public void personal_Click(View view) {
        paper.setCurrentItem(1);
    }

    public void history_Click(View view) {
        paper.setCurrentItem(0);
    }

    public void information_Click(View view) {
        paper.setCurrentItem(2);
    }
}