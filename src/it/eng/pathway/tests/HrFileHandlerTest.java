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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.eng.pathway.utility.HrFileHandler;
import it.eng.pathway.utility.HrMeasure;

public class HrFileHandlerTest {
	
//	private String read="1;80;2;84;3;76;";
	private String read="80;84;76;";
	private Double media = (double) 80; //media della stringa di sopra
	int wu=5;
	int ae=35;
	int cd=5;
	int duration = wu+ae+cd;
	
	int wumin = 80;
	int wumax = 110;
	int aemin = 110;
	int aemax = 175;
	int cdmin = 90;
	int cdmax = 120;
	
//	WUmin 80 WUmax 110 WUDuration 5 AEmin 110 AEmax  175 AEDuration 35 CDmin 90 CDMax 120 CDDuration 5 
	
	@Test
	public void testParse() {
		List<HrMeasure> hrs=HrFileHandler.parse(read);
		assertEquals("Lunghezza array parsed non corretta",hrs.size(),3);
	}

	@Test
	public void testCreateString() {
		List<HrMeasure> hrs=HrFileHandler.parse(read);
		String created=HrFileHandler.createString(hrs);
		assertEquals("Stringhe Differenti", read, created);
	}

	@Test
	public void testCreateFile() {
		int min = 78;
		int max = 90;
		List<HrMeasure> hrs=HrFileHandler.createFile(min, max, duration, true, 1);
		assertEquals("Lunghezza array creato non corretta",hrs.size(),duration*60);
		int minC = 200;
		int maxC = 0;
		for (HrMeasure current : hrs) {
			int value = current.getValue();
			minC = value<minC ? value : minC;
			maxC = value>maxC ? value : maxC;
		}
//		assertEquals("Minimo NON CORRETTO", min, minC);
//		assertEquals("Massimo NON CORRETTO", max, maxC);
//		System.out.println(HrFileHandler.createString(hrs));
	}

	@Test
	public void testCalculateAverage() {
		
		List<HrMeasure> hrs=HrFileHandler.parse(read);
		Double avg=HrFileHandler.calculateAverage(hrs);
		assertEquals("Media non corretta", avg, media);
	}
	
	@Test
	public void testCombinePhases() {
		List<HrMeasure> hrs=HrFileHandler.combinePhases(wumin, wumax, wu, aemin, aemax, ae, cdmin, cdmax, cd);
		assertEquals("Lunghezza array combined non corretta",hrs.size(),(wu+ae+cd)*60);
	}
	
	@Test
	public void testCalculateAllAverage() {
		List<HrMeasure> hrs=HrFileHandler.combinePhases(wumin, wumax, wu, aemin, aemax, ae, cdmin, cdmax, cd);
		Double[] avgs=HrFileHandler.calculateAllAverage(hrs, wu, ae, cd);
		
		List<HrMeasure> hrswu = hrs.subList(0, 60*wu);
		List<HrMeasure> hrsae = hrs.subList(60*wu, 60*(wu+ae));
		List<HrMeasure> hrscd = hrs.subList( 60*(wu+ae), 60*(wu+ae+cd));
		
		Double avgwu = HrFileHandler.calculateAverage(hrswu);
		Double avgae = HrFileHandler.calculateAverage(hrsae);
		Double avgcd = HrFileHandler.calculateAverage(hrscd);
		
		assertEquals("Media WU non corretta",avgs[0],avgwu);
		assertEquals("Media AE non corretta",avgs[1],avgae);
		assertEquals("Media CD non corretta",avgs[2],avgcd);
		
	}
	
	
	@Test
	public void testChartData() {
		int min = 78;
		int max = 90;
		
		List<HrMeasure> hrs=HrFileHandler.createFile(min, max, duration, true, 1);
		assertEquals("Lunghezza array creato non corretta",hrs.size(),duration*60);
		int minCd, maxCd, minAe, maxAe, minWu, maxWu;
		
		minWu = 90;
		maxWu = 120;
		minAe = 130;
		maxAe = 175;
		minCd = 120;
		maxCd = 140;
		
		
		hrs=HrFileHandler.combinePhases(wumin, wumax, wu, aemin, aemax, ae, cdmin, cdmax, cd);
		
//		for (HrMeasure hr : hrs) {
//			System.out.print(hr);
//		}
//		System.out.println();
		
		ArrayList<String> valori = new ArrayList<String>();
		ArrayList<String> medie = new ArrayList<String>();
		ArrayList<String> maxZ = new ArrayList<String>();
		ArrayList<String> minZ = new ArrayList<String>();
		int i=0;
		int mD = wu + ae + cd;
		double totalSum = 0;
		double totalI = 0;
		for (i = 1; i<=mD; i++){
			double sum=0;
			for (int k = 1; k<=60 ; k++){
				int pos = ((i-1)*60) + k - 1;
				HrMeasure c = hrs.get(pos);
				sum += c.getValue();
			}
			double avg = (double) sum / (double) 60;
			totalSum += avg;
			totalI++;
			double totalAvg = (double) totalSum / (double) totalI;
			valori.add(String.format("%.1f", avg));
			medie.add(String.format("%.1f", totalAvg));
			if (i<wu){
				minZ.add(String.valueOf(minWu));
				maxZ.add(String.valueOf(maxWu));
			}else if(i<(cd+ae)){
				minZ.add(String.valueOf(minAe));
				maxZ.add(String.valueOf(maxAe));
			}else{
				minZ.add(String.valueOf(minCd));
				maxZ.add(String.valueOf(maxCd));
			}
		}
		
		int tot = valori.size();
		for (int k=1; k<=tot; k++){
			System.out.print(k + ";");
		}
		System.out.println();
		for (int k=0; k<tot; k++){
			System.out.print(valori.get(k) + ";");
		}
		System.out.println();
		for (int k=0; k<tot; k++){
			System.out.print(medie.get(k) + ";");
		}
		System.out.println();
		for (int k=0; k<tot; k++){
			System.out.print(minZ.get(k) + ";");
		}
		System.out.println();
		for (int k=0; k<tot; k++){
			System.out.print(maxZ.get(k) + ";");
		}
		
	}
		

}
