package com.xianyu.yixian_client.PersonalInformation;

import com.xianyu.yixian_client.Model.Room.Entity.User;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model.Repository
 * @ClassName: IPersonalInformation
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/24 3:28
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/24 3:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
interface IPersonalInformation {
    public void ValidUser(User user);
    public void RegisterUser(User user);
    public void ChangeUser(User user,String verificationCode);
}
