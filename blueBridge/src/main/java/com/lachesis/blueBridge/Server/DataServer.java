package com.lachesis.blueBridge.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/8/9.
 */
public class DataServer implements Runnable{
    private int port = 50500;
    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private final int POOL_SIZE = 5;
    public static List<Socket> clientList=new ArrayList<>();

    public DataServer() throws Exception{
        this.serverSocket = new ServerSocket(port);
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * POOL_SIZE);
    }

    public void service(){
        while(true){
            Socket socket=null;
            try {
                socket = serverSocket.accept();
                clientList.add(socket);
                executorService.execute(new DataHandler(socket));
                System.out.println("当前连接的客户端数量为："+clientList.size());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new DataServer().service();
    }

    @Override
    public void run() {
        service();
    }
}
