package com.test.mpush.pojo;

/**
 * Created by ThinkPad on 2016/9/6.
 */
public class Message {

    private String  toUserName;
    private String fromUserName;
    private String msgType;
    private Object content;
    private String CreateTime;

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

   

    public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

	@Override
	public String toString() {
		return "Message [toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", msgType=" + msgType + ", content="
				+ content + ", CreateTime=" + CreateTime + "]";
	}
    
    
}
