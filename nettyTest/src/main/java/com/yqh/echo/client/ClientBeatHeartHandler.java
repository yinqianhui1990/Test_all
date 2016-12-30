package com.yqh.echo.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * Created by ThinkPad on 2016/11/23.
 */
public class ClientBeatHeartHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("beat heat response:"+msg);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("active-ClientBeatHeartHandler 开启心跳检测");
        ctx.executor().scheduleAtFixedRate(new PingTask(ctx) {
        },1,5, TimeUnit.SECONDS);

    }

    private class PingTask implements  Runnable{
        ChannelHandlerContext ctx;
        public PingTask(ChannelHandlerContext ctx) {
            this.ctx=ctx;
        }
        public void run() {
            System.out.println("发送心跳包");
                ctx.writeAndFlush("ping"+System.getProperty("line.separator"));
        }
    }
}
