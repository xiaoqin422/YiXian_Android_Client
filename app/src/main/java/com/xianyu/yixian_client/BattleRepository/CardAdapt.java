package com.xianyu.yixian_client.BattleRepository;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.xianyu.yixian_client.Model.Room.Entity.SkillCard;
import com.xianyu.yixian_client.R;


import java.util.ArrayList;
import java.util.List;

public class CardAdapt extends RecyclerView.Adapter<CardAdapt.ViewHolder>{
    private List<SkillCard> simple_skillCards;
    public ArrayList<String> data =new ArrayList<String>();
    public CardAdapt(List<SkillCard> simple_skillCards){
        this.simple_skillCards = simple_skillCards;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //用来创建ViewHolder实例，再将加载好的布局传入构造函数，最后返回ViewHolder实例
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.battlerepositorycard_item,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //用于对RecyclerView的子项进行赋值，会在每个子项滚动到屏幕内的时候执行
        SkillCard skillCard = simple_skillCards.get(position);

    }

    @Override
    public int getItemCount() {
        return simple_skillCards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        MaterialTextView name_text;
        MaterialTextView mp_text;
        MaterialTextView physics_text;
        MaterialTextView magic_text;
        MaterialTextView cure_text;
        MaterialTextView attack_text;
        MaterialTextView eternal_text;
        MaterialTextView enemyMp_text;
        MaterialTextView auxiliaryHp_text;
        MaterialTextView auxiliaryMp_text;
        MaterialTextView probability_text;
        MaterialTextView maxEnemy_text;
        MaterialTextView maxAuxiliary_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
