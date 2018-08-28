package com.test.client.sw.clients;

import java.io.*;
import java.net.Socket;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/1/25.
 */
public class Client {
    private Socket socket;
    private PrintWriter pw ;
    private BufferedReader br ;

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    private String header = "#$0B";
    private String tail = "#$1C#$0D";
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void connect(String ip,int port){
        try {
            socket = new Socket(ip, port);
            OutputStream outputStream=socket.getOutputStream();
            InputStream inputStream=socket.getInputStream();
            pw=new PrintWriter(outputStream);
            br=new BufferedReader(new InputStreamReader(inputStream));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void sendMessage(String message){
            String sendStr= header+message+tail+System.getProperty("line.separator");
            pw .write(sendStr);
            pw.flush();
            System.out.println("发送消息完成");
    }
    public String readMessage()throws Exception{
        String info="";
        while((info=br.readLine())!=null){
             // System.out.println("我是客户端，服务器说："+info);
              return info;
             }
         return info;
    }
}
