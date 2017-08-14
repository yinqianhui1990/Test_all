package com.test.socket.client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by ThinkPad on 2017/8/11.
 */
public class ClientHeartBeat implements Runnable{
    private Socket clientSocket;

    public ClientHeartBeat(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
        while (true) {

                //clientSocket.sendUrgentData(0xFF);
                PrintWriter write = new PrintWriter(clientSocket.getOutputStream());
                write.println(Thread.currentThread().getId()+"ping:"+new Date());
                write.flush();
                System.out.println(Thread.currentThread().getId()+"发送心跳："+new Date());
                Thread.sleep(3000);
               }
        } catch (Exception e) {
            System.out.println("发送心跳异常:" + e);
        }
    }
}
