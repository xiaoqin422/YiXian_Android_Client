package com.xianyu.yixian_client.FriendSystem;

import com.xianyu.yixian_client.Model.Repository.Repository;

import javax.inject.Inject;

public class Friend_ViewModel {
    Repository repository;
    @Inject
    Friend_ViewModel(Repository repository){
        this.repository = repository;
    }
}
