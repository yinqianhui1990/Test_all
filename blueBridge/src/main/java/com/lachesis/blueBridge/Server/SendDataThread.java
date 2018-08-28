package com.lachesis.blueBridge.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/8/9.
 */
public class SendDataThread implements Runnable{
    private BlockingQueue<String> queue;

    public SendDataThread(BlockingQueue queue) {
        this.queue = queue;
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }
    @Override
    public void run() {
        while (true){
            try {
                String res = queue.take();
                System.out.println("consumer消费数据:" + res);
                for (Socket socket : DataServer.clientList) {
                    PrintWriter printWriter = getWriter(socket);
                    printWriter.println(res);
                    printWriter.flush();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
