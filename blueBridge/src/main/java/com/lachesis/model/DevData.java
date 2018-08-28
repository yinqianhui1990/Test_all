package com.lachesis.model;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/8/9.
 */
public class DevData {
    private String macAddress;
    private String bedCode;
    private String deptCode;

    public DevData() {
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getBedCode() {
        return bedCode;
    }

    public void setBedCode(String bedCode) {
        this.bedCode = bedCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
}
