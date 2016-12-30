package com.lachesis.Utils;

import java.util.Date;

/**
 * Created by ThinkPad on 2016/11/24.
 */
public class Message {
    private String toUserName;
    private String fromUserName;
    private String msgType;
    private Object body;
    private Date   CreateTime;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", msgType='" + msgType + '\'' +
                ", body=" + body +
                ", CreateTime=" + CreateTime +
                '}';
    }
}
