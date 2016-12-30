package com.test.model;

import java.math.BigDecimal;
import java.util.Date;

public class InmPerBagInfo {
    private Long seqId;

    private String infusionBagId;

    private String macAddress;

    private Date beginTime;

    private Date endTime;

    private BigDecimal actTotalCapacity;

    private BigDecimal actTotalWeight;

    private BigDecimal stdTotalCapacity;

    private BigDecimal stdTotalWeight;

    private String infusionStatus;

    private String deptCode;

    private String deptName;

    private String orderNo;

    private Integer orderCount;

    private Integer orderExecIndex;

    private String material;

    private BigDecimal tare;

    private BigDecimal netWeight;

    private BigDecimal specCapacity;

    private Date takeawayTime;

    private Date createTime;

    private String bedCode;

    private Date latestSentTime;

    private Integer latestDropSpeed;

    private BigDecimal latestRestWeight;

    private BigDecimal latestRestCapacity;

    private Integer latestInmPercent;

    private Integer latestRestTime;

    private Integer timeAlarmStatus;

    private Integer capacityAlarmStatus;

    private Integer speedAlarmStatus;

    private Integer warningVolume;

    private String usage;

    private String frequency;

    private String orderBarcode;

    private String patId;

    private String patName;

    private String patInhospNo;

    private String patSex;

    private Integer patAge;

    private String patBarcode;

    private String remark;

    private String dutyNurseCode;

    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

    public String getInfusionBagId() {
        return infusionBagId;
    }

    public void setInfusionBagId(String infusionBagId) {
        this.infusionBagId = infusionBagId == null ? null : infusionBagId.trim();
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress == null ? null : macAddress.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getActTotalCapacity() {
        return actTotalCapacity;
    }

    public void setActTotalCapacity(BigDecimal actTotalCapacity) {
        this.actTotalCapacity = actTotalCapacity;
    }

    public BigDecimal getActTotalWeight() {
        return actTotalWeight;
    }

    public void setActTotalWeight(BigDecimal actTotalWeight) {
        this.actTotalWeight = actTotalWeight;
    }

    public BigDecimal getStdTotalCapacity() {
        return stdTotalCapacity;
    }

    public void setStdTotalCapacity(BigDecimal stdTotalCapacity) {
        this.stdTotalCapacity = stdTotalCapacity;
    }

    public BigDecimal getStdTotalWeight() {
        return stdTotalWeight;
    }

    public void setStdTotalWeight(BigDecimal stdTotalWeight) {
        this.stdTotalWeight = stdTotalWeight;
    }

    public String getInfusionStatus() {
        return infusionStatus;
    }

    public void setInfusionStatus(String infusionStatus) {
        this.infusionStatus = infusionStatus == null ? null : infusionStatus.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getOrderExecIndex() {
        return orderExecIndex;
    }

    public void setOrderExecIndex(Integer orderExecIndex) {
        this.orderExecIndex = orderExecIndex;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public BigDecimal getTare() {
        return tare;
    }

    public void setTare(BigDecimal tare) {
        this.tare = tare;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getSpecCapacity() {
        return specCapacity;
    }

    public void setSpecCapacity(BigDecimal specCapacity) {
        this.specCapacity = specCapacity;
    }

    public Date getTakeawayTime() {
        return takeawayTime;
    }

    public void setTakeawayTime(Date takeawayTime) {
        this.takeawayTime = takeawayTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBedCode() {
        return bedCode;
    }

    public void setBedCode(String bedCode) {
        this.bedCode = bedCode == null ? null : bedCode.trim();
    }

    public Date getLatestSentTime() {
        return latestSentTime;
    }

    public void setLatestSentTime(Date latestSentTime) {
        this.latestSentTime = latestSentTime;
    }

    public Integer getLatestDropSpeed() {
        return latestDropSpeed;
    }

    public void setLatestDropSpeed(Integer latestDropSpeed) {
        this.latestDropSpeed = latestDropSpeed;
    }

    public BigDecimal getLatestRestWeight() {
        return latestRestWeight;
    }

    public void setLatestRestWeight(BigDecimal latestRestWeight) {
        this.latestRestWeight = latestRestWeight;
    }

    public BigDecimal getLatestRestCapacity() {
        return latestRestCapacity;
    }

    public void setLatestRestCapacity(BigDecimal latestRestCapacity) {
        this.latestRestCapacity = latestRestCapacity;
    }

    public Integer getLatestInmPercent() {
        return latestInmPercent;
    }

    public void setLatestInmPercent(Integer latestInmPercent) {
        this.latestInmPercent = latestInmPercent;
    }

    public Integer getLatestRestTime() {
        return latestRestTime;
    }

    public void setLatestRestTime(Integer latestRestTime) {
        this.latestRestTime = latestRestTime;
    }

    public Integer getTimeAlarmStatus() {
        return timeAlarmStatus;
    }

    public void setTimeAlarmStatus(Integer timeAlarmStatus) {
        this.timeAlarmStatus = timeAlarmStatus;
    }

    public Integer getCapacityAlarmStatus() {
        return capacityAlarmStatus;
    }

    public void setCapacityAlarmStatus(Integer capacityAlarmStatus) {
        this.capacityAlarmStatus = capacityAlarmStatus;
    }

    public Integer getSpeedAlarmStatus() {
        return speedAlarmStatus;
    }

    public void setSpeedAlarmStatus(Integer speedAlarmStatus) {
        this.speedAlarmStatus = speedAlarmStatus;
    }

    public Integer getWarningVolume() {
        return warningVolume;
    }

    public void setWarningVolume(Integer warningVolume) {
        this.warningVolume = warningVolume;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage == null ? null : usage.trim();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public String getOrderBarcode() {
        return orderBarcode;
    }

    public void setOrderBarcode(String orderBarcode) {
        this.orderBarcode = orderBarcode == null ? null : orderBarcode.trim();
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId == null ? null : patId.trim();
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName == null ? null : patName.trim();
    }

    public String getPatInhospNo() {
        return patInhospNo;
    }

    public void setPatInhospNo(String patInhospNo) {
        this.patInhospNo = patInhospNo == null ? null : patInhospNo.trim();
    }

    public String getPatSex() {
        return patSex;
    }

    public void setPatSex(String patSex) {
        this.patSex = patSex == null ? null : patSex.trim();
    }

    public Integer getPatAge() {
        return patAge;
    }

    public void setPatAge(Integer patAge) {
        this.patAge = patAge;
    }

    public String getPatBarcode() {
        return patBarcode;
    }

    public void setPatBarcode(String patBarcode) {
        this.patBarcode = patBarcode == null ? null : patBarcode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDutyNurseCode() {
        return dutyNurseCode;
    }

    public void setDutyNurseCode(String dutyNurseCode) {
        this.dutyNurseCode = dutyNurseCode == null ? null : dutyNurseCode.trim();
    }
}