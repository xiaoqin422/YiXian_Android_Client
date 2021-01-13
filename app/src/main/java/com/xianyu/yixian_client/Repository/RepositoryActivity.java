package com.xianyu.yixian_client.Repository;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.xianyu.yixian_client.Model.Room.Entity.Buff;
import com.xianyu.yixian_client.Model.Room.Entity.SkillCard;
import com.xianyu.yixian_client.R;
import com.xianyu.yixian_client.databinding.RepositoryActivityBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RepositoryActivity extends AppCompatActivity {
    RepositoryActivityBinding binding;
    @Inject
    RepositoryViewModel repositoryViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repository_activity);
        //初始化
        Init();
    }

    private void Init() {
        List<SkillCard> cards = new ArrayList();
        Buff buff = new Buff();
        SkillCard skillCard = new SkillCard();
        buff.setName("冻结");
        skillCard.getBuffs().add(buff);
        buff = new Buff();
        buff.setName("燃烧");
        skillCard.getBuffs().add(buff);
        skillCard.setName("气仙盾");
        skillCard.setCure(true);
        skillCard.setAttack(true);
        skillCard.setMp(10);
        cards.add(skillCard);
        skillCard = new SkillCard();
        skillCard.setName("气斩");
        skillCard.setMp(10);
        cards.add(skillCard);
        CardAdapt cardAdapt = new CardAdapt(cards);
        RecyclerView recyclerView = findViewById(R.id.card_frame);
        recyclerView.setAdapter(cardAdapt);
    }
}