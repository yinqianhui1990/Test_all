package com.lachesis.flyover.client;


import com.lachesis.utils.DateUtil;

public class FlyoverClientResult {
	private String btAddress;  //MAC地址
	private int dataLength;    //数据长度
	private int state;         //状态   0为正常 ，其他为不正常
	private long dateTime;     //数据时间
	private String data;       //数据
	private String cmd;
	private double coreData;    //核心数据，有可能是重量/心率/位置/体温等等
	private int deviceLinkStatus; //状态1 在线连接状态，状态0，离线断连状态 -1 人为断开
	private int deviceRestPower;     //输液监测器剩余电量
	private String deviceModel;   //设备名称
	private String deviceNum;    //设备号
	private String flyovermodel;       //蓝桥型号
	private String flyovermacaddress;       //蓝桥物理地址
	private String flyovernum;       //蓝桥系列号
	private int flyoverStatus;   //蓝桥在线状态
	private String motion;   //检测器是否晃动 0：不晃动，1：晃动
	private long createTime;//进入redis队列时间
	private String dataType;   //数据类型--心率，体温，位置之类

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getFlyovermodel() {
		return flyovermodel;
	}

	public void setFlyovermodel(String flyovermodel) {
		this.flyovermodel = flyovermodel;
	}

	/**
	 * toString
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		if(0 != dateTime){
			sb.append(DateUtil.format(dateTime, DateUtil.DateFormat.YMDHMSS) + " ");
		}
		sb.append("BuleTooth MAC:" + this.btAddress + ",");
		sb.append("data:").append(this.data).append(",");
		sb.append("coreData:").append(this.coreData).append(",");
		sb.append("deviceLinkStatus:").append(this.deviceLinkStatus).append(",");
		sb.append("deviceRestPower:").append(this.deviceRestPower).append(",");
		sb.append("deviceModel:").append(this.deviceModel).append(",");
		sb.append("deviceNum:").append(this.deviceNum).append(",");
		sb.append("flyovermodel:").append(this.flyovermodel).append(",");
		sb.append("flyovermacaddress:").append(this.flyovermacaddress).append(",");
		sb.append("flyovernum:").append(this.flyovernum).append(",");
		sb.append("motion:").append(this.motion).append(",");
		sb.append("dataType:").append(this.dataType);
		
		return sb.toString();
	}
	
	public long getDateTime() {
		return dateTime;
	}


	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}


	public String getBtAddress() {
		return btAddress;
	}

	public void setBtAddress(String btAddress) {
		this.btAddress = btAddress;
	}

	public int getDataLength() {
		return dataLength;
	}

	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}


	public double getCoreData() {
		return coreData;
	}

	public void setCoreData(double coreData) {
		this.coreData = coreData;
	}

	public int getDeviceLinkStatus() {
		return deviceLinkStatus;
	}

	public void setDeviceLinkStatus(int deviceLinkStatus) {
		this.deviceLinkStatus = deviceLinkStatus;
	}
	
	public int getDeviceRestPower() {
		return deviceRestPower;
	}

	public void setDeviceRestPower(int deviceRestPower) {
		this.deviceRestPower = deviceRestPower;
	}
	
	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	
	public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}
	
	public String getFlyoverModel() {
		return flyovermodel;
	}

	public void setFlyoverModel(String flyovermodel) {
		this.flyovermodel = flyovermodel;
	}
	
	public String getFlyoverMacAddress() {
		return flyovermacaddress;
	}

	public void setFlyoverMacAddress(String flyovermacaddress) {
		this.flyovermacaddress = flyovermacaddress;
	}
	
	public String getFlyoverNum() {
		return flyovernum;
	}

	public void setFlyoverNum(String flyovernum) {
		this.flyovernum = flyovernum;
	}
	
	public int getFlyoverStatus() {
		return flyoverStatus;
	}

	public void setFlyoverStatus(int flyoverStatus) {
		this.flyoverStatus = flyoverStatus;
	}

	public String getMotion() {
		return motion;
	}

	public void setMotion(String motion) {
		this.motion = motion;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
}
