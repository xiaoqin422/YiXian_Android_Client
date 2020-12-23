package com.xianyu.yixian_client.Model.Tcp;

import android.util.Log;

import com.google.gson.Gson;
import com.xianyu.yixian_client.Model.Core;
import com.xianyu.yixian_client.Model.Debug.Log.Tag;
import com.xianyu.yixian_client.Model.Enums;
import com.xianyu.yixian_client.Model.Repository.RemoteRepository;

import java.nio.ByteOrder;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @ProjectName: YiXian
 * @Package: com.xianyu.yixian.Model
 * @ClassName: EchoClient
 * @Description: TCP客户端
 * @Author: Jianxian
 * @CreateDate: 2020/11/16 20:17
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/11/16 20:17
 * @UpdateRemark: 类的第一次生成
 * @Version: 1.0
 */
public class EchoClient  {
    private final String host;
    private final int port;
    public static ChannelFuture channelFuture;
    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public void start(RemoteRepository remoteRepository) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();                //1
            b.group(group)                                //2
                    .channel(NioSocketChannel.class)            //3
                    .handler(new ChannelInitializer<SocketChannel>() {    //5
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(ByteOrder.LITTLE_ENDIAN,65535,0,4,0,4,false));
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new EchoClientHandler());
                            ch.pipeline().addLast(new CustomEncoder());
                        }
                    });
            channelFuture = b.connect(host,port).sync();        //6
            remoteRepository.NetInit(channelFuture);
            channelFuture.channel().closeFuture().sync();            //7
        } finally {
            group.shutdownGracefully().sync();            //8
        }
    }
}
/**
 * @ProjectName: YiXian
 * @Package: com.xianyu.yixian.Model
 * @ClassName: EchoClientHandler
 * @Description: 异步消息的处理
 * @Author: Jianxian
 * @CreateDate: 2020/11/16 20:16
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/11/16 20:16
 * @UpdateRemark: 类第一次生成
 * @Version: 1.0
 */
@ChannelHandler.Sharable                                //1
class EchoClientHandler extends SimpleChannelInboundHandler<String>  {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("连接成功！");
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {                    //4
        cause.printStackTrace();
        ctx.close();
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Gson gson = new Gson();
        MsgServer msg_server =  gson.fromJson(msg, MsgServer.class);
        Log.i(Tag.TCP_Packet,msg_server.toString());
        if(msg_server.Type == Enums.Msg_Server_Type.Information){
           Core.information_ReceiveEvent.notify(msg_server);
        }
        else if(msg_server.Type == Enums.Msg_Server_Type.Game){
           Core.gameReceive_Event.notify(msg_server);
        }
    }
}
class CustomEncoder extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        Gson gson = new Gson();
        byte[] body = (gson.toJson(msg)).getBytes("UTF-8");
        int dataLength = body.length;  //读取消息的长度
        byte[] b = new byte[4];
        b[0] = (byte) (dataLength & 0xff);
        b[1] = (byte) (dataLength >> 8 & 0xff);
        b[2] = (byte) (dataLength >> 16 & 0xff);
        b[3] = (byte) (dataLength >> 24 & 0xff);
        out.writeBytes(b);
        out.writeBytes(body);  //消息体中包含我们要发送的数据
    }
}