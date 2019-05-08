package com.example.myapplication;

import android.annotation.SuppressLint;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@SuppressLint("SimpleDateFormat")
public class DateUtil {

	/**
	 * 获取当前日期
	 * @return
	 */
	public static String getNowDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		String str = formatter.format(curDate);
		return str;
	}
	public static Date getNowDateIsDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		return curDate;
	}
	public static String getNowDates() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		String str = formatter.format(curDate);
		return str;
	}
	public static String getNowDates(String type) {
		SimpleDateFormat formatter = new SimpleDateFormat(type);
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		String str = formatter.format(curDate);
		return str;
	}
	/**
	 * 调此方法输入所要转换的时间输入例如（"2019-05-09 09:57:07"）返回1557367027
	 */
	public static String dataOne(String time) {
		SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
		Date date;
		String times = null;
		try {
			date = sdr.parse(time);
			long l = date.getTime();
			String stf = String.valueOf(l);
			times = stf.substring(0, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return times;
	}
	/**
	 * 获取当前日期
	 * @return
	 */
	public static String getNowDateMinute() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		String str = formatter.format(curDate);
		return str;
	}
	public static String getNowDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		String str = formatter.format(curDate);
		return str;
	}

	public static String getNowDateTimeHM() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		String str = formatter.format(curDate);
		return str;
	}
	/**
	 * 获取当前格式化后的日期
	 * @return
	 */
	public static String getFormatNowDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		String str = formatter.format(curDate);
		return str;
	}
	
	/**
	 * 计算过来的时间是今天还是明天或是后天
	 * @param
	 * @return
	 */
	public static String getDateJT(String datestr) {
		String today = null;
		try {
			Date flyDate = new SimpleDateFormat("yyyy-MM-dd").parse(datestr);
			Date nowDate = new Date(System.currentTimeMillis());
			
			 Calendar now = Calendar.getInstance();
			 now.setTime(nowDate);
			 Calendar old = Calendar.getInstance();
			 old.setTime(flyDate);
			 
		     int nowyear=now.get(Calendar.YEAR);
		     int nowmonth=now.get(Calendar.MONTH)+1;
		     int nowday=now.get(Calendar.DAY_OF_MONTH);
		     
		     int oldyear=old.get(Calendar.YEAR);
		     int oldmonth=old.get(Calendar.MONTH)+1;
		     int oldday=old.get(Calendar.DAY_OF_MONTH);
		     
		     if (nowyear == oldyear && nowmonth == oldmonth) {
				if (oldday - nowday == 0) {
					today = "今天";
				}else if(oldday - nowday == 1)
				{
					today = "明天";
				}else if(oldday - nowday == 2)
				{
					today = "后天";
				}else {
					today = nowyear + "年";
				}
			}else 
			{
				today = nowyear + "年";
			}
		     
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return today;
	}
	
	/**
	 * 获取当前时间后几天的日期
	 * @param day
	 * @return
	 */
	public static String getDayDate(int day) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date curDate = new Date(System.currentTimeMillis()+day*24*60*60*1000);//获取当前时间
		String str = formatter.format(curDate);
		return str;
	}
	public static Date getDayDateIsDate(int day) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date curDate = new Date(System.currentTimeMillis()+day*24*60*60*1000);//获取当前时间
		return curDate;
	}

	/**
	 * 获取当前时间格式化后的后几天的日期
	 * @param day
	 * @return
	 */
	public static String getFormatDayDate(int day) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
		Date curDate = new Date(System.currentTimeMillis()+day*24*60*60*1000);//获取当前时间
		String str = formatter.format(curDate);
		return str;
	}
	
	/**
	 * 把选择的日期格式化一下哈
	 * @param date
	 * @return
	 */
	public static String getflyFormatDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
		Date curDate = null;
		String str="";
		if (date!=null){
			try {
				curDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e) {

				e.printStackTrace();
			}
			str = formatter.format(curDate);
		}
		return str;
	}
	public static String getTransitionDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date curDate = null;
		String str="";
		if (date!=null){
			try {
				curDate = new SimpleDateFormat("MM月dd日").parse(date);
			} catch (ParseException e) {

				e.printStackTrace();
			}
			str = formatter.format(curDate);
		}
		return str;
	}
	/**
	 * 将时间转换成float型
	 * @param timestr
	 * @return
	 */
	public static float getTimefloat(String timestr) {
		float time = 0;
		if (timestr.length() > 0) {
			String hour = timestr.substring(0, 2);
			String min = timestr.substring(3, 5);
			time = (float) (Float.valueOf(hour).floatValue() + Float.valueOf(min).floatValue() / 60.0);
		}
		return time;
	}

	/**
	 * 计算距离还剩多长时间 小时 分钟
	 * @param datestr
	 * @return
	 */
	public static String gettoflytime(String datestr) {
		String toflytime = null;
		try {
			Date flyDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(datestr);
			Date nowDate = new Date(System.currentTimeMillis());
			
			long beginTime = flyDate.getTime(); 
			long endTime2 = nowDate.getTime(); 
			
			long time = beginTime - endTime2;
			
			
			double hourd = (double)(time / (1000.0 * 60.0 * 60.0 ));
			int hour = (int)hourd;

			int min = (int)(hourd - hour) * 60;
			
			if (hour <= 0 && min <= 0) {
				toflytime = null;
			}else
			{
				toflytime = hour + "小时" + min + "分钟";
			}
			
			
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return toflytime;
	}
	
	/**
	 * 计算距离还剩多长时间 天
	 * @param datestr
	 * @return
	 */
	public static int isbeforeDay(String datestr) {
		int day = 0;
		try {
			Date flyDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(datestr);
			Date nowDate = new Date(System.currentTimeMillis());
			
			long beginTime = flyDate.getTime(); 
			long endTime2 = nowDate.getTime(); 
			
			long time = beginTime - endTime2;
			
			day = (int)(time / (1000.0 * 60.0 * 60.0 * 24));

		} catch (ParseException e) {

			e.printStackTrace();
		}
		return day;
	}
	
	/**
	 * 判断是否是有效的出生日期
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static boolean isYXdate(int year,int month,int day) {
		Calendar calendar= Calendar.getInstance();
        int dyear=calendar.get(Calendar.YEAR)-2;
        int ddayOfMonth=calendar.get(Calendar.DAY_OF_MONTH)-1;
        
        if (year > dyear && day > ddayOfMonth) {
			return false;
		}else if(year == dyear && day > ddayOfMonth)
		{
			return false;
		}else if(year > dyear && day == ddayOfMonth)
		{
			return false;
		}
        
		return true;
	}
	
	/**
	 * 将2014-01-01转换成2014年01月01日
	 * @param date
	 * @return
	 */
	public static String formatDateCN(String date) {
		String resultDate = null;
		try {
			Date yDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
			resultDate = formatter.format(yDate);

		} catch (ParseException e) {

			e.printStackTrace();
		}
		return resultDate;
	}
	/**
	 * 将2014-01转换成2014年01月
	 * @param date
	 * @return
	 */
	public static String fromDateYM(String date){
		String resultDate = null;
		try {
			Date yDate = new SimpleDateFormat("yyyy-MM").parse(date);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月");
			resultDate = formatter.format(yDate);

		} catch (ParseException e) {

			e.printStackTrace();
		}
		return resultDate;
	}

	public static String formatDateMonthDay(String date) {
		String resultDate = null;
		try {
			Date yDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
			resultDate = formatter.format(yDate);
			
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return resultDate;
	}
	
	/**
	 * 将2014年01月01日转换成2014-01-01
	 * @param date
	 * @return
	 */
	public static String formatDateEN(String date) {
		String resultDate = null;
		try {
			Date yDate = new SimpleDateFormat("yyyy年MM月dd日").parse(date);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			resultDate = formatter.format(yDate);
			
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return resultDate;
	}
	
	/**
	 * 输入日期的前一天
	 * @param date
	 * @return
	 */
	public static String preDate(String date) {
		String predate = null;
		try {
			Date yDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(yDate);
			cal.add(Calendar.DATE, -1);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			predate = formatter.format(cal.getTime()); 
//			Log.d("dateutil", "predate = "+predate);
		} catch (Exception e) {

		}
		return predate;
	}
	
	/**
	 * 输入日期的后一天
	 * @param date
	 * @return
	 */
	public static String offDate(String date) {
		String offdate = null;
		try {
			Date yDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(yDate);
			cal.add(Calendar.DATE, 1);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			offdate = formatter.format(cal.getTime());
		} catch (Exception e) {

		}
		return offdate;
	}
	public static String offDate(String date,String time) {
		String offdate = null;
		try {
			Date yDate = new SimpleDateFormat(time).parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(yDate);
			cal.add(Calendar.DATE, 1);
			SimpleDateFormat formatter = new SimpleDateFormat(time);
			offdate = formatter.format(cal.getTime());
		} catch (Exception e) {

		}
		return offdate;
	}
	/**
	 * 判断onedate是否小于twodate
	 * @param onedate
	 * @param twodate
	 * @return
	 */
	public static boolean isCompareDate(String onedate, String twodate){
		boolean iscompare = false;
		try {
			Date one = new SimpleDateFormat("yyyy-MM-dd").parse(onedate);
			Date two = new SimpleDateFormat("yyyy-MM-dd").parse(twodate);
			if (one.getTime() < two.getTime()) {
				iscompare = true;
			}
		} catch (Exception e) {

		}
		return iscompare;
	}

	/**
	 * 判断onedate是否小于twodate
	 * @param onedate
	 * @param twodate
	 * @return
	 */
	public static boolean isCompareDateMinute(String onedate, String twodate){
		boolean iscompare = false;
		try {
			Date one = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(onedate);
			Date two = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(twodate);
			if (one.getTime() < two.getTime()) {
				iscompare = true;
			}
		} catch (Exception e) {

		}
		return iscompare;
	}
	
	/**
	 * 将日期格式转换为字符串
	 * @param date
	 * @return
	 */
	public static String DateToStr(Date date)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = formatter.format(date);
		return strdate;
	}
	
	/**
	 * 将字符串转换为日期格式
	 * @param
	 * @return
	 */
	public static Date StrToDate(String datestr)
	{
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return date;
	}
	


	/**
	* 获取两个日期之间的间隔天数
	* @return
	*/
	public static int getGapCount(Date startDate, Date endDate) {
	        Calendar fromCalendar = Calendar.getInstance();
	        fromCalendar.setTime(startDate);  
	        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
	        fromCalendar.set(Calendar.MINUTE, 0);
	        fromCalendar.set(Calendar.SECOND, 0);
	        fromCalendar.set(Calendar.MILLISECOND, 0);
	  
	        Calendar toCalendar = Calendar.getInstance();
	        toCalendar.setTime(endDate);  
	        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
	        toCalendar.set(Calendar.MINUTE, 0);
	        toCalendar.set(Calendar.SECOND, 0);
	        toCalendar.set(Calendar.MILLISECOND, 0);
	  
	        return (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
	}

	//时间戳转字符串
	public static String getStrTime(String timeStamp){
		String timeString = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long  l = Long.valueOf(timeStamp);
		timeString = sdf.format(new Date(l));//单位秒
		return timeString;
	}

   /***
	* 日期对应的星期
	* **/
   public  static String getWeek(String pTime) {
	   String week = "";
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	   Calendar c = Calendar.getInstance();
	   if (pTime!=null){
		   try {
			   c.setTime(format.parse(pTime));
		   } catch (ParseException e) {
			   e.printStackTrace();
		   }
		   int weekIndex = c.get(Calendar.DAY_OF_WEEK);
		   switch (weekIndex) {
			   case 1:
				   week = "周日";
				   break;
			   case 2:
				   week = "周一";
				   break;
			   case 3:
				   week = "周二";
				   break;
			   case 4:
				   week = "周三";
				   break;
			   case 5:
				   week = "周四";
				   break;
			   case 6:
				   week = "周五";
				   break;
			   case 7:
				   week = "周六";
				   break;
				   default:
				   	break;
		   }
	   }
	   return week;
   }


}
