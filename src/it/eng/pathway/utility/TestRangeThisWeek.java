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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;

public class TestRangeThisWeek {

	public static void main(String[] args) {
		Date startD = DateMgt.getDate("2016-06-07");
		
		for(int i = -4 ; i<10; i++){
			testRange(i,startD);
		}
}
	
	public static void testRange(int i, Date startD){
		
		Calendar today = GregorianCalendar.getInstance();
		today.add(Calendar.DAY_OF_MONTH, i);
			System.out.println("TodayIs: "+DateMgt.getReadableDate(today.getTime()));
		Calendar startTime = GregorianCalendar.getInstance();
			startTime.setTime(today.getTime());
		Calendar temp = GregorianCalendar.getInstance();
		temp.setTime(startD);
//			System.out.println("Ipotizzo allenamento iniziato il: " + DateMgt.getReadableDate(temp.getTime()));
		int startDayOfWeek = temp.get(Calendar.DAY_OF_WEEK);
//			System.out.println("StartDayOfWeek: "+startDayOfWeek);
		
		startTime.set(Calendar.DAY_OF_WEEK, startDayOfWeek);
//			System.out.println("Setting DayOfTheWeek: "+ DateMgt.getReadableDate(startTime.getTime()));
		
		DateTime startJoda=new DateTime(startTime.getTime());
		DateTime todayJoda=new DateTime(today.getTime());
		int n=todayJoda.compareTo(startJoda);
//		System.out.println("JodaDifference: " +n);
		
		if (n>=0){
			temp.setTime(startTime.getTime());
//				System.out.println("TempTime: "+DateMgt.getReadableDate(temp.getTime()));
			temp.add(Calendar.DAY_OF_MONTH, 6); // data fine settimana corrente
		}else{
			startTime.add(Calendar.DAY_OF_MONTH, -7); // data di inizio
			// settimana corrente
//				System.out.println("StartTime: "+DateMgt.getReadableDate(startTime.getTime()));
			temp.setTime(startTime.getTime());
//				System.out.println("TempTime: "+DateMgt.getReadableDate(temp.getTime()));
			temp.add(Calendar.DAY_OF_MONTH, 6); // data fine settimana corrente
		}
			
		int differenceDaysWeek = DateMgt.getDaysInAWeekBetween(today,startTime);
//			System.out.println("Differenza giorni settimana: "+differenceDaysWeek);
			
		int differenceDays = DateMgt.getDays(startTime.getTime(),today.getTime());
//			System.out.println("Differenza giorni mese: "+differenceDays);	
		
			
//			System.out.println("EndTime: "+DateMgt.getReadableDate(temp.getTime()));
			System.out.println("Il range per la settimana attuale sarebbe dal: " + DateMgt.getReadableDate(startTime.getTime())
					+ " al: " + DateMgt.getReadableDate(temp.getTime()));
	}
	}
