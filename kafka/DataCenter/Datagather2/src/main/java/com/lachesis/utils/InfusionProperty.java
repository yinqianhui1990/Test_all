/**
 * 
 */
package com.lachesis.utils;

import org.springframework.stereotype.Component;

/**
 * @author tao.xiong
 * @date 2015年9月17日 下午3:44:07
 */
@Component
public class InfusionProperty {

	private boolean gatherDataSwitch; // 是否开启收集基础重量数据, true:打开

	public boolean isGatherDataSwitch() {
		return gatherDataSwitch;
	}

	public void setGatherDataSwitch(boolean gatherDataSwitch) {
		this.gatherDataSwitch = gatherDataSwitch;
	}
}
