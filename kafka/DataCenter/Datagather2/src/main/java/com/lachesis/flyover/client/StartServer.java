/**
 * 
 */
package com.lachesis.flyover.client;

import com.lachesis.server.NettyServerBootstrap;
import com.lachesis.utils.InfusionProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;

/**
 * @author tao.xiong
 * @date 2015年9月24日 上午11:22:46
 */
@Component
public class StartServer {
	@Autowired
	private GatherDataServer gatherDataServer;
	@Autowired
	private InfusionProperty infusionProperty;
	
	static final Logger LOGGER = LoggerFactory.getLogger(StartServer.class);
	
	@PostConstruct
	public void init(){
		//启动netty服务器
		NettyServerBootstrap myThread = new NettyServerBootstrap(9998);
		Thread thread = new Thread(myThread);
		thread.start();

		if (infusionProperty.isGatherDataSwitch()){
			handleGatherData();
			System.out.println("-----------------启动数据收集服务---------------");

		}
	}
	
	/**
	 * 从硬件服务器获取基础重量数据
	 * @author tao.xiong
	 * @date 2015年9月24日 上午11:33:25
	 */
	public void handleGatherData() {
		LOGGER.info("开始连接硬件服务器.........");
		System.out.println("开始连接硬件服务器.........");
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			public void run() {
				
				boolean connStatus;
				while(true){
					connStatus = false;
					while (!connStatus) {
						
						connStatus = gatherDataServer.init();
						if (!connStatus) {
							try {
								Thread.sleep(1000*60);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					
					gatherDataServer.getAndHandleGatherData();
				}
			}
		});
	}
	

}
