package com.yqh.echo.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThinkPad on 2016/11/17.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    private  EchoClient client;

    public ClientHandler(EchoClient client) {
        this.client = client;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("麻蛋，掉线了！");
        try {
            System.out.println("连接异常，准备重新连接...");
            ctx.channel().eventLoop().schedule(new Runnable() {
                public void run() {
                    try {
                        client.connectServer(client.getIpAddress(), client.getPort(), client);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }, 2, TimeUnit.SECONDS);
            ctx.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("客户端收到："+msg);
        if(msg.equals("pong")) {
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("激活");
        ctx.fireChannelActive();
    }

    @Override
    public void exceptionCaught (ChannelHandlerContext ctx, Throwable cause) {

        try {
            System.out.println(cause.getMessage()+"连接异常，准备重新连接...");
            //重新连接服务器
            ctx.channel().eventLoop().schedule(new Runnable() {
                public void run() {
                    try {
                        client.connectServer(client.getIpAddress(), client.getPort(), client);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }, 2, TimeUnit.SECONDS);
            ctx.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
