package com.xianyu.yixian_client.FriendSystem;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.xianyu.yixian_client.Model.Room.Entity.User;
import com.xianyu.yixian_client.R;
import com.xianyu.yixian_client.databinding.FriendsActivityBinding;

import java.util.ArrayList;

public class Friends_Activity extends AppCompatActivity {
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

        User user = new User();
        user.setNickName("雅");
        user.setLv(3);
        friends = new ArrayList<>();
        friends.add(user);
        user = new User();
        user.setNickName("阿清");
        user.setLv(3);
        friends.add(user);
        user = new User();
        user.setNickName("阿红");
        user.setLv(1);
        friends.add(user);
        user = new User();
        user.setNickName("阿明");
        user.setLv(5);
        friends.add(user);
        user = new User();
        user.setNickName("雅2");
        user.setLv(3);
        friends.add(user);
        user = new User();
        user.setNickName("雅3");
        user.setLv(4);
        friends.add(user);
        user = new User();
        user.setNickName("雅4");
        user.setLv(3);
        friends.add(user);
        user = new User();
        user.setNickName("雅5");
        user.setLv(1);
        friends.add(user);
        FriendAdapt adapt = new FriendAdapt(friends);
        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.friends);
        recyclerView.setAdapter(adapt);
        TextInputEditText textInputEditText = findViewById(R.id.search_textInput);
        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapt.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}