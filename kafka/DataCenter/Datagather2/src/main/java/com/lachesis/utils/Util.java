/**
 * 
 */
package com.lachesis.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tao.xiong
 * @date 2015年9月8日 下午1:27:15
 */
public class Util {
	
	/**
	 * 
	 * @author tao.xiong
	 * @date 2015年9月8日 下午1:46:12 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format){
		if(!Util.isEmptyString(format) && (null != date)){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}else{
			return "";
		}
	}
	
	/**
	 * 
	 * @author tao.xiong
	 * @date 2015年9月8日 下午1:39:23 
	 * @param str
	 * @return true表示空字符串， false表示非空
	 */
	public static boolean isEmptyString(String str){
		if((null != str) && (!str.trim().equals(""))){
			return false;
		}
		return true;
	}
	
	/**
	 * 将液体重量转换为容量
	 * @author tao.xiong
	 * @date 2015年9月21日 下午1:23:44 
	 * @param weight 单位：克
	 * @param density 密度 单位 ：克/毫升
	 * @return 毫升
	 */
	public static double convertWeiToCap(double weight, double density){
		DecimalFormat df = new DecimalFormat("0.0");
		double cap= Double.parseDouble(df.format(weight/density));
		return cap;
	}

}
