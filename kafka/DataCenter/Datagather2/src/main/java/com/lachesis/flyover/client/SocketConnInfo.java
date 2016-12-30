/**
 * 
 */
package com.lachesis.flyover.client;

/**
 * 保存连接硬件服务器的连接信息
 * 
 * @author tao.xiong
 * @date 2015年9月15日 下午2:07:44
 */
public class SocketConnInfo {

	private String ip;
	private int port;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
