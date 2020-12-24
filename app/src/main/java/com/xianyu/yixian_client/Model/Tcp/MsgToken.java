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

    String username_token;
    String password_token;


    public MsgToken(String username_token, String password_token) {
        this.username_token = username_token;
        this.password_token = password_token;
    }

    public String getUsername_token() {
        return username_token;
    }

    public void setUsername_token(String username_token) {
        this.username_token = username_token;
    }

    public String getPassword_token() {
        return password_token;
    }

    public void setPassword_token(String password_token) {
        this.password_token = password_token;
    }
}
