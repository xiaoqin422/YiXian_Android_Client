package com.xianyu.yixian_client.Model.Repository;

import android.util.Log;

import com.google.gson.Gson;
import com.xianyu.yixian_client.Model.Debug.Log.Tag;
import com.xianyu.yixian_client.Model.Enums;
import com.xianyu.yixian_client.Model.Room.Entity.User;
import com.xianyu.yixian_client.Model.Tcp.EchoClient;
import com.xianyu.yixian_client.Model.Tcp.MsgClient;
import com.xianyu.yixian_client.Model.Tcp.MsgToken;

import io.netty.channel.ChannelFuture;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model.RemoteRepository
 * @ClassName: RemoteRepository
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/20 15:31
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/20 15:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class RemoteRepository implements IRemoteRepository{
    private MsgToken token;
    private ChannelFuture channelFuture;
    public RemoteRepository(){
        Thread thread = new Thread(() -> {
            EchoClient echoClient = new EchoClient("192.168.43.238",28015);
            try {
                echoClient.start(this);
            } catch (Exception e) {
                Log.e(Tag.RemoteRepository,"TCP连接启动失败");
                e.printStackTrace();
            }
        });
        thread.start();
    }
    public void NetInit(ChannelFuture channelFuture){
        this.channelFuture = channelFuture;
    }

    private void SendMessage(String msg){
        channelFuture.channel().writeAndFlush(new MsgClient(token, Enums.Msg_Client_Type.Information,msg));
    }

    private void SendMessage(String msg,Object bound){
        channelFuture.channel().writeAndFlush(new MsgClient(token, Enums.Msg_Client_Type.Information,msg, new Gson().toJson(bound)));
    }
    @Override
    public void ValidUser(User user) {
        SendMessage("用户登录",user);
    }

    @Override
    public void RegisterUser(User user) {
        SendMessage("用户注册",user);
    }

    @Override
    public void ChangeUser(User user, String verificationCode) {
        SendMessage("修改密码#" + verificationCode,user);
    }

}
