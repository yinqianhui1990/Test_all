package com.yqh.echo.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by ThinkPad on 2016/11/17.
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().id()+"离开了！");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().id()+"进来了！");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到"+ctx.channel().id()+"信息："+msg);
        if(msg.equals("ping")){
            ctx.fireChannelRead(msg);
        }else {
            ctx.writeAndFlush(msg + System.getProperty("line.separator"));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("--异常捕捉：---"+ cause.getMessage());
    }
}
