package com.xianyu.yixian_client.Login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.xianyu.yixian_client.Model.Core;
import com.xianyu.yixian_client.Model.Event.IEventListener.IReceiveListener;
import com.xianyu.yixian_client.Model.Room.Entity.User;
import com.xianyu.yixian_client.Model.Tcp.MsgServer;
import com.xianyu.yixian_client.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Login
 * @ClassName: Login_XY
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/19 12:08
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/19 12:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Login_XY implements IReceiveListener{
     private Activity activity;
     public Login_XY(Activity activity){
         this.activity = activity;
     }
     @SuppressLint("CheckResult")
     @Override
     public void Receive(MsgServer msg) {
        String[] data = msg.Head.split("#");
        System.out.println(msg.toString());
        if(data.length == 2 && data[0].equals("用户登录")){
            if(data[1].equals("登录成功")){
                Gson gson = new Gson().newBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
                User user = gson.fromJson(msg.Bound,User.class);
                user.setMsgToken(Core.liveUser.getValue().getMsgToken());
                Observable.create(new ObservableOnSubscribe<User>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<User> emitter) throws Exception {
                        emitter.onNext(user);
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(arg -> {
                            Core.liveUser.setValue(user);
                            new MaterialAlertDialogBuilder(activity)
                                    .setTitle("登录成功")
                                    .setMessage("尊敬的" + user.getNickName() +" 您的账户是：" + user.getUserName())
                                    .setNeutralButton(R.string.confirm, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                            new MaterialAlertDialogBuilder(activity)
                                    .setTitle("登录成功")
                                    .setMessage(user.toString())
                                    .setNeutralButton(R.string.confirm, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        });

            }
            else if(data[1].equals("用户不存在")){
                new MaterialAlertDialogBuilder(activity)
                        .setTitle("登录失败")
                        .setMessage("用户不存在")
                        .setNeutralButton(R.string.confirm, (dialog, which) -> dialog.dismiss())
                        .show();
            }
        }
        else if(data.length == 2 && data[0].equals("注册用户")){
            if(data[1].equals("注册用户")){
                Gson gson = new Gson();
                User user = gson.fromJson(msg.Bound,User.class);
                new MaterialAlertDialogBuilder(activity)
                        .setTitle("注册成功")
                        .setMessage("您已成功注册账户:"+user)
                        .setNeutralButton(R.string.confirm, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
            else if(data[1].equals("用户已存在")){
                new MaterialAlertDialogBuilder(activity)
                        .setTitle("注册失败")
                        .setMessage("用户已存在")
                        .setNeutralButton(R.string.confirm, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        }
    }
    @SuppressLint("CheckResult")
    public <T> void RxNoneOne(Consumer<T> functions, T arg){
        Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<T> emitter) throws Exception {
                emitter.onNext(arg);
                emitter.onComplete();
            }
        }).observeOn(Schedulers.io())
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T arg) throws Exception {
                        functions.accept(arg);
                    }
                });
    }
}
