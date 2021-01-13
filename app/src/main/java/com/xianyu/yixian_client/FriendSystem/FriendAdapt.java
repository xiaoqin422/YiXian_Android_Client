package com.xianyu.yixian_client.FriendSystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xianyu.yixian_client.Model.Room.Entity.User;
import com.xianyu.yixian_client.R;

import java.util.ArrayList;

public class FriendAdapt extends RecyclerView.Adapter<FriendAdapt.ViewHolder>  {
    ArrayList<User> friends = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //用来创建ViewHolder实例，再将加载好的布局传入构造函数，最后返回ViewHolder实例
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_item,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    public FriendAdapt(ArrayList list){
        friends = list;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //用于对RecyclerView的子项进行赋值，会在每个子项滚动到屏幕内的时候执行
        User friend = friends.get(position);
        holder.nickname_ui.setText(friend.getNickName());
        holder.level_ui.setText(Integer.toString(friend.getLv()));
    }

    @Override
    public int getItemCount() {
        return friends.size();
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
