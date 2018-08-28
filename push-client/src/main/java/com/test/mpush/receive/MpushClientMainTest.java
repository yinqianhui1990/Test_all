package com.test.mpush.receive;

import com.alibaba.fastjson.JSON;
import com.mpush.api.Client;
import com.mpush.api.ClientListener;
import com.mpush.api.push.AckModel;
import com.mpush.api.push.PushCallback;
import com.mpush.api.push.PushContext;
import com.mpush.client.ClientConfig;
import com.mpush.util.DefaultLogger;
import com.test.mpush.pojo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by ThinkPad on 2017/4/6.
 */
public class MpushClientMainTest {
    static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCghPCWCobG8nTD24juwSVataW7iViRxcTkey/B792VZEhuHjQvA3cAJgx2Lv8GnX8NIoShZtoCg3Cx6ecs+VEPD2fBcg2L4JK7xldGpOJ3ONEAyVsLOttXZtNXvyDZRijiErQALMTorcgi79M5uVX9/jMv2Ggb2XAeZhlLD28fHwIDAQAB";
    static final Logger LOGGER = LoggerFactory.getLogger(MpushClientMainTest.class);
    ClientListener listener=null;
    Client client=null;
    private int result=0;
    public void startMpushClient(String allocServer,String serverHost,String deviceId,String userId){
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        listener = new MpushClientListener(scheduledExecutor);
        String cacheDir = MpushClientMainTest.class.getResource("/").getFile();
        client = ClientConfig
                    .build()
                    .setPublicKey(publicKey)
                   // .setAllotServer(allocServer)
                    .setServerHost(serverHost)
                    .setServerPort(3000)
                    .setDeviceId(deviceId)
                     .setOsName("android")
                    .setOsVersion("6.0")
                    .setClientVersion("2.0")
                    .setUserId(userId)
                    .setSessionStorageDir(cacheDir + userId)
                    .setLogger(new DefaultLogger())
                    .setLogEnabled(true)
                    .setEnableHttpProxy(true)
                    .setClientListener(listener)
                    .create();
            client.start();

    }

    public int sendMessage(Message message) {
        if (client != null && client.isRunning()) {
            PushContext pushContext = PushContext.build(JSON.toJSONString(message));
            pushContext.setAckModel(AckModel.BIZ_ACK);
            pushContext.setTimeout(10000);
            pushContext.setCallback(new PushCallback() {
                @Override
                public void onSuccess() {
                    LOGGER.info("------------------发送成功--------------------");
                     result=0;
                }
                @Override
                public void onTimeout() {
                    LOGGER.info("--------------------发送超时------------------");
                     result=-1;
                }
            });
            client.push(pushContext);
        }
         return result;
    }



    public static void main(String[] args) throws Exception {
        //连接，只需一次
        MpushClientMainTest mpushClient=new MpushClientMainTest();
         //mpushClient.startMpushClient("http://10.2.10.110:9999/","10.2.10.110","datacenter9","test");
       // mpushClient.startMpushClient("http://localhost:9999/","localhost","datacenter9","test");
       // mpushClient.startMpushClient("http://10.2.10.112:9999/","10.2.10.112","datacenter9","test");
         mpushClient.startMpushClient("http://10.2.10.172:9999/","10.2.10.172","datacenter9","LDM-SERVER");
        //mpushClient.startMpushClient("http://192.168.11.37:9999/","192.168.11.37","datacenter9","test");

    }
}
