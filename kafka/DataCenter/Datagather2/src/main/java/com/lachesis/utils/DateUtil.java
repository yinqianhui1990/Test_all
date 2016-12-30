package com.lachesis.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/***
 * 
 * 日期相关工具类
 *
 * @ClassName: DateUtil
 * @author yuliang.xu
 * @date 2015年4月30日 下午6:08:09
 *
 * @see DateUtils
 * @see DateFormatUtils
 */
public class DateUtil {

	private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);

	private static final Pattern ymdPattern = Pattern
			.compile("\\d{4}-\\d{2}-\\d{2}");

	/** 一周的天数 */
	public static final int DAY_PER_WEEK = Calendar.DAY_OF_WEEK;
	/** 一月的天数 */
	public static final int DAY_PER_MONTH = 30;
	/** 一年的天数 */
	public static final int DAY_PER_YEAR = 365;
	/** 起始日期时间格式 */
	public static final String START_MIN_TIMES = ":00:00";
	public static final String START_TIMES = " 00" + START_MIN_TIMES;
	/** 结束日期时间格式 */
	public static final String END_MIN_TIMES = ":59:59";
	public static final String END_TIMES = " 23" + END_MIN_TIMES;

	/** format : yyyy-MM-dd HH:mm:ss */
	public static final java.text.DateFormat FORMAT_FULL = new SimpleDateFormat(
			DateFormat.FULL.getFormatName());
	/** format : yyyy-MM-dd */
	public static final java.text.DateFormat FORMAT_YMD = new SimpleDateFormat(
			DateFormat.YMD.getFormatName());

	/***
	 * 格式化时间到指定的格式
	 * 
	 * @param date
	 * @param format
	 * @return String date string
	 */
	public static String format(Date date, DateFormat format) {
		if (date == null) {
			return null;
		}
		return DateFormatUtils.format(date, format.getFormatName());
	}
	
	/**
	 * 解析蓝桥时间数据专用
	 * @param hms
	 * @return
	 */
	public static long hmsToTimemillis(String hms){
		String dateString = format(new Date(), DateFormat.YMD);
		StringBuffer sbBuffer = new StringBuffer().append(dateString).append(" ");
		sbBuffer.append(hms.substring(0, 2)).append(":");
		sbBuffer.append(hms.substring(2, 4)).append(":");
		sbBuffer.append(hms.substring(4, 6));
		Date date = parse(sbBuffer.toString());
		return date.getTime() + Long.parseLong(hms.substring(6));
	}
	
	/***
	 * 格式化时间到指定的格式
	 * 
	 * @param timeMillis
	 *            时间毫秒数
	 * @param format
	 * @return String date string
	 */
	public static String format(long timeMillis, DateFormat format) {
		return format(new Date(timeMillis), format);
	}
	
	/**
	 * 毫秒转化为Date类型
	 * @param timeMillis 毫秒
	 * @param format
	 * @return
	 */
	public static Date formatToDate(long timeMillis, DateFormat format){
		return parse(format(timeMillis,format));
	}
	
	/***
	 * 将时间类型的字符串转换为format格式的字符串
	 * 
	 * @param date
	 * @param format
	 * @return String date string
	 */
	public static String format(String date, DateFormat oldFormat,
			DateFormat newFormat) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		return format(parse(date, oldFormat), newFormat);
	}

	/***
	 * 格式化当前时间到指定的格式
	 * 
	 * @param format
	 * @return String date string
	 */
	public static String format(DateFormat format) {
		return format(new Date(), format);
	}

	/***
	 * 格式化当前时间为 yyyy-MM-dd HH:mm:ss 的格式
	 * 
	 * @return String date string
	 */
	public static String format() {
		return format(DateFormat.FULL);
	}

	/***
	 * 格式化字符串为yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss的时间
	 * 
	 * @param date
	 *            yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss 格式的字符串
	 * @return Date 时间
	 */
	public static Date parse(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		return parse(
				date,
				new String[] { DateFormat.FULL.getFormatName(),
						DateFormat.YMD.getFormatName(),
						DateFormat.YMDHM.getFormatName(),
						DateFormat.HM.getFormatName(),
						DateFormat.HMS.getFormatName(), });
	}

	/***
	 * 格式化字符串到指定格式的时间
	 * 
	 * @param date
	 * @param format
	 * @return Date 时间
	 */
	public static Date parse(String date, DateFormat format) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		return parse(date, new String[] { format.getFormatName() });
	}

	private static Date parse(String date, String[] parsePatterns) {
		try {
			return DateUtils.parseDate(date, parsePatterns);
		} catch (ParseException e) {
			LOG.error("String parse to Date error !", e);
			return null;
		}
	}

	/***
	 * 当前天最小时间点 如： 2015-05-04 00:00:00
	 * 
	 * @return Date 当前天最小时间点
	 */
	public static Date getCurDateWithMinTime() {
		return getDateWithMinTime((Date) null);
	}

	/***
	 * 获取某一天最小时间点 如： 2015-05-04 00:00:00
	 * 
	 * @param date
	 *            2015-05-04
	 * @return Date 获取某一天最小时间点
	 */
	public static Date getDateWithMinTime(Date date) {
		return getDateWithMinTime(date, 0);
	}

	public static Date getDateWithMinTime(Date date, int hour) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
		}
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/***
	 * 获取某一天最小时间点 如： 2015-05-04 00:00:00
	 * 
	 * @param date
	 *            2015-05-04
	 * @return Date 获取某一天最小时间点
	 */
	public static Date getDateWithMinTime(String date) {
		return getDateWithMinTime(parse(date));
	}

	/***
	 * 当前天最大时间点 如： 2015-05-04 23:59:59
	 * 
	 * @return Date 当前天最大时间点
	 */
	public static Date getCurDateWithMaxTime() {
		return getDateWithMaxTime((Date) null);
	}

	/***
	 * 获取某一天最大时间点 如： 2015-05-04 00:00:00
	 * 
	 * @param date
	 *            2015-05-04
	 * @return Date 获取某一天最大时间点
	 */
	public static Date getDateWithMaxTime(Date date) {
		return getDateWithMaxTime(date, 23);
	}

	public static Date getDateWithMaxTime(Date date, int hour) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
		}
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/***
	 * 获取某一天最大时间点 如： 2015-05-04 00:00:00
	 * 
	 * @param date
	 *            2015-05-04
	 * @return Date 获取某一天最大时间点
	 */
	public static Date getDateWithMaxTime(String date) {
		return getDateWithMaxTime(parse(date));
	}

	/**
	 * 截取指定位数长度的时间
	 * 
	 * @param fullDateStr
	 * @return
	 */
	public static String truncateDateString(String date, DateFormat format) {
		if (StringUtils.isBlank(date)) {
			return null;
		}

		int length = format.getFormatName().length();
		return date.length() >= length ? date.substring(0, length) : date;
	}

	/**
	 * 计算两个日期之间相差多少天
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int calDatePoor(Date startDate, Date endDate) {
		if (endDate == null || startDate == null) {
			return 0;
		}
		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - startDate.getTime();

		return (int) (diff / DateUtils.MILLIS_PER_DAY);
	}

	/***
	 * 将时间的时、分、秒设置为0
	 *
	 * @param date
	 * @return
	 */
	public static Date setDateToDay(Date date) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
		}
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取下一天的零点时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date setNextDayToDate(Date date) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
		}
		c.add(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 计算两个日期之间相差多少天
	 * 
	 * @param endDate
	 * @param startDate
	 * @return
	 */
	public static int calDatePoor(String startDate, String endDate) {
		if (StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)) {
			return 0;
		}

		return calDatePoor(parse(startDate, DateFormat.YMD),
				parse(endDate, DateFormat.YMD));
	}

	/**
	 * 获取一天的0点和23点59分的时间 如果传入null，则两个端点时间都为null
	 * 
	 * @param day
	 *            : yyyy-MM-dd
	 * @return
	 */
	public static String[] getTimeEndPoints(String day) {
		String[] endPoints = new String[2];
		if (day != null && ymdPattern.matcher(day).matches()) {
			endPoints[0] = day + " 00:00:00";
			endPoints[1] = day + " 23:59:59";
		}
		return endPoints;
	}

	/**
	 * 转为中文日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getChineseHourMinute(String date) {
		if (date == null) {
			return null;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parse(date));
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		StringBuilder sb = new StringBuilder();
		sb.append(NumberUtil.convertNumberToChinese(hour));

		sb.append("时");
		sb.append(NumberUtil.convertNumberToChinese(minute));
		sb.append("分");

		return sb.toString();
	}

	public static Date clearMilliSecond(Date date) {
		if (date == null) {
			return null;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 比较两个日期，startDate早于endDate返回true，反之,false
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean before(Date startDate, Date endDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		long startL = cal.getTimeInMillis();
		cal.setTime(endDate);
		long endL = cal.getTimeInMillis();

		if (startL >= endL) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 获取查询日期区间：当前零点和下一天零点
	 * @param curDate
	 * @return
	 */
	public static Date[] getQueryRegionDates(Date curDate) {
		Date[] dates = new Date[2];
		if (curDate == null) {
			curDate = new Date();
		}

		dates[0] = setDateToDay(curDate);
		dates[1] = setNextDayToDate(curDate);
		return dates;
	}
	
	/**
	 * 当前时间更新指定时间
	 * @param curDate
	 * @param hourCount
	 * @return
	 */
	public static Date getDateByHour(Date curDate,int hourCount){
		Calendar c = Calendar.getInstance();
		if (curDate == null) {
			c.setTime(new Date());
		}else{
			c.setTime(curDate);
		}
		c.add(Calendar.HOUR_OF_DAY, hourCount);
		return c.getTime();
		
	}
	
	/**
	 * 获取当前时间的前后指定小时区间
	 * @param curDate
	 * @return
	 */
	public static Date[] getQueryHourRegionDates(Date curDate,int startHourCount,int endHourCount){
		Date[] dates = new Date[2];
		if (curDate == null) {
			curDate = new Date();
		}

		dates[0] = getDateByHour(curDate,startHourCount);
		dates[1] = getDateByHour(curDate,endHourCount);
		return dates;
	}
	
	private DateUtil() {
	}

	public enum DateFormat {
		YMDHMSS("yyyy-MM-dd HH:mm:ss.sss"), YMD("yyyy-MM-dd"), // e.g.
																// 2012-11-01
		FULL("yyyy-MM-dd HH:mm:ss"), // e.g. 2012-11-01 23:12:15(24小时制)
		YMDHM("yyyy-MM-dd HH:mm"), // e.g. 2012-11-01 23:12(24小时制)
		HMS("HH:mm:ss"), HM("HH:mm");

		private String format;

		private DateFormat(String format) {
			this.format = format;
		}

		public String getFormatName() {
			return format;
		}
	}
	
}
