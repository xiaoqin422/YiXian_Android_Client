package com.xianyu.yixian_client.Repository;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        if(skillCard.isAttack()){
            stringBuilder.append("攻击 ");
        }
        else if(skillCard.isCure()){
            stringBuilder.append("治疗 ");
        }
        else if(skillCard.isEternal()){
            stringBuilder.append("永恒 ");
        }
        else if(skillCard.isMagic()){
            stringBuilder.append("魔法 ");
        }
        else if(skillCard.isPhysics()){
            stringBuilder.append("物理 ");
        }
        holder.attributes_text.setText(stringBuilder.toString());
        holder.name_text.setText(skillCard.getName());
        holder.enemyHp_text.setText(Integer.toString(skillCard.getEnemy_hp()));
    }

    @Override
    public int getItemCount() {
            return skillCards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        MaterialTextView buffs_text;
        MaterialTextView attributes_text;
        MaterialTextView enemyHp_text;
        MaterialTextView name_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            buffs_text = itemView.findViewById(R.id.buffs_text);
            attributes_text = itemView.findViewById(R.id.attributes_text);
            enemyHp_text = itemView.findViewById(R.id.enemyHp_text);
            name_text = itemView.findViewById(R.id.name);
        }
    }
}
