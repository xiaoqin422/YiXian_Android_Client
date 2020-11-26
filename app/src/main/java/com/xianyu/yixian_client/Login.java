package com.xianyu.yixian_client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.xianyu.yixian_client.Model.EchoClient;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EchoClient echoClient = new EchoClient("127.0.0.1",28015);
        try {
            echoClient.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}