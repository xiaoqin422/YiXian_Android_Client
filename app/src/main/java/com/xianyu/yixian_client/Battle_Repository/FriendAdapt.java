package com.xianyu.yixian_client.Battle_Repository;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xianyu.yixian_client.R;

public class FriendAdapt extends RecyclerView.Adapter<FriendAdapt.ViewHolder>  {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //用来创建ViewHolder实例，再将加载好的布局传入构造函数，最后返回ViewHolder实例
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_item,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nickname_ui;
        TextView level_ui;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nickname_ui = itemView.findViewById(R.id.nickname);
            level_ui = itemView.findViewById(R.id.level);
        }
    }
}
