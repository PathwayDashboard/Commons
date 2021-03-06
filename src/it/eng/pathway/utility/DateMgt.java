/*******************************************************************************
 * Copyright 2018 Engineering Ing. Inf. S.p.A.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package it.eng.pathway.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;

public class DateMgt {
	
	private static final String FORMATTER_STRING = "yyyy-MM-dd";
	private static final String ORDINABILE_STRING = "yyyyMMdd";
	private static final String READABLE_STRING = "dd-MM-yyyy HH:mm";
	private static final String TODAY_STRING = "dd-MM-yyyy";
	private static final String HOUR_STRING = "HH:mm";
	
	private static final String ORDINABILE_RANGE_DAYTIME = "yyyyMMddHHmm";
	private static final String ORDINABILE_RANGE_TIME = "HHmm";
	
	/**
	 * 
	 * @return in "dd-MM-yyyy"
	 */
	public static String getToday(){
		Calendar cal=GregorianCalendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(TODAY_STRING);
		return sdf.format(cal.getTime());
	}
	
	/**
	 * 
	 * @return in "dd-MM-yyyy hh:mm";
	 */
	public static String getNow(){
		Calendar cal=new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat(READABLE_STRING);
		return sdf.format(cal.getTime());
	}

	/**
	 * 
	 * @param calendar
	 * @return "hh:mm"
	 */
	public static String getReadableTime(Calendar cal) {
		SimpleDateFormat sdf = new SimpleDateFormat(HOUR_STRING);
		return sdf.format(cal.getTime());
	}
	
	/**
	 * 
	 * @param date
	 * @return "hh:mm"
	 */
	public static String getReadableTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(HOUR_STRING);
		return sdf.format(date);
	}

	
	
	public static Date getDate(String date) {
		ArrayList<String> dateFormats=new ArrayList<String>();
		if (date.indexOf("-")>3){
			dateFormats.add(FORMATTER_STRING);
		}else{
			 dateFormats.add(READABLE_STRING);
			 dateFormats.add(TODAY_STRING);
			 dateFormats.add(HOUR_STRING);
			 dateFormats.add(ORDINABILE_RANGE_DAYTIME);
		}
	    for (String dateFormat : dateFormats) {
	        try {
	            SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
	            Date toRet=sdf.parse(date);
	            return toRet;
	        } catch (ParseException ignore) { }
	    }
		return null;
		
	}
	/**
	 * 
	 * @param start
	 * @param end
	 * @return jodatime - days in the range
	 */
	public static int getDays(String start, String end) {
		return getDays(getDate(start), getDate(end));
//		Date s=getDate(start);
//		Date e=getDate(end);
//		if (s==null || e==null)
//			return -1;
//		DateTime st=new DateTime(s.getTime());
//		DateTime en=new DateTime(e.getTime());
//		
//		int days=Days.daysBetween(st.withTimeAtStartOfDay(), en.withTimeAtStartOfDay()).getDays()+1;
//		
//		return days;
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return jodatime - days in the range
	 */
	public static int getDays(Date start, Date end) {
		if (start==null || end==null)
			return -1;
		DateTime st=new DateTime(start.getTime());
		DateTime en=new DateTime(end.getTime());
		
		int days=Days.daysBetween(st.withTimeAtStartOfDay(), en.withTimeAtStartOfDay()).getDays()+1;
		
		return days;
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return jodatime - hours in the range
	 */
	public static int getHours(Date start, Date end) {
		if (start==null || end==null)
			return -1;
		DateTime st=new DateTime(start.getTime());
		DateTime en=new DateTime(end.getTime());
		
		
		int hours=Hours.hoursBetween(st.withTimeAtStartOfDay(), en.withTimeAtStartOfDay()).getHours();
		
		return hours;
	}
	
	/**
	 * 
	 * @param date
	 * @param start_time
	 * @return "dd-MM-yyyy HH:mm"
	 */
	public static String getReadableDayTime(Date date, String start_time) {
		SimpleDateFormat sdf = new SimpleDateFormat(TODAY_STRING);
		String toRet=sdf.format(date)+" "+ (start_time != null ? start_time : "");
		return toRet;
	}
	/**
	 * 
	 * @param date
	 * @return "yyyyMMdd"
	 */
	public static String getFormattedDateString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(ORDINABILE_STRING);
		String toRet=sdf.format(date);
		return toRet;
	}

	/**
	 * 
	 * @param date
	 * @return "dd-MM-yyyy"
	 */
	public static String getReadableDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(TODAY_STRING);
		String toRet=sdf.format(date);
		return toRet;
	}
	
	/**
	 * 
	 * @param date
	 * @return "dd-MM-yyyy HH:mm"
	 */
	public static String getReadableDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(READABLE_STRING);
		String toRet=sdf.format(date);
		return toRet;
	}

	/**
	 * 
	 * @return yyyyMMdd
	 */
	public static String getComparableDayString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(ORDINABILE_STRING);
		String toRet=sdf.format(date);
		return toRet;
	}
	/**
	 * 
	 * @param date
	 * @return yyyyMMddHHmm
	 */
	public static String getComparableRangeDayTimeString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(ORDINABILE_RANGE_DAYTIME);
		String toRet=sdf.format(date);
		return toRet;
	}
	/**
	 * 
	 * @param date
	 * @return	 HHmm
	 */
	public static String getComparableRangeTimeString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(ORDINABILE_RANGE_TIME);
		String toRet=sdf.format(date);
		return toRet;
	}

	public static int getMinutesBetween(String startTime, String endTime) {
		return getMinutesBetween(getDate(startTime), getDate(endTime));
	}
	
	public static int getMinutesBetween(Date startTime, Date endTime){
		if (startTime==null || endTime==null)
			return -1;
		DateTime st=new DateTime(startTime.getTime());
		DateTime en=new DateTime(endTime.getTime());
		int minutes=Minutes.minutesBetween(st, en).getMinutes();
		return minutes;
	}

	public static String getMSdateString(Date date) {
		DateTime jodaDate=new DateTime(date);
		return jodaDate.toString(); 
	}

	/**
	 * Just for readable time in HH:mm from a string
	 * @param stringDate
	 * @return HH:mm or "" if unparsable
	 */
	public static String getReadableTime(String stringDate) {
		String toRet="";
		if (StringUtil.isValid(stringDate)){
			try {
				DateTime joda=DateTime.parse(stringDate);
				toRet=joda.getHourOfDay()+":"+joda.getMinuteOfHour();
			} catch (Exception e) {
//				System.err.println(stringDate + " not parsable as Joda DateTime ISO 8601");
				Date d=getDate(stringDate);
				if (d!=null){
					toRet=getReadableTime(d);
				}else{
					toRet="";
				}
				System.err.println(stringDate + " not parsable as Joda DateTime ISO 8601. Returned as: "+toRet);
				return toRet;
			}
		}
		

		return toRet;
	}
	
	public static int getDaysInAWeekBetween(Calendar a, Calendar b){
		int diff= a.get(Calendar.DAY_OF_WEEK) - b.get(Calendar.DAY_OF_WEEK);
		return diff;
	}

}
