package com.test.socket;

import java.io.BufferedReader;

/**
 * Created by ThinkPad on 2017/8/10.
 */
public class ReadThread implements Runnable{
    BufferedReader in;

    public ReadThread(BufferedReader in) {
        this.in = in;
    }

    public void run() {
        while (true){
            try{
            System.out.println("收到消息:"+in.readLine());
            //在标准输出上打印从客户端读入的字符串
                }catch (Exception e){
                System.out.println("error:"+e);
            }
        }
    }
}
