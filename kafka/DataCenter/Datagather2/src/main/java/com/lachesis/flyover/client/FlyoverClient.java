package com.lachesis.flyover.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

/**
 * 创建和硬件服务器连接的Socket客户端，以及各种和硬件交互的命令
 * @author tao.xiong
 * @date 2015年9月8日 上午9:51:45
 */
public class FlyoverClient {
	private String ip;
	private int port;
	private Socket socket;
	OutputStream output;
	InputStream input;
	
	static final Logger LOGGER = LoggerFactory.getLogger(FlyoverClient.class);
	BufferedReader reader =null; 
	public FlyoverClient(String serverIp, int port) {
		this.ip = serverIp;
		this.port = port;
	}
	
	public Socket getSocket() {
		return socket;
	}

	/**
	 * 向硬件服务器发送"Who am I"命令，并接受返回
	 * 向立交桥表明身份 第二个字节为 0x39表示非立交桥设备，0x30表示立交桥设备
	 * 
	 * @param index
	 * @return
	 */
	public FlyoverClientResult whoAmI(byte index) {
		if (socket == null || !socket.isConnected()) {
			socketConn();
		}

		try {
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append("lachesis002");
			strBuilder.append("[");
			strBuilder.append("0022");
			strBuilder.append("]");
			strBuilder.append("cl_cmd_whoami");
			strBuilder.append("@");
			strBuilder.append("infusion");
			
			// 拼好的请求发往服务器
			output.write(strBuilder.toString().getBytes());
			//System.out.println("request:" + bytesToHexString(byteOut.toByteArray(),true));
			LOGGER.info("Who am i request:" + strBuilder);
			output.flush();
			
			// 接受服务器返回

			FlyoverClientResult result = new FlyoverClientResult();
			result.setState(0); 
			return result;

		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			throw new RuntimeException("写入数据失败");
			
		}
	}
	
	/**
	 * 向硬件服务器发送获取蓝桥信息"CL_CMD_GET_BBST_INFO"命令，并接受返回
	 * @param index
	 * @return
	 */
	public FlyoverClientResult Getbbstinfo() {
		if (socket == null || !socket.isConnected()) {
			socketConn();
		}

		try {
			
			StringBuilder strBuilderGetbbstInfo = new StringBuilder();
			strBuilderGetbbstInfo.append("lachesis002");
			strBuilderGetbbstInfo.append("[");
			strBuilderGetbbstInfo.append("0020");
			strBuilderGetbbstInfo.append("]");
			strBuilderGetbbstInfo.append("cl_cmd_get_bbst_info");
			
			// 拼好的请求发往服务器
			output.write(strBuilderGetbbstInfo.toString().getBytes());
			//System.out.println("request:" + bytesToHexString(byteOut.toByteArray(),true));
			LOGGER.info("get_bbst_info request:" + strBuilderGetbbstInfo);
			output.flush();
           
			// 接受服务器返回

			FlyoverClientResult result = new FlyoverClientResult();
			result.setState(0); 
			return result;

		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			throw new RuntimeException("写入数据失败");
			
		}
	}
	
	/**
	 * 向硬件服务器发送获取蓝桥和蓝桥挂载的监测器信息CL_CMD_GET_BBST_BLE_INFO命令，并接受返回
	 * @param index
	 * @return
	 */
	public FlyoverClientResult Getbbstbleinfo(List<FlyoverClientResult> savebbstbleList) {
		String flyovermacaddress=new String();
		
		if (socket == null || !socket.isConnected()) {
			socketConn();
		}

		for(int i=0;i<savebbstbleList.size();i++)
		{	
			flyovermacaddress=savebbstbleList.get(i).getFlyoverMacAddress();
		try {
			
			StringBuilder strBuilderGetbbstbleInfo = new StringBuilder();
			strBuilderGetbbstbleInfo.append("lachesis002");
			strBuilderGetbbstbleInfo.append("[");
			strBuilderGetbbstbleInfo.append("0042");
			strBuilderGetbbstbleInfo.append("]");
			strBuilderGetbbstbleInfo.append("cl_cmd_get_bbst_ble_info");
			strBuilderGetbbstbleInfo.append("@");
			strBuilderGetbbstbleInfo.append(flyovermacaddress);
			
			// 拼好的请求发往服务器
			output.write(strBuilderGetbbstbleInfo.toString().getBytes());
			//System.out.println("request:" + bytesToHexString(byteOut.toByteArray(),true));
			LOGGER.info("get_bbst_ble_info request:" + strBuilderGetbbstbleInfo);
			output.flush();

		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			throw new RuntimeException("写入数据失败");
			
		}
		
	   }
		
		// 接受服务器返回

		FlyoverClientResult result = new FlyoverClientResult();
		result.setState(0); 
		return result;
	}
	
	/**
	 * 向硬件服务器发送获取某蓝桥和蓝桥挂载的监测器信息CL_CMD_GET_BBST_BLE_INFO命令
	 * @param bbstmacaddress
	 */
	public void Getbbstbleinfo(String bbstmacaddress) {
		
		
		if (socket == null || !socket.isConnected()) {
			socketConn();
		}

			
		try {
			
			StringBuilder strBuilderGetbbstbleInfo = new StringBuilder();
			strBuilderGetbbstbleInfo.append("lachesis002");
			strBuilderGetbbstbleInfo.append("[");
			strBuilderGetbbstbleInfo.append("0042");
			strBuilderGetbbstbleInfo.append("]");
			strBuilderGetbbstbleInfo.append("cl_cmd_get_bbst_ble_info");
			strBuilderGetbbstbleInfo.append("@");
			strBuilderGetbbstbleInfo.append(bbstmacaddress);
			
			// 拼好的请求发往服务器
			output.write(strBuilderGetbbstbleInfo.toString().getBytes());
			//System.out.println("request:" + bytesToHexString(byteOut.toByteArray(),true));
			LOGGER.info("get_bbst_ble_info request:" + strBuilderGetbbstbleInfo);
			output.flush();
           
			

		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			throw new RuntimeException("写入数据失败");
			
		}
		
	   
		
		
	}
	
	/**
	 * 向硬件服务发送监听命令，并处理返回数据
	 * @author tao.xiong
	 * @date 2015年9月15日 下午1:19:57 
	 * @param macAddress
	 * @param index
	 * @return
	 */
	public FlyoverClientResult subscribe(String macAddress, byte index) {
		if (socket == null || !socket.isConnected()) {
			socketConn();
		}

		try {
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			byteOut.write(0x33);
			byteOut.write(index);
			byteOut.write(new byte[6]);
			byteOut.write(0);

			output.write(byteOut.toByteArray());
			byteOut.close();

			/*
			 * byte[] temp = new byte[4]; input.read(temp);
			 * 
			 * FlyoverClientResult result = new FlyoverClientResult();
			 * result.setAckCode(temp[0]); result.setIndex(temp[2]);
			 * result.setState(temp[3]); return result;
			 */

			return new FlyoverClientResult();

		} catch (IOException e) {
			throw new RuntimeException("写入数据失败");
		}
	}

	/**
	 * 建立Socket连接
	 * @author tao.xiong
	 * @date 2015年9月15日 下午1:20:55
	 */
	public void socketConn() {
		try {
			if (socket != null) {
				socket.close();
				socket = null;
			}
			if (output != null) {
				output.close();
				output = null;
			}
			if (input != null) {
				input.close();
				input = null;
			}
			socket = new Socket(ip, port);
			output = socket.getOutputStream();
			input = socket.getInputStream();
			reader=new BufferedReader(new InputStreamReader(input));//moved here by shouna.wen from getData() 
		} catch (UnknownHostException e) {
			LOGGER.error(e.getMessage());
			throw new RuntimeException("未知的服务器");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			throw new RuntimeException("服务器连接失败,1分钟后重新连接");
		}
	}

	/**
	 * 关闭Socket连接
	 * @author tao.xiong
	 * @date 2015年9月15日 下午1:21:23
	 */
	public void socketClose() {
		try {
			if (output != null) {
				output.close();
				output = null;
			}

			if (input != null) {
				input.close();
				input = null;
			}
			if (socket != null) {
				socket.close();
				socket = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取硬件服务器返回的数据包
	 * @author tao.xiong
	 * @date 2015年9月15日 下午1:21:58 
	 * @return
	 * @throws IOException 
	 */
	public String getData() throws IOException {
		//BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		return reader.readLine();

	}
	
}
