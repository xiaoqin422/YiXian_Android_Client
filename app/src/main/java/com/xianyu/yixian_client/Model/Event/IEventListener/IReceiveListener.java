package com.xianyu.yixian_client.Model.Event.IEventListener;

import java.util.EventListener;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model.EventListener
 * @ClassName: IReceiveListener
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/17 18:49
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/17 18:49
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface IReceiveListener extends EventListener {
    public void Receive(MsgServer msg);
}
