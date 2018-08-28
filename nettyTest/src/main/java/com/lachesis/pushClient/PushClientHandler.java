package com.lachesis.pushClient;

import com.alibaba.fastjson.JSON;
import com.lachesis.Utils.ConnectInfo;
import com.lachesis.Utils.Constant;
import com.lachesis.Utils.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThinkPad on 2016/11/24.
 */
public class PushClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        try {
            System.out.println("连接异常，5秒后重新连接...");
            ctx.channel().eventLoop().schedule(new Runnable() {
                public void run() {
                    try {
                        PushClient.connectServer(ConnectInfo.IP,ConnectInfo.PORT);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }, 5, TimeUnit.SECONDS);
            ctx.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("客户端收到："+msg);
        Message message= JSON.parseObject(msg.toString(), Message.class);
        if(Constant.HEART_BEAT_MGS.equals(message.getMsgType())){
            //交给心跳处理的handler
            ctx.fireChannelRead(msg);
        }else {
           //处理收到的工作消息
            System.out.println(new Date()+"正在处理："+msg);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
    }

    @Override
    public void exceptionCaught (ChannelHandlerContext ctx, Throwable cause) {

        try {
            System.out.println(cause.getMessage()+"连接异常，5秒后准备重新连接...");
            //重新连接服务器
            ctx.channel().eventLoop().schedule(new Runnable() {
                public void run() {
                    try {
                       PushClient.connectServer(ConnectInfo.IP,ConnectInfo.PORT);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }, 5, TimeUnit.SECONDS);
            ctx.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
