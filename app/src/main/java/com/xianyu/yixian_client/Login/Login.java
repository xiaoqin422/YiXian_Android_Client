package com.xianyu.yixian_client.Login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.xianyu.yixian_client.Login.Fragment.Bind.DepthPageTransformer;
import com.xianyu.yixian_client.Login.Fragment.Bind.Login_Fragment_Adapter;
import com.xianyu.yixian_client.Model.Core;
import com.xianyu.yixian_client.Model.Debug.Log.Tag;
import com.xianyu.yixian_client.Model.Room.Entity.User;
import com.xianyu.yixian_client.R;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@AndroidEntryPoint
public class Login extends AppCompatActivity {
    private ViewPager2 paper;
    private TabLayout tab;
    LoginViewModel viewModel ;
    private final CompositeDisposable disposable = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化
        Init();
    }
    private void Init(){
        //注册消息事件
        Core.information_ReceiveEvent.add(new Login_XY(this));
        //Service初始化
        Intent intentOne = new Intent(this, LoginService.class);
        startService(intentOne);
        //视频初始化
        VideoView videoView = findViewById(R.id.back_ground);
        videoView.setVideoPath(Uri.parse("android.resource://" + getPackageName() + "/raw/" + R.raw.cg_bg).toString());
        videoView.setOnPreparedListener(mp -> mp.setLooping(true));
        videoView.start();
        //跳出主线程
        Disposable temp = Observable.create(new ObservableOnSubscribe<LoginViewModel>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<LoginViewModel> emitter) {
                emitter.onNext(new LoginViewModel(getApplicationContext()));
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(loginViewModel -> {
            Log.d(Tag.Information,"监察者开始调用");
            viewModel = loginViewModel;
            //fragment绑定初始化
            paper = findViewById(R.id.paper);
            paper.setPageTransformer(new DepthPageTransformer());
            paper.setAdapter(new Login_Fragment_Adapter(this,viewModel));
            tab = findViewById(R.id.tabLayout);
            tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                    switch (tab.getPosition()){
                        case 0:Register_Click(); break;
                        case 1:Login_Click(); break;
                        case 2:Forget_Click(); break;
                        default:break;
                    }
                }
            });
            new TabLayoutMediator(
                    tab,
                    paper,
                    (tab, position) -> {
                        switch (position){
                            case 0 : tab.setText(R.string.register);break;
                            case 1 : tab.setText(R.string.login);break;
                            case 2 : tab.setText(R.string.pw_forget);break;
                            default: break;
                        }
                    }
            ).attach();
            paper.setOffscreenPageLimit(3);
            tab.selectTab(tab.getTabAt(1));
            disposable.add(viewModel.query_Users()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(users -> {
                        if(users.isEmpty()){
                            User user = new User();
                            user.setUserName("落花无痕浅流淌");
                            Core.liveUser.setValue(user);
                            viewModel.addUser(Core.liveUser.getValue());
                            Log.i(Tag.Room, "创建新用户\n"+Core.liveUser.toString());
                        }
                        else {
                            Core.liveUser.setValue(users.get(0));
                            Log.i(Tag.Room,"查询成功\n"+Core.liveUser.toString());
                        }
                    }, throwable -> {
                        Log.e(Tag.Room, "获取异常");
                    })
            );
        });
    }
    @Override
    public void onBackPressed() {
        if (paper.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            paper.setCurrentItem(paper.getCurrentItem() - 1);
        }
    }

    public void Login_Click() {
        viewModel.repositoryFactory.ValidUser(Core.liveUser.getValue());
    }

    public void Register_Click() {

    }
    public void Forget_Click() {

    }
}