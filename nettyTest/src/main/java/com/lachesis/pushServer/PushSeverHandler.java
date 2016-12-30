package com.lachesis.pushServer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lachesis.Utils.Constant;
import com.lachesis.Utils.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ThinkPad on 2016/11/24.
 */
public class PushSeverHandler extends ChannelInboundHandlerAdapter {

    public static volatile ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static volatile Map<String,Map<String,Channel>> mapGroup=new HashMap<String, Map<String, Channel>>();
    private static Lock lock = new ReentrantLock();//Map需要线程同步
    public static ChannelGroup getChannels() {
        return channels;
    }

    public static void setChannels(ChannelGroup channels) {
        PushSeverHandler.channels = channels;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().id()+"离开了！");
        channels.remove(ctx.channel());
        lock.lock();
        Iterator it=mapGroup.entrySet().iterator();
        Map<String,Map<String,Channel>> value;
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            value=(Map)entry.getValue();
            String channelId=ctx.channel().id().toString();
            if(value.containsKey(channelId)){
                value.remove(channelId);
            }
        }
        lock.unlock();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().id()+"进来了！");
        channels.add(ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到"+ctx.channel().id()+"信息："+msg);
        Message message= JSON.parseObject(msg.toString(), Message.class);
        if(Constant.HEART_BEAT_MGS.equals(message.getMsgType())){
            //交给心跳处理的handler
            ctx.fireChannelRead(msg);
        }else if(Constant.AUTH_MSG.equals(message.getMsgType())){
            // 根据科室信息分组
            String deptCode=message.getBody().toString();
            lock.lock();
            if(!mapGroup.containsKey(deptCode)){
                Map<String ,Channel>deptMap=new HashMap<String, Channel>();
                deptMap.put(ctx.channel().id().toString(),ctx.channel());
                mapGroup.put(deptCode,deptMap);
            }else{
                mapGroup.get(deptCode).put(ctx.channel().id().toString(),ctx.channel());
            }
            lock.unlock();
        }else {
            //暂时不做操作
            System.out.println("idle");
        }
        System.out.println("小组总数量:"+mapGroup.size());
        Iterator it=mapGroup.entrySet().iterator();
        String key;
        Map<String,Map<String,Channel>> value;
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            key=entry.getKey().toString();
            value=(Map)entry.getValue();
            System.out.println(key+"===="+value);
            System.out.println(key+"组连接数："+value.size());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("--异常捕捉：---"+ cause.getMessage());
    }
}
