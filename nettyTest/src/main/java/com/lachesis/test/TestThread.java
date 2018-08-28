package com.lachesis.test;

import com.lachesis.Utils.ConnectInfo;
import com.lachesis.pushClient.PushClient;

/**
 * Created by ThinkPad on 2017/3/7.
 */
public class TestThread implements Runnable{
    public void run() {
        try {
            PushClient.connectServer(ConnectInfo.IP, ConnectInfo.PORT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<300;i++){
            Thread t=new Thread(new TestThread());
            t.start();
        }
    }
}
