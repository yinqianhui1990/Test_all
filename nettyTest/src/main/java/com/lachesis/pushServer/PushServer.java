package com.lachesis.pushServer;

import com.alibaba.fastjson.JSON;
import com.lachesis.Utils.ConnectInfo;
import com.lachesis.Utils.Constant;
import com.lachesis.Utils.Message;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThinkPad on 2016/11/24.
 */
public class PushServer {

    public void startPushServer(int port){
        //配置服务器
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(4);
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,100)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new LineBasedFrameDecoder(1024));
                            pipeline.addLast("decoder", new StringDecoder(Charset.forName("utf-8")));
                            pipeline.addLast("encoder", new StringEncoder(Charset.forName("utf-8")));
                            pipeline.addLast(new ReadTimeoutHandler(Constant.SERVER_READ_TIME_OUT, TimeUnit.SECONDS));
                            pipeline.addLast(new PushSeverHandler());
                            pipeline.addLast(new HeatBeatServerHandler());
                        }
                    });
            ChannelFuture f = b.bind(port).sync();

            if(f.isSuccess()){
                System.out.println("服务启动成功,端口："+port);

                f.channel().eventLoop().scheduleAtFixedRate(new WorkTask(PushSeverHandler.mapGroup), 5, Constant.WORK_SEND_RATE, TimeUnit.SECONDS);
            }
            f.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }



    public static void main(String[] args) {
        new PushServer().startPushServer(ConnectInfo.PORT);
    }

}
