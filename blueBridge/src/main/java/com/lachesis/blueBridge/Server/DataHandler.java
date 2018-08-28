package com.lachesis.blueBridge.Server;

import java.io.*;
import java.net.Socket;
import java.util.Iterator;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/8/9.
 */
public class DataHandler implements Runnable{
    private Socket socket;

    public DataHandler(Socket socket) {
        this.socket = socket;
    }
    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }
    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter out = null;
        try {
            br = getReader(socket);
            out = getWriter(socket);
            String msg = null;
            while (true) {
                msg = br.readLine();
              /*  out.println("已经收到");
                out.flush();*/
                System.out.println("s1:" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    //清理断开的socket,这种方式不安全，如果大量连接时，应加同步处理，测试数量少可以忽略
                    Iterator<Socket> iter = DataServer.clientList.iterator();
                    while(iter.hasNext()){
                        Socket client=iter.next();
                        if (socket == client) {
                            System.out.println("清理断开的socket");
                            DataServer.clientList.remove(client);
                            System.out.println("当前连接的客户端数量为：" + DataServer.clientList.size());
                            break;
                        }
                    }
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
