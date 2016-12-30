package com.lachesis.pushServer;

import com.alibaba.fastjson.JSON;
import com.lachesis.Utils.Constant;
import com.lachesis.Utils.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * Created by ThinkPad on 2016/11/24.
 */
public class HeatBeatServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("receive beat heat :"+msg);
        Message message= JSON.parseObject(msg.toString(), Message.class);
        if(Constant.HEART_BEAT_MGS.equals(message.getMsgType())){
            //对客户端进行心跳回应
            Message response=new Message();
            response.setMsgType(Constant.HEART_BEAT_MGS);
            response.setToUserName(ctx.channel().id().toString());
            response.setFromUserName("server");
            response.setBody("pong");
            response.setCreateTime(new Date());
            ctx.writeAndFlush(JSON.toJSONString(response)+Constant.LS);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
