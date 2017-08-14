package com.test.socket.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ThinkPad on 2017/8/10.
 */
public class ClientReadThread implements Runnable{
    Socket socket;
    Client client ;
    public ClientReadThread(Socket socket,Client client) {
        this.socket = socket;
        this.client=client;
    }

    public void run() {
        PrintWriter write=null;
        BufferedReader in=null;
        try{
            write = new PrintWriter(socket.getOutputStream());
            // 由Socket对象得到输出流，并构造PrintWriter对象
            //3、获取输入流，并读取服务器端的响应信息
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 由Socket对象得到输入流，并构造相应的BufferedReader对象
        while (true){
            System.out.println("收到消息:"+in.readLine());
            //在标准输出上打印从客户端读入的字符串
          }
        }catch (Exception e){
            System.out.println("客户端读取error:"+e);
            client.closeResource(write,in,socket);
            client.connectServer();
        }
    }
}
