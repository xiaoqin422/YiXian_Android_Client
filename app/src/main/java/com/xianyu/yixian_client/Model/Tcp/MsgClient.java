package com.xianyu.yixian_client.Model.Tcp;

import com.xianyu.yixian_client.Model.Enums;

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
public class MsgClient {
    public String Head;
    public Enums.Msg_Client_Type Type;
    public String Bound;
    public MsgToken Token;
    public MsgClient(MsgToken token, Enums.Msg_Client_Type type, String head)
    {
        this.Token = token;
        this.Type = type;
        this.Head = head;
        this.Bound = null;
    }
    public MsgClient(MsgToken token, Enums.Msg_Client_Type type, String head, String bound)
    {
        this.Token = token;
        this.Type = type;
        this.Head = head;
        this.Bound = bound;
    }

    @Override
    public String toString() {
        return "类型:" + Type + "\n指令" + Head + "\n数据:" + Bound;
    }
}

