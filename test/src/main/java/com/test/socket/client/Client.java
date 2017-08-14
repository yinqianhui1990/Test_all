package com.test.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ThinkPad on 2017/8/10.
 */
public class Client {
    String ip="10.2.10.179";
    int port=5209;
    Socket socket=null;
    Thread readThread=null;
    Thread heartBeat=null;
    public void  connectServer(){
        try {
            //10.2.10.179
            // 1、创建客户端Socket，指定服务器地址和端口
            // Socket socket=new Socket("127.0.0.1",5200);
            socket = new Socket(ip,port);
            socket.setKeepAlive(true);
            socket.setSoTimeout(30*1000);
            System.out.println("客户端启动成功");

            // 2、获取输出流，向服务器端发送信息
            // 向本机的52000端口发出客户请求
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // 由系统标准输入设备构造BufferedReader对象

            readThread=new Thread(new ClientReadThread(socket,this));
            readThread.start();
            //心跳线程
            heartBeat=new Thread(new ClientHeartBeat(socket));
            heartBeat.start();
    /*        String readline;
            readline = br.readLine(); // 从系统标准输入读入一字符串
            while (!readline.equals("end")) {
                try {
                    // 若从标准输入读入的字符串为 "end"则停止循环
                    write.println(readline);
                    // 将从系统标准输入读入的字符串输出到Server
                    write.flush();
                    // 刷新输出流，使Server马上收到该字符串
                    System.out.println("Client:" + readline);
                    // 在系统标准输出上打印读入的字符串
                    readline = br.readLine(); // 从系统标准输入读入一字符串
                }catch (Exception e){
                    e.printStackTrace();
                }
            } // 继续循环*/
        } catch (Exception e) {
            System.out.println("can not listen to:" + e);// 出错，打印出错信息
        }
    }

    public void closeResource(PrintWriter writer,BufferedReader in,Socket socket){
        try{
            if(null!=writer){
                writer.close();
            }
            if(null!=in){
                in.close();
            }
            if (null != socket) {
                if (!socket.isClosed()) {
                    socket.close();
                }
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        Client client=new Client();
        client.connectServer();
    }
}
