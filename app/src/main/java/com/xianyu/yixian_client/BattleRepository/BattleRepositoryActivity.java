package com.xianyu.yixian_client.BattleRepository;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputEditText;
import com.xianyu.yixian_client.BattleRepository.Adapt.GroupAdapter;
import com.xianyu.yixian_client.BattleRepository.Adapt.SkillCardAdapt;
import com.xianyu.yixian_client.Model.Room.Entity.Buff;
import com.xianyu.yixian_client.Model.Room.Entity.CardGroup;
import com.xianyu.yixian_client.Model.Room.Entity.SkillCard;
import com.xianyu.yixian_client.Model.Room.Entity.User;
import com.xianyu.yixian_client.R;
import com.xianyu.yixian_client.databinding.BattlerepositoryActivityBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BattleRepositoryActivity extends AppCompatActivity {
    BattlerepositoryActivityBinding binding;
    @Inject
    BattleRepositoryViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = BattlerepositoryActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
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
        User user = new User();
        user.setId(1234);
        user.getBattle_Repository().add(new CardGroup(1,user.getId(),"卡组1",cards));
        user.getBattle_Repository().add(new CardGroup(2,user.getId(),"卡组2",cards));

        ExpandableListView expandableListView;
        expandableListView = binding.getRoot().findViewById(R.id.group_layout);
        GroupAdapter groupAdapter = new GroupAdapter(user.getBattle_Repository());
        expandableListView.setAdapter(groupAdapter);

        RecyclerView recyclerView;
        SkillCardAdapt cardAdapt = new SkillCardAdapt(cards);
        recyclerView = binding.getRoot().findViewById(R.id.recycler_view);
        recyclerView.setAdapter(cardAdapt);
        TextInputEditText editText = findViewById(R.id.searchName_textInput);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cardAdapt.bluePrint.setName(s.toString());
                cardAdapt.filter();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Chip physics_chip = findViewById(R.id.physics_chip);
        physics_chip.setOnCheckedChangeListener((buttonView, isChecked) -> {cardAdapt.bluePrint.setPhysics(isChecked);cardAdapt.filter();});
        Chip magic_chip = findViewById(R.id.magic_chip);
        magic_chip.setOnCheckedChangeListener((buttonView, isChecked) -> {cardAdapt.bluePrint.setMagic(isChecked);cardAdapt.filter();});
        Chip cure_chip = findViewById(R.id.cure_chip);
        cure_chip.setOnCheckedChangeListener((buttonView, isChecked) -> {cardAdapt.bluePrint.setCure(isChecked);cardAdapt.filter();});
        Chip attack_chip = findViewById(R.id.attack_chip);
        attack_chip.setOnCheckedChangeListener((buttonView, isChecked) -> {cardAdapt.bluePrint.setAttack(isChecked);cardAdapt.filter();});
        Chip eternal_chip = findViewById(R.id.eternal_chip);
        eternal_chip.setOnCheckedChangeListener((buttonView, isChecked) -> {cardAdapt.bluePrint.setEternal(isChecked);cardAdapt.filter();});
    }
}
