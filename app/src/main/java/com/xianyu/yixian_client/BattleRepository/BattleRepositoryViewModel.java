package com.xianyu.yixian_client.BattleRepository;

import androidx.lifecycle.ViewModel;

import com.xianyu.yixian_client.Model.Repository.Repository;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityScoped;

public class BattleRepositoryViewModel extends ViewModel {
    public Repository repository;
    @Inject
    public BattleRepositoryViewModel(Repository repository){
        this.repository = repository;
    }

}
