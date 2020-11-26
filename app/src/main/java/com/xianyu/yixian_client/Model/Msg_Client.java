package com.xianyu.yixian_client.Model;

/**
 * @ProjectName: YiXian
 * @Package: com.xianyu.yixian.Model
 * @ClassName: Msg_Client
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/11/23 19:30
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/11/23 19:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Msg_Client {
    public String Head;
    public Enums.Msg_Client_Type Type;
    public String Bound;
    public Msg_Client(Enums.Msg_Client_Type type, String head)
    {
        this.Type = type;
        this.Head = head;
        this.Bound = null;
    }
    public Msg_Client(Enums.Msg_Client_Type type, String head, String bound)
    {
        this.Type = type;
        this.Head = head;
        this.Bound = bound;
    }
}

