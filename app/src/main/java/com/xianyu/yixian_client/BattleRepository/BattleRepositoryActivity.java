package com.xianyu.yixian_client.BattleRepository;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xianyu.yixian_client.Model.Room.Entity.Simple_SkillCard;
import com.xianyu.yixian_client.R;
import com.xianyu.yixian_client.databinding.BattlerepositoryActivityBinding;

import java.util.ArrayList;
import java.util.List;

public class BattleRepositoryActivity extends AppCompatActivity {
    BattlerepositoryActivityBinding binding;
    BattleRepositoryViewModel battleRepositoryViewModel;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = BattlerepositoryActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //初始化
        Init();

    }

    private void Init() {
        ///battleRepositoryViewModel = new BattleRepositoryViewModel();
        List<Simple_SkillCard> cards = new ArrayList();
        cards.add(new Simple_SkillCard("斩杀",6));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        CardAdapt cardAdapt = new CardAdapt(cards);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cardAdapt);
    }

}
