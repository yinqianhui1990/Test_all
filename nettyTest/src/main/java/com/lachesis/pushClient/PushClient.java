package com.lachesis.pushClient;
import com.alibaba.fastjson.JSON;
import com.lachesis.Utils.ConnectInfo;
import com.lachesis.Utils.Constant;
import com.lachesis.Utils.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThinkPad on 2016/11/24.
 */
public class PushClient {

    public static void connectServer(String address,int port )throws Exception{

        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline= ch.pipeline();
                    pipeline.addLast(new LineBasedFrameDecoder(1024));
                    pipeline.addLast("decoder", new StringDecoder(Charset.forName("utf-8")));
                    pipeline.addLast("encoder", new StringEncoder(Charset.forName("utf-8")));
                    pipeline .addLast(new PushClientHandler());
                    pipeline.addLast(new HeartBeatClientHandler());
                    pipeline.addLast(new ReadTimeoutHandler(Constant.READ_TIME_OUT, TimeUnit.SECONDS));
                }
            });

            // Start the client.
            ChannelFuture f = b.connect(address,port).sync(); // (5)
            if (f.isSuccess()) {
                System.out.println("连接服务器成功！");
                //发送身份消息
                SocketChannel socketChannel = (SocketChannel) f.channel();
                Message request=new Message();
                request.setToUserName("server");
                request.setMsgType(Constant.AUTH_MSG);
                request.setFromUserName(socketChannel.id().toString());
                request.setBody("652");
                request.setCreateTime(new Date());
                socketChannel.writeAndFlush(JSON.toJSONString(request)+ Constant.LS);

            }
            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            System.out.println("连接失败，请检查ip或端口是否正确以及服务器是否开启！");
            Thread.sleep(5000);
            System.out.println("网络正在重连...");
            connectServer(ConnectInfo.IP,ConnectInfo.PORT);
        }
    }

    public static void main(String[] args) {
        try {
           connectServer(ConnectInfo.IP, ConnectInfo.PORT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
