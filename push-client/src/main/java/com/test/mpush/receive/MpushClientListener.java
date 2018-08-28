package com.test.mpush.receive;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.mpush.api.Client;
import com.mpush.api.ClientListener;
import com.test.mpush.pojo.Constant;
import com.test.mpush.pojo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThinkPad on 2017/4/6.
 */
public class MpushClientListener implements ClientListener{
    static final Logger LOGGER = LoggerFactory.getLogger(MpushClientListener.class);
    private final ScheduledExecutorService scheduledExecutor;
    boolean flag = true;
    static int counts=0;
    public MpushClientListener(ScheduledExecutorService scheduledExecutor) {
        this.scheduledExecutor = scheduledExecutor;
    }

    @Override
    public void onConnected(Client client) {
        flag = true;
        LOGGER.info("----------连接...---------");
    }

    @Override
    public void onDisConnected(Client client) {
        flag = false;
        LOGGER.info("----------离线...---------");
    }

    @Override
    public void onHandshakeOk(final Client client, final int heartbeat) {
        scheduledExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                client.healthCheck();
            }
        }, 10, 10, TimeUnit.SECONDS);
        LOGGER.info("----------开始心跳检测---------");
    }

    @Override
    public void onReceivePush(Client client, byte[] content, int messageId) {
//        LOGGER.info("messageId："+messageId);
        if (messageId > 0) {
            client.ack(messageId);
        }
        try {
            LOGGER.info("收到消息：" + new String(content, "utf-8"));
            //收到消息时业务处理
            Message message= JSON.parseObject(content,Message.class, Feature.AutoCloseSource);
            message= JSON.parseObject(message.getContent().toString(),Message.class);
            if(Constant.MSG_TYPE_WORK.equals(message.getMsgType())){
                counts++;
                LOGGER.info("收到消息数量>>>>>>>>>>>>>>>>>>:" + counts);
            }

        }catch (Exception e){
            e.printStackTrace();
           // LOGGER.error("接收消息时异常："+e.getMessage());
        }
    }
    @Override
    public void onKickUser(String deviceId, String userId) {
        LOGGER.info(userId+"被踢下线");
    }

}
