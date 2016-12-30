package com.lachesis.pushServer;

import com.alibaba.fastjson.JSON;
import com.lachesis.Utils.Constant;
import com.lachesis.Utils.Message;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ThinkPad on 2016/11/24.
 */
public class  WorkTask implements Runnable{
    Map<String,Map<String,Channel>> mapMap;
    public WorkTask(Map mapMap) {
        this.mapMap = mapMap;
    }
    public void run() {
        this.mapMap=PushSeverHandler.mapGroup;
        Iterator it=mapMap.entrySet().iterator();
        Map<String,Map<String,Channel>> value;
        String key;
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            key=(String)entry.getKey();
            value=(Map)entry.getValue();
            Iterator itChannel=value.entrySet().iterator();
            Channel channel;
            Message response=new Message();
            response.setMsgType(Constant.WORK_MSG);
            response.setToUserName("");
            response.setFromUserName("server");
            response.setBody("这是"+key+"要处理的消息!!!");
            response.setCreateTime(new Date());
            while (itChannel.hasNext()){
                Map.Entry entryChannel = (Map.Entry)itChannel.next();
                channel=(Channel)entryChannel.getValue();

                channel.writeAndFlush(JSON.toJSONString(response)+Constant.LS);
            }
        }

    }
}
