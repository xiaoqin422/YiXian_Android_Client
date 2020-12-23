package com.xianyu.yixian_client.Model.Event.ReceiveEvent;

import com.xianyu.yixian_client.Model.Event.IEventListener.IReceiveListener;
import com.xianyu.yixian_client.Model.Tcp.MsgServer;

import java.util.EventObject;
import java.util.Iterator;
import java.util.Vector;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model.Event
 * @ClassName: java
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/17 19:01
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/17 19:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ReceiveEvent {
    private Vector list=new Vector();


    public void add(IReceiveListener me)
    {
        list.add(me);
    }
    public void delete(IReceiveListener me)
    {
        list.remove(me);
    }
    public void notify(MsgServer me)
    {
        Iterator it=list.iterator();
        while(it.hasNext())
        {
            //在类中实例化自定义的监听器对象,并调用监听器方法
            ((IReceiveListener) it.next()).Receive(me);
        }
    }
}
