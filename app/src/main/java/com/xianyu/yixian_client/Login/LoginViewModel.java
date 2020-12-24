package com.xianyu.yixian_client.Login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.xianyu.yixian_client.Model.Repository.RepositoryFactory;
import com.xianyu.yixian_client.Model.Room.Entity.User;

import java.util.List;

import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
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
    public MutableLiveData<String> verificationCode = new MutableLiveData<String>();
    public MutableLiveData<String> surePassword = new MutableLiveData<String>();
    @EntryPoint
    @InstallIn(SingletonComponent.class)
    interface ViewModelEntryPoint {
         RepositoryFactory repositoryProvide();
    }
    public void insertUser(User user){
        repositoryFactory.insertUser(user);
    }
    public void deleteUser(User user){
        repositoryFactory.deleteUser(user);
    }
    public void updateUser(User user){
        repositoryFactory.updateUser(user);
    }
    public void clearAllUser(User user){
        repositoryFactory.updateUser(user);
    }
    public Single<List<User>> query_Users(){
       return repositoryFactory.queryUsers();
    }
    public LoginViewModel(RepositoryFactory repositoryFactory){
        this.repositoryFactory = repositoryFactory;
    }
    public void ValidUser(User user){
        repositoryFactory.ValidUser(user);
    };
    public void RegisterUser(User user){
        repositoryFactory.RegisterUser(user);
    }
    public void ChangeUser(User user){
        repositoryFactory.ChangeUser(user,verificationCode.getValue());
    }
}

