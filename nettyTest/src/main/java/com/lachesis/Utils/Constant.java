package com.lachesis.Utils;

/**
 * Created by ThinkPad on 2016/11/24.
 * 参数可以根据实际情况配置，客户端和服务器各一份，互不影响
 */
public class Constant {

    public static final String HEART_BEAT_MGS="H";  //心跳消息类型

    public static final String WORK_MSG="W";        //输液信息类型

    public static final String AUTH_MSG="A";        //认证消息信息类型

    public static final String LS=System.getProperty("line.separator"); //换行符号

    public static  final int READ_TIME_OUT=40;    //读取超时时间 s

    public static  final int HEART_BEAT_RATE=30; //客户端心跳频率 s

    public static  final int WORK_SEND_RATE=5; //服务器业务消息发送频率 s

    public static  final int SERVER_READ_TIME_OUT=3600;    //服务器读取超时时间 s



}
