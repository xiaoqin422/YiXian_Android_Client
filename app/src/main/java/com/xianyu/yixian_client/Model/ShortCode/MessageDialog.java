package com.xianyu.yixian_client.Model.ShortCode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.xianyu.yixian_client.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model.ShortCode
 * @ClassName: MessageDialog
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/24 14:46
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/24 14:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MessageDialog {
    @SuppressLint("CheckResult")
    public static void Dialog(Context parent, String title, String content){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext(title);
            }
        }).subscribeOn(AndroidSchedulers.mainThread())
          .subscribe(new Consumer<String>() {
              @Override
              public void accept(String s) throws Exception {
                  new MaterialAlertDialogBuilder(parent)
                          .setTitle(title)
                          .setMessage(content)
                          .setNeutralButton(R.string.confirm_dialog, new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialog, int which) {
                                  dialog.dismiss();
                              }
                          })
                          .show();
              }
          });
    }
    @SuppressLint("CheckResult")
    public static void Error_Dialog(Context parent, String title, String content){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext(title);
            }
        }).subscribeOn(AndroidSchedulers.mainThread())
          .subscribe(new Consumer<String>() {
              @Override
              public void accept(String s) throws Exception {
                  new MaterialAlertDialogBuilder(parent)
                          .setTitle(title)
                          .setMessage(content)
                          .setNegativeButton(R.string.confirm_dialog, new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialog, int which) {
                                  dialog.dismiss();
                              }
                          })
                          .show();
              }
          });
    }
    @SuppressLint("CheckResult")
    public static void Confirm_Dialog(Context parent, String title, String content){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext(title);
            }
        }).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        new MaterialAlertDialogBuilder(parent)
                                .setTitle(title)
                                .setMessage(content)
                                .setPositiveButton(R.string.confirm_dialog, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }
                });
    }
}
