package com.lachesis.pushClient;

import com.alibaba.fastjson.JSON;
import com.lachesis.Utils.Constant;
import com.lachesis.Utils.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThinkPad on 2016/11/24.
 */
public class HeartBeatClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到心跳回应消息:"+msg);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端开启心跳检测");
        ctx.executor().scheduleAtFixedRate(new PingTask(ctx) {
        },1,Constant.HEART_BEAT_RATE, TimeUnit.SECONDS);

    }

    private class PingTask implements  Runnable{
        ChannelHandlerContext ctx;
        public PingTask(ChannelHandlerContext ctx) {
            this.ctx=ctx;
        }
        public void run() {
            System.out.println("客户端准备发送心跳包");
            Message request=new Message();
            request.setToUserName("server");
            request.setMsgType(Constant.HEART_BEAT_MGS);
            request.setFromUserName(ctx.channel().id().toString());
            request.setBody("ping");
            request.setCreateTime(new Date());
            ctx.writeAndFlush(JSON.toJSONString(request)+ Constant.LS);
        }
    }
}
