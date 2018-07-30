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
package it.eng.pathway.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import it.eng.pathway.utility.DateMgt;

public class ExerciseProgrammeComparisonTest {

	@Test
	public void testGetLastOfTheWeekProgramme() {
		ExerciseProgrammeComparison compare = new ExerciseProgrammeComparison();
		
		ArrayList<Date> dates = new ArrayList<Date>();
		dates.add(DateMgt.getDate("07-08-2016"));
		dates.add(DateMgt.getDate("14-08-2016"));
		dates.add(DateMgt.getDate("21-08-2016"));
		dates.add(DateMgt.getDate("28-08-2016"));
		dates.add(DateMgt.getDate("04-09-2016"));
		dates.add(DateMgt.getDate("11-09-2016"));
		dates.add(DateMgt.getDate("18-09-2016"));
		dates.add(DateMgt.getDate("25-09-2016"));
		dates.add(DateMgt.getDate("02-10-2016"));
		dates.add(DateMgt.getDate("09-10-2016"));
		dates.add(DateMgt.getDate("16-10-2016"));
		dates.add(DateMgt.getDate("23-10-2016"));
		dates.add(DateMgt.getDate("30-10-2016"));
		dates.add(DateMgt.getDate("30-10-2016"));
		dates.add(DateMgt.getDate("06-11-2016"));
		dates.add(DateMgt.getDate("13-11-2016"));
		
		
//		for (Date date : dates) {
//			System.out.println(DateMgt.getReadableDate(date));
//		}
		
		Date result = null;
		result = compare.getLastOfTheWeekProgramme(DateMgt.getDate("15-09-2016"), dates);
		assertEquals(result, DateMgt.getDate("11-09-2016"));
		
		result = compare.getLastOfTheWeekProgramme(DateMgt.getDate("15-12-2016"), dates);
		assertEquals(result, DateMgt.getDate("13-11-2016"));
		
		result = compare.getLastOfTheWeekProgramme(DateMgt.getDate("23-10-2016"), dates);
		assertEquals(result, DateMgt.getDate("23-10-2016"));
		
		result = compare.getLastOfTheWeekProgramme(DateMgt.getDate("04-03-2016"), dates);
		assertEquals(result, DateMgt.getDate("07-08-2016"));
		
	}

}
