/**
 * 
 */
package com.lachesis.flyover.client;

/*import com.lachesis.flyover.service.IInfusionDataService;
import com.lachesis.flyover.service.IInfusionDispersionAnalysesService;
import com.lachesis.infusionmanager.pojo.InfusionDeviceInfo;
import com.lachesis.mybatis.mapper.InfusionManagerMapper;
import com.lachesis.mybatis.mapper.InmGatherInfoMapper;*/
import com.lachesis.service.DataManagerService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 启动和硬件服务器连接的Socket客户端，并向硬件服务器发送各种命令，接受服务器返回
 * @author tao.xiong
 * @date 2015年9月15日 上午9:46:51
 */
@Component
public class GatherDataServer {
	
	@Autowired
	private SocketConnInfo socketConnInfo;
	/*@Autowired
	private IInfusionDataService infusionDataServiceImpl;
	
	@Autowired
	private IInfusionDispersionAnalysesService infusionAnalysesService;
	
	@Autowired
	private InfusionManagerMapper infusionManagerMapper;
	
	@Autowired
	private InmGatherInfoMapper inmGatherInfoMapper;*/
	
	@Autowired
	private Parse parse;
	@Autowired
	private DataManagerService dataManagerService;
	FlyoverClient client;
	
	List<FlyoverClientResult> saveWeightList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveRestPowerList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveLinkStatusList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveFlyoverBbstInfoList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveFlyoverNewBbstInfoList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveFlyoverDisconnectedBbstInfoList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveFlyoverBbstBleInfoList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveFlyoverConnectmodifyedBbstBleInfoList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveNewInfusionBagList = new ArrayList<FlyoverClientResult>();

	List<FlyoverClientResult> saveHeartRateList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveThermometerList = new ArrayList<FlyoverClientResult>();

	List<FlyoverClientResult> saveHeartRateKeyList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveLocationKeyList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveThermometerKeyList = new ArrayList<FlyoverClientResult>();

	List<FlyoverClientResult> saveHeartRateStatusList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveLocationStatusList = new ArrayList<FlyoverClientResult>();
	List<FlyoverClientResult> saveThermometerStatusList = new ArrayList<FlyoverClientResult>();
	static final Logger LOGGER = LoggerFactory.getLogger(GatherDataServer.class);
	
	
	/**
	 * 创建Socket客户端
	 * @author tao.xiong
	 * @date 2015年9月15日 上午9:58:49
	 */
	public boolean init() {
		boolean status = true;
		try {
			LOGGER.info("连接输液监视蓝桥服务器-----" + socketConnInfo.getIp() + ":" + socketConnInfo.getPort());
			if (client == null) {
				client = new FlyoverClient(socketConnInfo.getIp(), socketConnInfo.getPort());
			}
			//建立连接
			client.socketConn();
			//测试连接
           	client.getSocket().sendUrgentData(0xFF);
            if (status) {
            	System.out.println("已连接硬件服务器");
            	LOGGER.info("已连接硬件服务器");
            }
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			status = false;
		}
		return status;
	}

	/**
	 * 关闭Socket
	 * @author tao.xiong
	 * @date 2015年9月15日 上午9:59:58
	 */
	public void destroy() {
		client.socketClose();
	}
	
	/**
	 * 向硬件服务器发送"Who am I"命令，并接受返回的重量数据
	 * @author tao.xiong
	 * @date 2015年9月15日 下午1:45:35
	 */
	public boolean getAndHandleGatherData() {
		try {
			client.whoAmI((byte) 1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		if (saveWeightList == null) {
			saveWeightList = new ArrayList<FlyoverClientResult>();
		}
		if (saveRestPowerList == null) {
			saveRestPowerList = new ArrayList<FlyoverClientResult>();
		}
		if (saveLinkStatusList == null) {
			saveLinkStatusList = new ArrayList<FlyoverClientResult>();
		}

		
		if (saveFlyoverBbstInfoList == null) {
			saveFlyoverBbstInfoList = new ArrayList<FlyoverClientResult>();
		}
		
		if (saveFlyoverNewBbstInfoList == null) {
			saveFlyoverNewBbstInfoList = new ArrayList<FlyoverClientResult>();
		}
		
		if (saveFlyoverDisconnectedBbstInfoList == null) {
			saveFlyoverDisconnectedBbstInfoList = new ArrayList<FlyoverClientResult>();
		}
		
		if (saveFlyoverBbstBleInfoList == null) {
			saveFlyoverBbstBleInfoList = new ArrayList<FlyoverClientResult>();
		}
		
		if (saveFlyoverConnectmodifyedBbstBleInfoList == null) {
			saveFlyoverConnectmodifyedBbstBleInfoList = new ArrayList<FlyoverClientResult>();
		}
		if (saveHeartRateList == null) {
			saveHeartRateList = new ArrayList<FlyoverClientResult>();
		}
		if (saveThermometerList == null) {
			saveThermometerList = new ArrayList<FlyoverClientResult>();
		}

		if (saveHeartRateKeyList == null) {
			saveHeartRateKeyList = new ArrayList<FlyoverClientResult>();
		}
		if (saveLocationKeyList == null) {
			saveLocationKeyList = new ArrayList<FlyoverClientResult>();
		}
		if (saveThermometerKeyList == null) {
			saveThermometerKeyList = new ArrayList<FlyoverClientResult>();
		}
//-------------------------------------------------------------------------
		if (saveHeartRateStatusList == null) {
			saveHeartRateStatusList = new ArrayList<FlyoverClientResult>();
		}
		if (saveLocationStatusList == null) {
			saveLocationStatusList = new ArrayList<FlyoverClientResult>();
		}
		if (saveThermometerStatusList == null) {
			saveThermometerStatusList = new ArrayList<FlyoverClientResult>();
		}
	
		String data = null;
		int index;


		while(true){ 
			try {

				//后续还需要过滤掉其它命令的相应数据，只获取返回的重量数据
				data = client.getData().trim();
//				System.out.println("原始服务器数据1====data:"+data);
				if (data == null) {
					LOGGER.info("服务器已断开.........");
					System.out.println("服务器已断开.........");
					return false;
				}
			    
				if (data.trim().isEmpty()) continue;
//				System.out.println("reader.readLine=== data:::" + data + "bytes:::" + Arrays.toString(data.getBytes()));

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
			if (StringUtils.isEmpty(data)) continue;
			
			try {
				
				System.out.println("原始服务器数据=========data:"+data);
				
				index = data.indexOf('@');
 
				if("cl_event_ladrip_power".equals(data.substring(data.indexOf(']')+1,index)))
				{
	                //监测器剩余电量
					saveRestPowerList.addAll(parse.parseBtWgtPwrSts(data));
	              //  this.infusionDataServiceImpl.saveInfusionGatherDeviceRestPowerInfo(saveRestPowerList);
					saveRestPowerList.clear();
				}
				else if("cl_event_ladrip_status".equals(data.substring(data.indexOf(']')+1,index)))
				{
					//监测器在线状态 
					//cl_event_ladrip_status@c6:be:84:00:01:15,00000277,Ladrip,offline
	                saveLinkStatusList.addAll(parse.parseBtWgtPwrSts(data));
	              //  this.infusionDataServiceImpl.saveInfusionGatherDeviceLinkStatusInfo(saveLinkStatusList);
	               // this.infusionAnalysesService.markedDeviceOfflineStatus(saveLinkStatusList);
					saveLinkStatusList.clear();
				}
				else if("cl_event_ladrip_cur_weight".equals(data.substring(data.indexOf(']')+1,index)))
				{	
					//批量存入重量数据
					System.out.println("add new weight::::::::data="+data);
					saveWeightList.addAll(parse.parseBtWgtPwrSts(data));
//					if(saveWeightList.size() >= 5){
//					    //this.infusionDataServiceImpl.analyseInfusionData(saveWeightList);
//				    }
					//防止输液离开时，后面不到5个长度的数据不会存入redis
					//this.infusionAnalysesService.saveWeightData(saveWeightList);
					saveWeightList.clear();
				}
				else if("cl_ack_get_bbst_info".equals(data.substring(data.indexOf(']')+1,index)))
				{
					//收集蓝桥信息
					saveFlyoverBbstInfoList.addAll(parse.parseBtWgtPwrSts(data));
					//this.infusionDataServiceImpl.saveInfusionGatherFlyoverBbstsInfo(saveFlyoverBbstInfoList);
	      
					try {
						client.Getbbstbleinfo(saveFlyoverBbstInfoList);
					} catch (Exception e) {
						e.printStackTrace();
						return false;
					}
                    saveFlyoverBbstInfoList.clear();
				}
				else if("cl_ack_get_bbst_ble_info".equals(data.substring(data.indexOf(']')+1,index)))
				{
					//获取某个蓝桥下所有监测器
					saveFlyoverBbstBleInfoList.addAll(parse.parseBtWgtPwrSts(data));
                   // this.infusionDataServiceImpl.saveInfusionGatherFlyoverBbstBlesInfo(saveFlyoverBbstBleInfoList);
                    saveFlyoverBbstBleInfoList.clear();
				}
				else if("cl_event_bbst_connected".equals(data.substring(data.indexOf(']')+1,index)))
				{
					saveFlyoverNewBbstInfoList.addAll(parse.parseBtWgtPwrSts(data));
					// this.infusionDataServiceImpl.saveInfusionGatherFlyoverBbstsInfo(saveFlyoverNewBbstInfoList);
                
					 saveFlyoverNewBbstInfoList.clear();
				}
				else if("cl_event_bbst_disconnected".equals(data.substring(data.indexOf(']')+1,index)))
				{
					//蓝桥离线
					saveFlyoverDisconnectedBbstInfoList.addAll(parse.parseBtWgtPwrSts(data));
				//	 this.infusionDataServiceImpl.saveInfusionGatherFlyoverDisconnectedBbstStatusInfo(saveFlyoverDisconnectedBbstInfoList);
               
					 saveFlyoverDisconnectedBbstInfoList.clear();
				}
				else if("cl_event_ble_connected".equals(data.substring(data.indexOf(']')+1,index)))
				{
					//蓝桥在线后，该蓝桥下连接的所有监测器信息
					saveFlyoverConnectmodifyedBbstBleInfoList.addAll(parse.parseBtWgtPwrSts(data));
				//	this.infusionDataServiceImpl.saveInfusionGatherFlyoverConnectmodifyedBbstbleInfo(saveFlyoverConnectmodifyedBbstBleInfoList);
               
					saveFlyoverConnectmodifyedBbstBleInfoList.clear();
				}
				else if("cl_event_ladrip_key".equals(data.substring(data.indexOf(']')+1,index)))
				{	
					saveNewInfusionBagList.addAll(parse.parseBtWgtPwrSts(data));
					//开始输液，增加新输液袋
				/*	this.infusionAnalysesService.initNewInfusionBag(saveNewInfusionBagList);
					if (!saveNewInfusionBagList.isEmpty())
					{
						//已经开始输液，一定是在线状态
						InfusionDeviceInfo baseInfo = new InfusionDeviceInfo();
						baseInfo.setMacAddress(saveNewInfusionBagList.get(0).getBtAddress());
						baseInfo.setDeviceLnk("1");
						infusionManagerMapper.updateDeviceLinkStatusInfo(baseInfo);
					}*/
					saveNewInfusionBagList.clear();
				}
				else if("cl_event_ladrip_motion".equals(data.substring(data.indexOf(']')+1,index)))
				{	
					saveNewInfusionBagList.addAll(parse.parseBtWgtPwrSts(data));
				//	this.infusionAnalysesService.isGatherDataToRedis(saveNewInfusionBagList);
					saveNewInfusionBagList.clear();
				}
				else if("cl_event_l_heartrate_data".equals(data.substring(data.indexOf(']')+1,index)))
				{
					saveHeartRateList.addAll(parse.parseBtWgtPwrSts(data));
					LOGGER.info("saveHeartRateList======"+saveHeartRateList);
					dataManagerService.insertFlyoverClientResultList(saveHeartRateList);
					saveHeartRateList.clear();
				}
				else if("cl_event_l_thermometer_data".equals(data.substring(data.indexOf(']')+1,index)))
				{
					saveThermometerList.addAll(parse.parseBtWgtPwrSts(data));
					LOGGER.info("saveThermometerList======"+saveThermometerList);
					dataManagerService.insertFlyoverClientResultList(saveThermometerList);
					saveThermometerList.clear();
				}
				else if("cl_event_l_location_key".equals(data.substring(data.indexOf(']')+1,index)))
				{
					saveLocationKeyList.addAll(parse.parseBtWgtPwrSts(data));
					LOGGER.info("saveLocationKeyList======"+saveLocationKeyList);
				}else if("cl_event_l_heartrate_key".equals(data.substring(data.indexOf(']')+1,index)))
				{
					saveHeartRateKeyList.addAll(parse.parseBtWgtPwrSts(data));
					LOGGER.info("saveHeartRateKeyList======"+saveHeartRateKeyList);
				}else if("cl_event_l_thermometer_key".equals(data.substring(data.indexOf(']')+1,index)))
				{
					saveThermometerKeyList.addAll(parse.parseBtWgtPwrSts(data));
					LOGGER.info("saveThermometerKeyList======"+saveThermometerKeyList);
				}else if("cl_event_l_heartrate_status".equals(data.substring(data.indexOf(']')+1,index)))
				{
					saveHeartRateStatusList.addAll(parse.parseBtWgtPwrSts(data));
					LOGGER.info("saveHeartRateStatusList======"+saveHeartRateStatusList);
				}else if("cl_event_l_location_status".equals(data.substring(data.indexOf(']')+1,index)))
				{
					saveLocationStatusList.addAll(parse.parseBtWgtPwrSts(data));
					LOGGER.info("saveLocationStatusList======"+saveLocationStatusList);
				}else if("cl_event_l_thermometer_status".equals(data.substring(data.indexOf(']')+1,index)))
				{
					saveThermometerStatusList.addAll(parse.parseBtWgtPwrSts(data));
					LOGGER.info("saveThermometerStatusList======"+saveThermometerStatusList);
				}


			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将字符串写入文件
	 * 
	 * @author tao.xiong
	 * @date 2015年9月8日 上午10:52:05 
	 * @param fos 写入的文件流
	 * @param content 写入内容
	 */
	public void writeFile(FileOutputStream fos, String content){
		
		//String writeDateStr = Util.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		try {
				//fos.write((writeDateStr + " ").getBytes());
				fos.write(content.getBytes());
				fos.write("\r\n".getBytes());
				fos.flush();
			
		} catch (IOException e1) {
			e1.printStackTrace();
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @author tao.xiong
	 * @date 2015年9月8日 下午2:36:19 
	 * @param filePath
	 * @return
	 */
	public FileOutputStream getFileOutputStream(String filePath){
		File file = new File(filePath);
		FileOutputStream fos = null;
		try{
			if(!file.exists()){
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			
		}catch(IOException e){
			e.printStackTrace();
		}
		return fos;
	}
	
	/**
	 * 
	 * @author shouna.wen
	 * @date 2015年12月29日  
	 * @return
	 */
	public FlyoverClient getClient() {
		return client;
	}
	
    
}
