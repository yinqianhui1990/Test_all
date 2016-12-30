/**
 * 
 */
package com.lachesis.flyover.client;

import com.lachesis.utils.Util;
import com.lachesis.utils.DateUtil;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author tao.xiong
 * @date 2015年9月8日 下午6:26:32
 */
@Component
public class Parse {


	/**
	 * 解析蓝牙上传的重量数据
	 * @author tao.xiong
	 * @date 2015年9月15日 下午1:41:56 
	 * @param content
	 * @return
	 */
	public List<FlyoverClientResult> parseBtWeight(String content){
		List<FlyoverClientResult> result = new ArrayList<FlyoverClientResult>();
		if(!Util.isEmptyString(content)){
			String[] recordArray = content.split("lachesis002");
			for (int i = 1; i < recordArray.length; i++) {
				String recordStr = recordArray[i];
				FlyoverClientResult res = new FlyoverClientResult();
				res.setDateTime(new Date().getTime());
				res.setDataLength(Integer.parseInt(recordStr.substring(recordStr.indexOf('[')+1,recordStr.indexOf(']'))));
				int index = recordStr.indexOf('@');
				if(index < 0 ){
					index = recordStr.length();
					res.setData("");
				}else{
					res.setData(recordStr.substring(index + 1));
				}
				res.setCmd(recordStr.substring(recordStr.indexOf(']')+1,index));
				if(!"".equals(res.getData())){
					res.setBtAddress(res.getData().substring(0,res.getData().indexOf(',')));
					DecimalFormat df = new DecimalFormat("0.0");
					double weight_temp = Integer.parseInt(res.getData().substring(res.getData().indexOf(',')+1));
					double weight_total = Double.parseDouble(df.format(weight_temp/10));
					if (Double.parseDouble(df.format(weight_total)) < 0) {
						continue;
					} else {
						res.setCoreData(Double.parseDouble(df.format(weight_total)));
					}
				}
				result.add(res);
			}
		}
		return result;
	}
	
	/**
	 * 解析蓝牙上传的重量、输液监测器剩余电量和输液监测器在线状态
	 * @author shouna.wen
	 * @date 2015年11月18日  
	 * @param content
	 * @return
	 */
	
	
	public List<FlyoverClientResult> parseBtWgtPwrSts(String content){
		List<FlyoverClientResult> result = new ArrayList<FlyoverClientResult>();
		if(!Util.isEmptyString(content)){
			String[] recordArray = content.split("lachesis002");
			for (int i = 1; i < recordArray.length; i++) {
				String recordStr = recordArray[i];
				FlyoverClientResult res = new FlyoverClientResult();
				res.setDataLength(Integer.parseInt(recordStr.substring(recordStr.indexOf('[')+1,recordStr.indexOf(']'))));
				int index = recordStr.indexOf('@');
				if(index < 0 ){
					index = recordStr.length();
					res.setData("");
				}else{
					res.setData(recordStr.substring(index + 1));
				}
				res.setCmd(recordStr.substring(recordStr.indexOf(']')+1,index));
				if(!"".equals(res.getData())){
					int btAddressIndex = res.getData().indexOf(',');
					res.setBtAddress(res.getData().substring(0,btAddressIndex));
					
					if("cl_event_ladrip_cur_weight".equals(res.getCmd()))
					{		
					     DecimalFormat df = new DecimalFormat("0.0");
					     int wtIndex = res.getData().lastIndexOf(",");
					     res.setDateTime(DateUtil.hmsToTimemillis(res.getData().substring(wtIndex + 1)));
					     double weight_temp = Integer.parseInt(res.getData().substring(btAddressIndex+1,wtIndex));
					     double weight_total = Double.parseDouble(df.format(weight_temp/10));
					     if (Double.parseDouble(df.format(weight_total)) < 0) {
					    	 res.setCoreData(0);
					     } else {
						  res.setCoreData(Double.parseDouble(df.format(weight_total)));
					     }
					}
					else if("cl_event_ladrip_status".equals(res.getCmd()))
					{
						//c6:be:84:00:01:15,00000277,Ladrip,offline
 						String[] deviceArray = res.getData().split(",");
						res.setDeviceNum(deviceArray[1]);
						res.setDeviceModel(deviceArray[2]);
						if("online".equals(deviceArray[3]))
						{	
						    res.setDeviceLinkStatus((int)1);
						} else if("offline".equals(deviceArray[3]))
						{	
						    res.setDeviceLinkStatus((int)-1);
						}
						else
						{
							res.setDeviceLinkStatus((int)0);	
						}
					}
					else if("cl_event_ladrip_power".equals(res.getCmd()))
					{
						res.setDeviceRestPower(Integer.parseInt(res.getData().substring(res.getData().indexOf(',')+1)));
					}
					
					else if("cl_ack_get_bbst_ble_info".equals(res.getCmd()))
					{
						System.out.println("cl_ack_get_bbst_ble_info....all devices info:::" + res.getData());
						
						String[] bbstblerecordArray = res.getData().split(";");
						
						for (int j = 1; j < bbstblerecordArray.length; j++)
						{
							FlyoverClientResult resbbstbletemp = new FlyoverClientResult();
							
							resbbstbletemp.setFlyoverMacAddress(bbstblerecordArray[0].split(",")[1]);
							resbbstbletemp.setDeviceModel(bbstblerecordArray[j].split(",")[0]);
							resbbstbletemp.setBtAddress(bbstblerecordArray[j].split(",")[1]);
							resbbstbletemp.setDeviceNum(bbstblerecordArray[j].split(",")[2]);
							resbbstbletemp.setDeviceLinkStatus(Integer.parseInt(bbstblerecordArray[j].split(",")[3]));
							resbbstbletemp.setDateTime(new Date().getTime());
							
							result.add(resbbstbletemp);
							System.out.println("cl_ack_get_bbst_ble_info....:::" +j+ bbstblerecordArray[j]);
						}
						
						
						return result;
						
					}
					else if("cl_ack_get_bbst_info".equals(res.getCmd()))
					{
						String[] bbstrecordArray = res.getData().split(";");
						
						for (int j = 0; j < bbstrecordArray.length; j++)
						{
							FlyoverClientResult resbbsttemp = new FlyoverClientResult();
							resbbsttemp.setFlyoverModel(bbstrecordArray[j].split(",")[0]);
							resbbsttemp.setFlyoverMacAddress(bbstrecordArray[j].split(",")[1]);
							resbbsttemp.setFlyoverNum(bbstrecordArray[j].split(",")[2]);
							resbbsttemp.setFlyoverStatus(Integer.parseInt(bbstrecordArray[j].split(",")[3]));
							System.out.println("******"+resbbsttemp.getFlyoverMacAddress());
							result.add(resbbsttemp);	
						}
						System.out.println("=====2******=========>>>....:::" +result );
						
						return result;
					}
					else if("cl_event_bbst_connected".equals(res.getCmd()))
					{
						String[] newbbstrecordArray = res.getData().split(",");
						
						res.setFlyoverModel(newbbstrecordArray[0]);
						res.setFlyoverMacAddress(newbbstrecordArray[1]);
						res.setFlyoverNum(newbbstrecordArray[2]);
						res.setFlyoverStatus(Integer.parseInt(newbbstrecordArray[3]));
						
					}
					else if("cl_event_bbst_disconnected".equals(res.getCmd()))
					{
						String[] disconnectedbbstrecordArray = res.getData().split(",");
						res.setFlyoverMacAddress(disconnectedbbstrecordArray[0]);
					}
					else if("cl_event_ble_connected".equals(res.getCmd()))
					{
						String[] connectmodifyedblerecordArray = res.getData().split(",");
						res.setDeviceModel(connectmodifyedblerecordArray[0]);
						res.setBtAddress(connectmodifyedblerecordArray[1]);
						res.setDeviceNum(connectmodifyedblerecordArray[2]);
						res.setDeviceLinkStatus(Integer.parseInt(connectmodifyedblerecordArray[3]));
						res.setFlyoverMacAddress(connectmodifyedblerecordArray[4]);
					}
					else if ("cl_event_ladrip_motion".equals(res.getCmd())) 
					{
						String[] disconnectedbbstrecordArray = res.getData().split(",");
						res.setMotion(disconnectedbbstrecordArray[1]);
					} else if("cl_event_l_heartrate_key".equals(res.getCmd())){
						res.setDataType("location_key");
						System.out.println("-------cl_event_l_heartrate_key--------------------->>"+res.getData());
					}else if("cl_event_l_heartrate_status".equals(res.getCmd())){
					/*	xx:xx:xx:xx:xx:xx,online
						xx:xx:xx:xx:xx:xx,offline
						xx:xx:xx:xx:xx:xx,StartMonitoring
						xx:xx:xx:xx:xx:xx,StopMonitoring*/
						String[] statusArray = res.getData().split(",");
						if("online".equals(statusArray[1]))
						{
							res.setDeviceLinkStatus((int)1);
						} else if("offline".equals(statusArray[1]))
						{
							res.setDeviceLinkStatus((int)0);
						}
						else if("StartMonitoring".equals(statusArray[1]))
						{
							res.setDeviceLinkStatus((int)2);
						}else if("StopMonitoring".equals(statusArray[1]))
						{
							res.setDeviceLinkStatus((int)3);
						}

						res.setDataType("heartrate_status");

					}else if("cl_event_l_heartrate_data".equals(res.getCmd())){
							//c6:be:84:00:00:31,063,180656200
						String[] heartrateArray = res.getData().split(",");
						res.setCoreData(Double.parseDouble(heartrateArray[1]));
						res.setDateTime(DateUtil.hmsToTimemillis(heartrateArray[2]));
						res.setDataType("heartrate_data");
					}else if("cl_event_l_location_key".equals(res.getCmd())){
						res.setDataType("location_key");
						System.out.println("-------cl_event_l_location_key--------------------->>"+res.getData());
					}else if("cl_event_l_location_status".equals(res.getCmd())){
						//c6:be:84:00:00:31,online
						String[] statusArray = res.getData().split(",");
						if("online".equals(statusArray[1]))
						{
							res.setDeviceLinkStatus((int)1);
						} else //if("offline".equals(statusArray[1]))
						{
							res.setDeviceLinkStatus((int)0);
						}
						res.setDataType("location_status");
					}else if("cl_event_l_thermometer_key".equals(res.getCmd())){
						res.setDataType("thermometer_key");
						System.out.println("-------cl_event_l_thermometer_key--------------------->>"+res.getData());
					}else if("cl_event_l_thermometer_status".equals(res.getCmd())){
							//c6:be:84:00:00:31,online
						String[] statusArray = res.getData().split(",");
						if("online".equals(statusArray[1]))
						{
							res.setDeviceLinkStatus((int)1);
						} else if("offline".equals(statusArray[1]))
						{
							res.setDeviceLinkStatus((int)0);
						}
						else if("StartMonitoring".equals(statusArray[1]))
						{
							res.setDeviceLinkStatus((int)2);
						}else if("StopMonitoring".equals(statusArray[1]))
						{
							res.setDeviceLinkStatus((int)3);
						}
						res.setDataType("thermometer_status");
					}else if("cl_event_l_thermometer_data".equals(res.getCmd())){
						//c6:be:84:00:00:31,03721,180656200
						String[] heartrateArray = res.getData().split(",");
						DecimalFormat df = new DecimalFormat("0.00");
						double coreData = Double.parseDouble(df.format(Double.parseDouble(heartrateArray[1])/100));
						if (Double.parseDouble(df.format(coreData)) < 0) {
							res.setCoreData(0);
						} else {
							res.setCoreData(Double.parseDouble(df.format(coreData)));
						}
						res.setDateTime(DateUtil.hmsToTimemillis(heartrateArray[2]));
						res.setDataType("thermometer_data");
					}
				}
				System.out.println("数据信息>>>>>>>" + res.toString());
				result.add(res);
			}
		}
		
		return result;
	}
}
