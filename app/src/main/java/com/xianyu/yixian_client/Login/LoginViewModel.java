package com.xianyu.yixian_client.Login;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.xianyu.yixian_client.Model.Debug.Log.Tag;
import com.xianyu.yixian_client.Model.Repository.RepositoryFactory;
import com.xianyu.yixian_client.Model.Room.Entity.User;

import java.util.List;

import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.EntryPointAccessors;
import dagger.hilt.components.SingletonComponent;
import io.reactivex.Single;


/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Login
 * @ClassName: LoginViewModel
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/19 17:34
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/19 17:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LoginViewModel extends ViewModel {
    public RepositoryFactory repositoryFactory;
    @EntryPoint
    @InstallIn(SingletonComponent.class)
    interface ViewModelEntryPoint {
         RepositoryFactory repositoryProvide();
    }
    public void addUser(User user){
        repositoryFactory.addUser(user);
    }
    public Single<List<User>> query_Users(){
       return repositoryFactory.queryUsers();
    }
    public LoginViewModel(Context context){
        //自定义注入
        ViewModelEntryPoint hiltEntryPoint = EntryPointAccessors.fromApplication(context,ViewModelEntryPoint.class);
        repositoryFactory = hiltEntryPoint.repositoryProvide();
        Log.d(Tag.Information,"生成了一个实体");
    }
}

