package com.test.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ThinkPad on 2017/8/10.
 */
public class Server {
    ServerSocket server=null;
    public static void main(String[] args) throws IOException {
        Server socketService = new Server();
        //1、a)创建一个服务器端Socket，即SocketService
        socketService.oneServer();
    }
    public  void oneServer(){
        try{
            try{
                server=new ServerSocket(5209);
                //b)指定绑定的端口，并监听此端口。
                System.out.println("服务器启动成功");
                //创建一个ServerSocket在端口5209监听客户请求
            }catch(Exception e) {
                System.out.println("没有启动监听："+e);
                //出错，打印出错信息
            }
            Socket socket=null;
            try{
                while (true) {
                    socket = server.accept();
                    //2、调用accept()方法开始监听，等待客户端的连接
                    //使用accept()阻塞等待客户请求，有客户
                    //请求到来则产生一个Socket对象，并继续执行
                    //3、启动对应线程处理
                    Thread thread=new Thread(new ServerReadThread(socket));
                    thread.start();
                }
            }catch(Exception e) {
                System.out.println("Error."+e);
                //出错，打印出错信息
            }
        }catch(Exception e) {//出错，打印出错信息
            System.out.println("连接发生Error."+e);
        }finally {
            //5、关闭资源
            try {
                server.close(); //关闭ServerSocket
            }catch (Exception e){
                System.out.println("关闭server异常！");
            }
        }
    }


}

