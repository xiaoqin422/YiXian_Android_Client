package com.xianyu.yixian_client.Model.Tcp;

import com.google.gson.Gson;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class CustomEncoder extends MessageToByteEncoder {
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