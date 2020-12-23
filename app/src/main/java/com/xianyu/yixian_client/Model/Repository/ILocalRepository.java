package com.xianyu.yixian_client.Model.Repository;

import com.xianyu.yixian_client.Model.Room.Entity.User;

import java.util.List;

import io.reactivex.Single;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model.Repository
 * @ClassName: ILocalRepository
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/24 3:28
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/24 3:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
interface ILocalRepository {
    public void addUser(User arg);

    public Single<List<User>> queryUsers();

}
