package com.xianyu.yixian_client.Model.Tcp;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model
 * @ClassName: MsgToken
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/16 21:40
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/16 21:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MsgToken {

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String password) {
        this.passwords = password;
    }

    String account;
    String passwords;

    public MsgToken(String account, String passwords) {
        this.account = account;
        this.passwords = passwords;
    }
}
