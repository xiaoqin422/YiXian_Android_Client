package com.xianyu.yixian_client.PersonalInformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xianyu.yixian_client.R;

public class personalInformation_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_information_activity_);

        Button  btn1 = (Button) findViewById(R.id.next);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Intent是一种运行时绑定（run-time binding）机制，它能在程序运行过程中连接两个不同的组件。
                //在存放资源代码的文件夹下下，
                Intent i = new Intent(personalInformation_Activity.this , History_Activity.class);
                //启动
                startActivity(i);
            }
        });
    }

    public void onClickNext(View view) {
    }

}