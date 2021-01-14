package com.xianyu.yixian_client.FriendSystem;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.xianyu.yixian_client.FriendSystem.Adapt.Friend_Adapt;
import com.xianyu.yixian_client.Model.Room.Entity.User;
import com.xianyu.yixian_client.R;
import com.xianyu.yixian_client.databinding.FriendsActivityBinding;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class Friend_Activity extends AppCompatActivity {
    ArrayList<User> friends;
    FriendsActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding初始化
        binding = FriendsActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }
    void init(){
        Friend_Adapt adapt = new Friend_Adapt(friends);
        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.friends);
        recyclerView.setAdapter(adapt);
        TextInputEditText textInputEditText = findViewById(R.id.search_textInput);
        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapt.bluePrint.setNickName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        CheckBox checkBox = findViewById(R.id.levelSort_check);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> adapt.bluePrint.setLevel(isChecked));
        checkBox = findViewById(R.id.activeSort_check);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> adapt.bluePrint.setActive(isChecked));
        checkBox = findViewById(R.id.reverseSort_check);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> adapt.bluePrint.setReverse(isChecked));
    }
}