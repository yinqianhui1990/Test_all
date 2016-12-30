package com.lachesis.server;

/**
 * Created by qianhui.yin on 2016/1/19.
 */
import com.alibaba.fastjson.JSON;
import com.lachesis.flyover.client.FlyoverClientResult;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class NettyServerBootstrap implements  Runnable{

    // private static Logger logger = Logger.getLogger(NettyServerBootstrap.class);

    private int port;

    public NettyServerBootstrap(int port) {
        this.port = port;
       // bind();
    }

    private void bind() {

        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        try {

            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(boss, worker);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.option(ChannelOption.SO_BACKLOG, 1024); //连接数
            bootstrap.option(ChannelOption.TCP_NODELAY, true);  //不延迟，消息立即发送
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true); //长连接
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel)
                        throws Exception {
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    pipeline.addLast(new LineBasedFrameDecoder(1024));
                    pipeline.addLast("decoder", new StringDecoder());
                    pipeline.addLast("encoder", new StringEncoder(Charset.forName("UTF-8")));

                    pipeline.addLast(new NettyServerHandler());
                }
            });
            ChannelFuture f = bootstrap.bind(port).sync();
            if (f.isSuccess()) {
                System.out.println("启动Netty服务成功，端口号：" + this.port);
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                FlyoverClientResult flyoverClientResult=new FlyoverClientResult();
                String str="";
                while(true){
                    try{
                        str=in.readLine();
                        if(str!=null) {
                            flyoverClientResult.setBtAddress("dj:90:ds:sj:dd"+str);
                            flyoverClientResult.setCoreData(100);
                            flyoverClientResult.setDataType("heartrate");
                            flyoverClientResult.setDateTime(System.currentTimeMillis());
                            ChannelGroup channels=NettyServerHandler.channels;
                            if(channels.size()>=1) {
                                for (Channel channel : channels) {
                                    channel.writeAndFlush( JSON.toJSONString(flyoverClientResult)+"\r\n");
                                }
                            }
                        }

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                }
            }
            // 关闭连接
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            // logger.error("启动Netty服务异常，异常信息：" + e.getMessage());
            System.out.println("启动Netty服务异常，异常信息：" + e.getMessage());
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public void  run(){
       this.bind();
    }


    public static void main(String[] args) throws InterruptedException {

        NettyServerBootstrap server= new NettyServerBootstrap(9998);

    }

}
