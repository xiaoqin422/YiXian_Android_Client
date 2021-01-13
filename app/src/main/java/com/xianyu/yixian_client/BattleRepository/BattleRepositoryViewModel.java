package com.xianyu.yixian_client.BattleRepository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.xianyu.yixian_client.Login.LoginViewModel;
import com.xianyu.yixian_client.Model.Repository.RepositoryFactory;
import com.xianyu.yixian_client.Repository.RepositoryViewModel;

import javax.inject.Inject;

import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.EntryPointAccessors;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.components.SingletonComponent;
@ActivityScoped
public class BattleRepositoryViewModel extends ViewModel {

    public RepositoryFactory repositoryFactory;
    @Inject
    public BattleRepositoryViewModel(RepositoryFactory repositoryFactory){
        this.repositoryFactory = repositoryFactory;
    }

}
