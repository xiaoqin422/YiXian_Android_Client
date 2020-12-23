package com.xianyu.yixian_client.Model.Tcp;

import com.xianyu.yixian_client.Model.Enums;

/**
 * @ProjectName: YiXian
 * @Package: com.xianyu.yixian.Model
 * @ClassName: Msg_Server
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/11/23 19:42
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/11/23 19:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MsgServer{
    public String Head;
    public Enums.Msg_Server_Type Type;
    public String Bound;
    public String Source;
    public MsgServer(Enums.Msg_Server_Type type, String head)
    {
        this.Type = type;
        this.Head = head;
        this.Bound = null;
    }
    public MsgServer(Enums.Msg_Server_Type type, String head, String bound)
    {
        this.Type = type;
        this.Head = head;
        this.Bound = bound;
    }
    @Override
    public String toString() {
        return "类型:" + Type + "\n指令" + Head + "\n数据:" + Bound;
    }
}
