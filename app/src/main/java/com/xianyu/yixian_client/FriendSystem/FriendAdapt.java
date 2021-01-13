package com.xianyu.yixian_client.FriendSystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xianyu.yixian_client.Model.Room.Entity.User;
import com.xianyu.yixian_client.R;

import java.util.ArrayList;
import java.util.List;

public class FriendAdapt extends RecyclerView.Adapter<FriendAdapt.ViewHolder> implements Filterable {
    ArrayList<User> origin_data;
    ArrayList<User> filter_data;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //用来创建ViewHolder实例，再将加载好的布局传入构造函数，最后返回ViewHolder实例
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    public FriendAdapt(ArrayList list){
        origin_data = list;
        filter_data = new ArrayList<>(list);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //用于对RecyclerView的子项进行赋值，会在每个子项滚动到屏幕内的时候执行
        User friend = filter_data.get(position);
        holder.nickname_ui.setText(friend.getNickName());
        holder.level_ui.setText(Integer.toString(friend.getLv()));
    }

    @Override
    public int getItemCount() {
        return filter_data.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                ArrayList<User> friends = new ArrayList<>();
                if(constraint == null || constraint.length() == 0){
                    friends.addAll(origin_data);
                }
                else {
                    for(User item : origin_data){
                        if(item.getNickName().contains(constraint))friends.add(item);
                    }
                }
                results.values = friends;
                results.count = friends.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if(results != null && results.values != null){
                    filter_data = (ArrayList<User>)results.values;
                    notifyDataSetChanged();
                }
            }
        };
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
