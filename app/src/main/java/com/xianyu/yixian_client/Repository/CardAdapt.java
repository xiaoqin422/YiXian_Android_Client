package com.xianyu.yixian_client.Repository;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.xianyu.yixian_client.Model.Room.Entity.Buff;
import com.xianyu.yixian_client.Model.Room.Entity.SkillCard;
import com.xianyu.yixian_client.R;

import java.util.List;

public class CardAdapt extends RecyclerView.Adapter<CardAdapt.ViewHolder> {
    private List<SkillCard> skillCards;
    public  CardAdapt(List<SkillCard> skillCards){
        this.skillCards = skillCards;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //用来创建ViewHolder实例，再将加载好的布局传入构造函数，最后返回ViewHolder实例
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.repositorycard_item,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillCard skillCard = skillCards.get(position);
        holder.buffs_text.setText("");
        StringBuilder stringBuilder = new StringBuilder();

        for(Buff item : skillCard.getBuffs()){
            stringBuilder.append(item.getName() + " ");
        }
        holder.buffs_text.setText(stringBuilder.toString());
        stringBuilder.setLength(0);
        MaterialTextView materialTextView;

        if(skillCard.isAttack()){
            materialTextView = new MaterialTextView(holder.attributes_layout.getContext());
            materialTextView.setText("攻击");
            materialTextView.setTextColor(0xFFE91E63);
            materialTextView.setPadding(0,0,15,0);
            holder.attributes_layout.addView(materialTextView);
        }
        if(skillCard.isCure()){
            materialTextView = new MaterialTextView(holder.attributes_layout.getContext());
            materialTextView.setText("治疗");
            materialTextView.setTextColor(0xFF4CAF50);
            holder.attributes_layout.addView(materialTextView);
        }
        holder.name_text.setText(skillCard.getName());
        holder.enemyHp_text.setText(Integer.toString(skillCard.getEnemy_hp()));
    }

    @Override
    public int getItemCount() {
            return skillCards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        MaterialTextView buffs_text;
        LinearLayout attributes_layout;
        MaterialTextView enemyHp_text;
        MaterialTextView name_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            buffs_text = itemView.findViewById(R.id.buffs_text);
            attributes_layout = itemView.findViewById(R.id.attributes_layout);
            enemyHp_text = itemView.findViewById(R.id.enemyHp_text);
            name_text = itemView.findViewById(R.id.name_text);
        }
    }
}
