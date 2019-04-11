package com.yqh.echo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThinkPad on 2016/11/17.
 */
public class EchoClient {

    private int port=9999;
    private String ipAddress;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public  void connectServer(String address,int port ,final EchoClient client )throws Exception{
        this.ipAddress=address;
        this.port=port;
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline= ch.pipeline();
                    pipeline.addLast(new LineBasedFrameDecoder(1024));
                    pipeline.addLast("decoder", new StringDecoder());
                    pipeline.addLast("encoder", new StringEncoder(Charset.forName("gbk")));
                    pipeline .addLast(new ClientHandler(client));
                    pipeline.addLast(new ClientBeatHeartHandler());
                    pipeline.addLast(new ReadTimeoutHandler(10, TimeUnit.SECONDS));

                }
            });

            // Start the client.
            ChannelFuture f = b.connect(this.ipAddress,this.port).sync(); // (5)
            if (f.isSuccess()) {
                System.out.println("连接服务器成功！");
                Scanner scanner=new Scanner(System.in);
                SocketChannel socketChannel = (SocketChannel) f.channel();
               /* while (scanner.hasNext()){
                    String sendData=scanner.next();
                    System.out.println("将要发送的消息："+sendData);
                    socketChannel.writeAndFlush(sendData+System.getProperty("line.separator"));
                }*/
            }
            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            System.out.println("连接失败，请检查ip或端口是否正确以及服务器是否开启！");
            Thread.sleep(5000);
            System.out.println("网络正在重连...");
            connectServer(this.ipAddress,this.port,client);
        }
    }
    public static void main(String[] args) throws Exception{
        EchoClient client=new EchoClient();
        //client.connectServer("localhost", 9999,client);
        client.connectServer("10.2.13.219", 3033,client);

    }
}
