package com.lachesis.blueBridge.client;

import java.io.*;
import java.net.Socket;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/8/9.
 */
public class Client {
    private Socket socket;

    public Client() {
        try {
            this.socket = new Socket("localhost",50500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void process(){
        PrintWriter printWriter=null;
        BufferedReader br = null;
        try {

            // 发送消息
            String msg = "我是客户端wwwwwwwwwwww哈哈w1241243123";
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(msg);
            printWriter.flush();

            // 接收服务器的反馈
            br = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            while (true){
                String res = br.readLine();
                System.out.println("接收到数据："+res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        new Client().process();
    }
}
