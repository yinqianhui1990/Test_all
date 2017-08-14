package com.test.socket.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ThinkPad on 2017/8/10.
 */
public class ServerReadThread implements Runnable {
    Socket socket;

    public ServerReadThread(Socket socket) {
        this.socket = socket;
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

    public void run() {
        BufferedReader in=null;
        PrintWriter writer=null;
        try {
            in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //由Socket对象得到输入流，并构造相应的BufferedReader对象
            writer=new PrintWriter(socket.getOutputStream());
            //由Socket对象得到输出流，并构造PrintWriter对象
            while (true) {
                    String str= in.readLine();
                if(str==null){
                  throw new Exception("读取为空");
                }
                    System.out.println(Thread.currentThread().getId()+":收到消息:" +str );
                    writer.println("服务器已经收到！");
                    writer.flush();
                    //在标准输出上打印从客户端读入的字符串
            }
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getId()+"服务器读取error:" + e);
        }finally {
            closeResource(writer,in,socket);
        }
    }
}
