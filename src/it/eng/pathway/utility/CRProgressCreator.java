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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;

import io.swagger.client.model.CardiacRehabilitationProgrammeExerciseProgrammeSubSection;
import io.swagger.client.model.CardiacRehabilitationProgressActiveLifestylePASessionSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressActiveLifestylePASessionenergyExpenditureSubSubSection;
import io.swagger.client.model.CardiacRehabilitationProgressActiveLifestylePASessionminutesInZoneSubSubSection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionCoolDownInfohrRangeSubSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessioncoolDownInfoSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionenergyExpenditureSubSubSection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfileSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfilecoolDownHRZonehrZoneSubSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfilemainHRZonehrZoneSubSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfilewarmingUpHRZonehrZoneSubSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionmainInfoSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionmainInfohrRange;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionwarmingUpInfoSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionwarmingUpInfohrRangeSubSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionCoolDownInfohrRangeSubSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfileSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfilecoolDownHRZonehrZoneSubSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfilemainHRZonehrZoneSubSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfilewarmingUpHRZonehrZoneSubSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessioncoolDownInfoSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionenergyExpenditureSubSubSection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionmainInfoSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionmainInfohrRange;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionwarmingUpInfoSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionwarmingUpInfohrRangeSubSubSubsection;
import it.eng.pathway.fake.model.ActiveLifestylePAIntensityType;
import it.eng.pathway.fake.model.ActivityType;

public class CRProgressCreator {
	
	private static double wutp=0.115;
	private static double aetp=0.77;
	private static double cdtp=0.115;
	
	private static boolean file=true;
	
	
	public static HashMap<String,Object> createProgress(CardiacRehabilitationProgrammeExerciseProgrammeSubSection programme, Date from, Date to){
		Integer N=2;
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		System.out.println("createProgress");
		
		int days = DateMgt.getDays(from, to);
		if (programme!=null){
			int exerclass=programme.getNumberOfExerClass();
			int exergame=programme.getNumberOfExerGame();
			int activity=programme.getNumberOfActiveLifeStyleActivity();
			
			int classDuration=programme.getClassDuration();
			int gameDuration=programme.getGameDuration();
			
			int weeks=((int) days/7);
			
			exerclass*=weeks;
			exergame*=weeks;
			activity*=weeks;
			
			int countClass=0;
			int countGame=0;
			int countActivity=0;
			
			Random r=new Random();
			
//			ExerClassSessionProgress exClass=new ExerClassSessionProgress();
			List<CardiacRehabilitationProgressExerClassSessionSubsection> classSessions=new ArrayList<CardiacRehabilitationProgressExerClassSessionSubsection>();
//			exClass.setExerClassSessionsss(classSessions);
			
//			ExerGameSessionProgress exGame = new ExerGameSessionProgress();
			List<CardiacRehabilitationProgressExerGameSessionSubsection> gameSessions=new ArrayList<CardiacRehabilitationProgressExerGameSessionSubsection>();
//			ExerGameSession gameSession=new ExerGameSession();
//			gameSessions.setExerGameSessionSS(gameSessions)
			
//			ActiveLifeStyleProgress paProgress=new ActiveLifeStyleProgress();
			List<CardiacRehabilitationProgressActiveLifestylePASessionSubsection> paSessions=new ArrayList<CardiacRehabilitationProgressActiveLifestylePASessionSubsection>();
//			paProgress.setActiveLifestylePASessionSSs(paSessions);
			
//			Integer wuDuration=tp.getWarmingUpDuration();
//			Integer wuMin=tp.getWarmingHRzoneMin();
//			Integer wuMax=tp.getWarmingHRzoneMax();
//			
//			Integer aeDuration=tp.getMainDuration();
//			Integer aeMin=tp.getMainHRzoneMin();
//			Integer aeMax=tp.getMainHRzoneMax();
//			
//			Integer cdDuration=tp.getCooldownDuration();
//			Integer cdMin=tp.getCooldownHRZoneMin();
//			Integer cdMax=tp.getCooldownHRZoneMax();
			
			Integer wuDuration=(int) (classDuration*wutp);
			Integer wuMin=80;
			Integer wuMax=110;
			
			Integer aeDuration=(int) (classDuration*aetp);
			Integer aeMin=110;
			Integer aeMax=175;
			
			Integer cdDuration=(int) (classDuration*cdtp);
			Integer cdMin=90;
			Integer cdMax=120;
			
			Calendar cal=GregorianCalendar.getInstance();
			cal.setTime(from);
			
			for (int i=0;i<days;i++){
			cal.add(Calendar.DAY_OF_MONTH, i);
			Date actual=cal.getTime();
			int choice;
			int perDay=0+r.nextInt(4);
			for (int j=0;j<perDay;j++){
				
				choice=r.nextInt(8);
				
				switch (choice) {
				case 0:
					break;
				case 1:
					if(countClass<exerclass+N){
						CardiacRehabilitationProgressExerClassSessionSubsection classSession=new CardiacRehabilitationProgressExerClassSessionSubsection();
						DateTime dt=new DateTime(actual.getTime());
						classSession.setDate(dt.toDate());
						cal.set(Calendar.HOUR_OF_DAY, r.nextInt(23));
						cal.set(Calendar.MINUTE,r.nextInt(59));
						String start=DateMgt.getReadableTime(cal);
						classSession.setStartTime(cal.getTime());
						int duration=20+r.nextInt(45);
						cal.add(Calendar.MINUTE, duration);
						String end=DateMgt.getReadableTime(cal);
						classSession.setEndTime(cal.getTime());
						classSession.setDuration(duration);
						CardiacRehabilitationProgressExerClassSessionenergyExpenditureSubSubSection kcal = new CardiacRehabilitationProgressExerClassSessionenergyExpenditureSubSubSection();
						kcal.setKcal(350+r.nextInt(251));
						classSession.setEnergyExpenditure(kcal);
						
						int min=wuMin;
						int max=wuMax;
						Double avg= (((double) max+ (double)min)/ (double)2);
						max=max+r.nextInt(8);
						
						CardiacRehabilitationProgressExerClassSessionwarmingUpInfoSubSubsection wu = new CardiacRehabilitationProgressExerClassSessionwarmingUpInfoSubSubsection();
						classSession.setWarmingUpInfo(wu);
						wu.setDuration((int) Math.round(duration*wutp));
						wu.setAverageHRBpm(avg);
						CardiacRehabilitationProgressExerClassSessionwarmingUpInfohrRangeSubSubSubsection wuR = new CardiacRehabilitationProgressExerClassSessionwarmingUpInfohrRangeSubSubSubsection();
						wuR.setMaxBpm(max);
						wuR.setMinBpm(min);
						wu.setHrRange(wuR);
						
						
						CardiacRehabilitationProgressExerClassSessionmainInfoSubSubsection main = new CardiacRehabilitationProgressExerClassSessionmainInfoSubSubsection();
						classSession.setMainInfo(main);
						min=aeMin;
						max=aeMax;
						avg= (((double) max+ (double)min)/ (double)2);
						max=max+r.nextInt(8);
						main.setAverageHRBpm(avg);
						main.setDuration((int) Math.round(duration*aetp));
						CardiacRehabilitationProgressExerClassSessionmainInfohrRange mainR = new CardiacRehabilitationProgressExerClassSessionmainInfohrRange();
						mainR.setMaxBpm(max);
						mainR.setMinBpm(min);
						main.setHrRange(mainR );

						
						
						CardiacRehabilitationProgressExerClassSessioncoolDownInfoSubSubsection cd = new CardiacRehabilitationProgressExerClassSessioncoolDownInfoSubSubsection();
						classSession.setCoolDownInfo(cd);
						min=cdMin;
						max=cdMax;
						avg= (((double) max+ (double)min)/ (double)2);
						max=max+r.nextInt(8);
						
						cd.setAverageHRBpm(avg);
						cd.setDuration((int) Math.round(duration*cdtp));
						CardiacRehabilitationProgressExerClassSessionCoolDownInfohrRangeSubSubSubsection cdR = new CardiacRehabilitationProgressExerClassSessionCoolDownInfohrRangeSubSubSubsection();
						cdR.setMaxBpm(max);
						cdR.setMinBpm(min);
						cd.setHrRange(cdR);
						
						List<HrMeasure> hrs = HrFileHandler.combinePhases(wuMin, wuMax, wu.getDuration(), aeMin, aeMax, main.getDuration(), cdMin, cdMax, cd.getDuration());
						
						if (file){
							String hrsFile=HrFileHandler.createString(hrs);
							System.out.println("ExerClass: "+DateMgt.getReadableDate(classSession.getDate())+" "+hrsFile);		
							classSession.setHrFile(hrsFile);
						}
						
						Double[] avgs = HrFileHandler.calculateAllAverage(hrs,  wu.getDuration(), main.getDuration(), cd.getDuration());
						wu.setAverageHRBpm(avgs[0]);
						main.setAverageHRBpm(avgs[1]);
						cd.setAverageHRBpm(avgs[2]);
						
						CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfileSubSubsection tprofile = new CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfileSubSubsection();
						tprofile.setWarmingUpDuration(wuDuration);
						tprofile.setMainDuration(aeDuration);
						tprofile.setCoolDownDuration(cdDuration);
						
						CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfilewarmingUpHRZonehrZoneSubSubSubsection warmingUpHRZone = new CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfilewarmingUpHRZonehrZoneSubSubSubsection();
						warmingUpHRZone.setMinBpm(wuMin);
						warmingUpHRZone.setMaxBpm(wuMax);
						tprofile.setWarmingUpHRZone(warmingUpHRZone );
						
						CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfilemainHRZonehrZoneSubSubSubsection mainHRZone = new CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfilemainHRZonehrZoneSubSubSubsection();
						mainHRZone.setMinBpm(aeMin);
						mainHRZone.setMaxBpm(aeMax);
						tprofile.setMainHRZone(mainHRZone );
						
						CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfilecoolDownHRZonehrZoneSubSubSubsection coolDownHRZone = new CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfilecoolDownHRZonehrZoneSubSubSubsection();
						coolDownHRZone.setMinBpm(cdMin);
						coolDownHRZone.setMaxBpm(cdMax);
						tprofile.setCoolDownHRZone(coolDownHRZone );
						
						classSession.setLinkedTrainingProfile(tprofile);
						//TEST PER NG
//						CardiacRehabilitationProgressExerClassSessionPreScreeningInfoSubSubsection preScreeningInfo = new CardiacRehabilitationProgressExerClassSessionPreScreeningInfoSubSubsection();
//						CardiacRehabilitationProgressExerClassSessionPreScreeningInforestingHRSubSubSubSection restingHR = new CardiacRehabilitationProgressExerClassSessionPreScreeningInforestingHRSubSubSubSection();
//						restingHR.setBpm(75);
//						preScreeningInfo.setRestingHR(restingHR );
//						CardiacRehabilitationProgressExerClassSessionPreScreeningInforestingBloodPressureSubSubSubsection restingBloodPressure = new CardiacRehabilitationProgressExerClassSessionPreScreeningInforestingBloodPressureSubSubSubsection();
//						restingBloodPressure.setSystolic(123);
//						restingBloodPressure.setDiastolic(83);
//						preScreeningInfo.setRestingBloodPressure(restingBloodPressure);
//						CardiacRehabilitationProgressExerClassSessionPreScreeningInfoFinalEvaluationSubSubSubsection finalEvaluation = new CardiacRehabilitationProgressExerClassSessionPreScreeningInfoFinalEvaluationSubSubSubsection();
//						finalEvaluation.setResult(1);
//						finalEvaluation.setDescription("Custom Description");
//						finalEvaluation.setMessage("Custom Message");
//						finalEvaluation.setTimestamp(new Date());
//						preScreeningInfo.setFinalEvaluation(finalEvaluation );
//						List<String> preScreeningAssessment = new ArrayList<String>();
//						preScreeningAssessment.add("Prima");
//						preScreeningAssessment.add("Seconda");
//						preScreeningInfo.setPreScreeningAssessment(preScreeningAssessment);
//						classSession.setPreScreeningInfo(preScreeningInfo );
						
//						classSession.setStatus(r.nextInt(4)+1);
//						classSession.setRpe(r.nextInt(8)+1);
//						classSession.setSessionSatisfactionLevel(r.nextInt(4)+1);
						
						classSession.setStatus(r.nextInt(4));
						classSession.setRpe(r.nextInt(8));
						classSession.setSessionSatisfactionLevel(r.nextInt(4));
						
						classSession.setId(null);
//						classSession.setAcceptable(r.nextBoolean());
						classSession.setAcceptable(true);
						classSessions.add(classSession);
						countClass++;
					}
					break;
					
				case 2:
					if(countGame<exergame+N){
						//dovrebbe essere sempre un array
						
						CardiacRehabilitationProgressExerGameSessionSubsection exGame=new CardiacRehabilitationProgressExerGameSessionSubsection();
						DateTime dt=new DateTime(actual.getTime());
						exGame.setDate(dt.toDate());
						cal.set(Calendar.HOUR_OF_DAY, r.nextInt(23));
						cal.set(Calendar.MINUTE,r.nextInt(59));
						String start=DateMgt.getReadableTime(cal);
						exGame.setStartTime(cal.getTime());
						int duration=20+r.nextInt(45);
						cal.add(Calendar.MINUTE, duration);
						String end=DateMgt.getReadableTime(cal);
						exGame.setEndTime(cal.getTime());
						exGame.setDuration(duration);
						CardiacRehabilitationProgressExerGameSessionenergyExpenditureSubSubSection kcal = new CardiacRehabilitationProgressExerGameSessionenergyExpenditureSubSubSection();
						kcal.setKcal(350+r.nextInt(251));
						exGame.setEnergyExpenditure(kcal);
						
						
						int min=wuMin;
						int max=wuMax;
						Double avg=((double) max+(double) min)/(double) 2;
						max=max+r.nextInt(8);
						
						CardiacRehabilitationProgressExerGameSessionwarmingUpInfoSubSubsection wu = new CardiacRehabilitationProgressExerGameSessionwarmingUpInfoSubSubsection();
						wu.setAverageHRBpm(avg);
						wu.setDuration((int) Math.round(duration*wutp));
						CardiacRehabilitationProgressExerGameSessionwarmingUpInfohrRangeSubSubSubsection wuR = new CardiacRehabilitationProgressExerGameSessionwarmingUpInfohrRangeSubSubSubsection();
						wuR.setMaxBpm(max);
						wuR.setMinBpm(min);
						wu.setHrRange(wuR);
						exGame.setWarmingUpInfo(wu);
						
						
						CardiacRehabilitationProgressExerGameSessionmainInfoSubSubsection main = new CardiacRehabilitationProgressExerGameSessionmainInfoSubSubsection();
						exGame.setMainInfo(main);
						min=aeMin;
						max=aeMax;
						avg=((double) max+(double) min)/(double) 2;
						max=max+r.nextInt(8);
						main.setAverageHRBpm((double) avg);
						main.setDuration((int) Math.round(duration*aetp));
						CardiacRehabilitationProgressExerGameSessionmainInfohrRange mainR = new CardiacRehabilitationProgressExerGameSessionmainInfohrRange();
						mainR.setMaxBpm(max);
						mainR.setMinBpm(min);
						main.setHrRange(mainR);

						CardiacRehabilitationProgressExerGameSessioncoolDownInfoSubSubsection cd = new CardiacRehabilitationProgressExerGameSessioncoolDownInfoSubSubsection();
						exGame.setCoolDownInfo(cd);
						
						min=cdMin;
						max=cdMax;
						avg=((double) max+(double) min)/(double) 2;
						max=max+r.nextInt(8);
						
						cd.setAverageHRBpm((double) avg);
						cd.setDuration((int) Math.round(duration*cdtp));
						CardiacRehabilitationProgressExerGameSessionCoolDownInfohrRangeSubSubSubsection cdR = new CardiacRehabilitationProgressExerGameSessionCoolDownInfohrRangeSubSubSubsection();
						cdR.setMaxBpm(max);
						cdR.setMinBpm(min);
						cd.setHrRange(cdR);
						
						exGame.setScore(5+r.nextInt(25));
						
						exGame.setId(null);
						exGame.setAcceptable(true);
						
						List<HrMeasure> hrs = HrFileHandler.combinePhases(wuMin, wuMax, wu.getDuration(), aeMin, aeMax, main.getDuration(), cdMin, cdMax, cd.getDuration());
						
						if (file){
							String hrsFile=HrFileHandler.createString(hrs);
							System.out.println("ExerGame: "+DateMgt.getReadableDate(exGame.getDate())+" "+hrsFile);		
							exGame.setHrFile(hrsFile);
						}
						
						Double[] avgs = HrFileHandler.calculateAllAverage(hrs,  wu.getDuration(), main.getDuration(), cd.getDuration());
						wu.setAverageHRBpm(avgs[0]);
						main.setAverageHRBpm(avgs[1]);
						cd.setAverageHRBpm(avgs[2]);
						
						CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfileSubSubsection tprofile=new CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfileSubSubsection();
						tprofile.setWarmingUpDuration(wuDuration);
						tprofile.setMainDuration(aeDuration);
						tprofile.setCoolDownDuration(cdDuration);
						
						CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfilewarmingUpHRZonehrZoneSubSubSubsection warmingUpHRZone = new CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfilewarmingUpHRZonehrZoneSubSubSubsection();
						warmingUpHRZone.setMinBpm(wuMin);
						warmingUpHRZone.setMaxBpm(wuMax);
						tprofile.setWarmingUpHRZone(warmingUpHRZone);
						
						CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfilemainHRZonehrZoneSubSubSubsection mainHRZone = new CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfilemainHRZonehrZoneSubSubSubsection();
						mainHRZone.setMinBpm(aeMin);
						mainHRZone.setMaxBpm(aeMax);
						tprofile.setMainHRZone(mainHRZone);
						
						CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfilecoolDownHRZonehrZoneSubSubSubsection coolDownHRZone = new CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfilecoolDownHRZonehrZoneSubSubSubsection();
						coolDownHRZone.setMinBpm(cdMin);
						coolDownHRZone.setMaxBpm(cdMax);
						tprofile.setCoolDownHRZone(coolDownHRZone );
						
						exGame.setLinkedTrainingProfile(tprofile);
						
//						exGame.setStatus(r.nextInt(4)+1);
//						exGame.setRpe(r.nextInt(8)+1);
//						exGame.setSessionSatisfactionLevel(r.nextInt(4)+1);
						
						exGame.setStatus(r.nextInt(4));
						exGame.setRpe(r.nextInt(8));
						exGame.setSessionSatisfactionLevel(r.nextInt(4));
						
						gameSessions.add(exGame);
						countGame++;
					}
					break;
				case 3:
					if(countActivity<activity+N){
						
						CardiacRehabilitationProgressActiveLifestylePASessionSubsection pa = new CardiacRehabilitationProgressActiveLifestylePASessionSubsection();
						DateTime dt=new DateTime(actual.getTime());
						pa.setDate(dt.toDate());

						cal.set(Calendar.HOUR_OF_DAY, r.nextInt(23));
						cal.set(Calendar.MINUTE,r.nextInt(59));
						String start=DateMgt.getReadableTime(cal);
						pa.setStartTime(cal.getTime());
						
						int duration=20+r.nextInt(45);
						cal.add(Calendar.MINUTE, duration);
						String end=DateMgt.getReadableTime(cal);
						pa.setEndTime(cal.getTime());
						pa.setDuration(duration);
						
						CardiacRehabilitationProgressActiveLifestylePASessionenergyExpenditureSubSubSection kcal = new CardiacRehabilitationProgressActiveLifestylePASessionenergyExpenditureSubSubSection();
						kcal.setKcal(350+r.nextInt(251));
						pa.setEnergyExpenditure(kcal);
						
						pa.setType(r.nextInt(ActivityType.values().length));
						
						pa.setMonitored(r.nextInt(2)==1);
						
						if (pa.getMonitored()){
							pa.setStepsNumber(6000+r.nextInt(4000));
							pa.setAverageHeartRate(80+r.nextInt(90));
							CardiacRehabilitationProgressActiveLifestylePASessionminutesInZoneSubSubSection zones = createMinutesInZone(aeMax, duration);
							pa.setMinutesInZone(zones);
							pa.setAcceptable(isAcceptable(zones, duration));
							System.out.println("PASession: "+pa.getAcceptable()+" "+pa.getMinutesInZone());
						}else{
							pa.setIntensity(r.nextInt(ActiveLifestylePAIntensityType.values().length));
							pa.setDescription("in the park ["+countActivity+"]");
							pa.setAcceptable(false);
						}

						
						
						paSessions.add(pa);
						countActivity++;
					}
					break;
				default:
					break;
				}
			}

			cal.add(Calendar.DAY_OF_MONTH, -i);
		}
			
			result.put("exerClass", classSessions);
			result.put("exerGame", gameSessions);
			result.put("paSessions", paSessions);
			
			
			return result;
		}else{
			return null;
		}
		
		
	}


	public static CardiacRehabilitationProgressActiveLifestylePASessionminutesInZoneSubSubSection createMinutesInZone(
			Integer aeMax, Integer duration) {
		CardiacRehabilitationProgressActiveLifestylePASessionminutesInZoneSubSubSection msZ = new CardiacRehabilitationProgressActiveLifestylePASessionminutesInZoneSubSubSection();
		int[] zones = new int[7];
		Random r = new Random();
		for (int i=0; i<duration; i++){
			int zone = r.nextInt(7);
			zones[zone]++;
		}
		msZ.setZone050(zones[0]);
		msZ.setZone5160(zones[1]);
		msZ.setZone6170(zones[2]);
		msZ.setZone7180(zones[3]);
		msZ.setZone8190(zones[4]);
		msZ.setZone91100(zones[5]);
		msZ.setZone101(zones[6]);
		
		return msZ;
	}
	
	/**
	 * Valuta l'accettabilità della sessione. Il 70% del tempo deve essere speso tra il 60% ed il 90% della frequenza massima
	 * @param pas
	 * @param current
	 */
	public static boolean isAcceptable(CardiacRehabilitationProgressActiveLifestylePASessionminutesInZoneSubSubSection pas,Integer wholeDuration) {
		Double percTime = 0.7;
		Double goalDuration = percTime * (double) wholeDuration;
		Integer sum = 0;
		sum += pas.getZone6170()!=null ? pas.getZone6170() : 0; 
		sum += pas.getZone7180()!=null ? pas.getZone7180() : 0; 
		sum += pas.getZone8190()!=null ? pas.getZone8190() : 0; 
		System.out.println("Acceptable? "+(sum>=goalDuration)+" because SUM is "+ sum +" and the goalDuration is: "+ goalDuration);
		return sum>=goalDuration;
	}

	
//	public static HashMap<String,Object> createProgress(CardiacRehabilitationProgramme crp, Date from, Date to){
//		Integer N=2;
//		
//		HashMap<String, Object> result = new HashMap<String, Object>();
//		System.out.println("createProgress");
//		
//		int days = DateMgt.getDays(from, to);
//		List<ExerciseProgramme> programmes = crp.getExerciseProgrammes();
//		if (programmes!=null && programmes.size()>0){
//			ExerciseProgramme programme=programmes.get(0);
//			int exerclass=programme.getNumberOfExerClass();
//			int exergame=programme.getNumberOfExerGame();
//			int activity=programme.getNumberOfActiveLifeStyleActivity();
//			
//			int classDuration=programme.getClassDuration();
//			int gameDuration=programme.getGameDuration();
//			
//			int weeks=((int) days/7);
//			
//			exerclass*=weeks;
//			exergame*=weeks;
//			activity*=weeks;
//			
//			int countClass=0;
//			int countGame=0;
//			int countActivity=0;
//			
//			Random r=new Random();
//			
//			ExerClassSessionProgress exClass=new ExerClassSessionProgress();
//			List<ExerClassSessionss> classSessions=new ArrayList<ExerClassSessionss>();
//			exClass.setExerClassSessionsss(classSessions);
//			
//			ExerGameSessionProgress exGame = new ExerGameSessionProgress();
////			List<ExerGameSession> gameSessions=new ArrayList<ExerGameSession>();
////			ExerGameSession gameSession=new ExerGameSession();
////			gameSessions.setExerGameSessionSS(gameSessions)
//			
//			ActiveLifeStyleProgress paProgress=new ActiveLifeStyleProgress();
//			List<ActiveLifestylePASessionSS> paSessions=new ArrayList<ActiveLifestylePASessionSS>();
//			paProgress.setActiveLifestylePASessionSSs(paSessions);
//			
////			Integer wuDuration=tp.getWarmingUpDuration();
////			Integer wuMin=tp.getWarmingHRzoneMin();
////			Integer wuMax=tp.getWarmingHRzoneMax();
////			
////			Integer aeDuration=tp.getMainDuration();
////			Integer aeMin=tp.getMainHRzoneMin();
////			Integer aeMax=tp.getMainHRzoneMax();
////			
////			Integer cdDuration=tp.getCooldownDuration();
////			Integer cdMin=tp.getCooldownHRZoneMin();
////			Integer cdMax=tp.getCooldownHRZoneMax();
//			
//			Integer wuDuration=(int) (classDuration*wutp);
//			Integer wuMin=80;
//			Integer wuMax=110;
//			
//			Integer aeDuration=(int) (classDuration*aetp);
//			Integer aeMin=110;
//			Integer aeMax=175;
//			
//			Integer cdDuration=(int) (classDuration*cdtp);
//			Integer cdMin=120;
//			Integer cdMax=90;
//			
//			Calendar cal=GregorianCalendar.getInstance();
//			cal.setTime(from);
//			
//			for (int i=0;i<days;i++){
//			cal.add(Calendar.DAY_OF_MONTH, i);
//			Date actual=cal.getTime();
//			int choice;
//			int perDay=0+r.nextInt(4);
//			for (int j=0;j<perDay;j++){
//				
//				choice=r.nextInt(8);
//				
//				switch (choice) {
//				case 0:
//					break;
//				case 1:
//					if(countClass<exerclass+N){
//						ExerClassSessionss classSession=new ExerClassSessionss();
//						classSession.setExerClassSessiondate(actual);
//						cal.set(Calendar.HOUR_OF_DAY, r.nextInt(23));
//						cal.set(Calendar.MINUTE,r.nextInt(59));
//						String start=DateMgt.getReadableTime(cal);
//						classSession.setExerClassSessionstartTime(start);
//						int duration=20+r.nextInt(45);
//						cal.add(Calendar.MINUTE, duration);
//						String end=DateMgt.getReadableTime(cal);
//						classSession.setExerClassSessionendTime(end);
//						classSession.setExerClassSessionDuration(duration);
//						
//						classSession.setExerClassSessionexpenditureObservationValue(350+r.nextInt(251));
//						
//						int min=wuMin;
//						int max=wuMax;
//						float avg=(max+min)/2;
//						max=max+r.nextInt(8);
//						
//						classSession.setExerClassSessionwarmingUpDuration((int) Math.round(duration*wutp));
//						classSession.setExerClassSessionwarmingUpHRBpmMax(max);
//						classSession.setExerClassSessionwarmingUpHRBpmMin(min);
//						classSession.setExerClassSessionwarmingUpAverageHRBpm((int) avg);
//						
//						min=aeMin;
//						max=aeMax;
//						avg=(max+min)/2;
//						max=max+r.nextInt(8);
//						classSession.setExerClassSessionmainInfoDuration((int) Math.round(duration*aetp));
//						classSession.setExerClassSessionmainInfoMaxHRBpm(max);
//						classSession.setExerClassSessionmainInfoMinHRBpm(min);
//						classSession.setExerClassSessionmainInfoAverageHRBpm((double) avg);
//
//						
//						min=cdMin;
//						max=cdMax;
//						avg=(max+min)/2;
//						max=max+r.nextInt(8);
//						classSession.setExerClassSessioncoolDownInfoDuration((int) Math.round(duration*cdtp));
//						classSession.setExerClassSessioncoolDownInfoMaxHRBpm(max);
//						classSession.setExerClassSessioncoolDownInfoMinHRBpm(min);
//						classSession.setExerClassSessioncoolDownInfoAverageHRBpm((double) avg);
//						
//						
//						classSessions.add(classSession);
//						countClass++;
//					}
//					break;
//					
//				case 2:
//					if(countGame<exergame+N){
//						//dovrebbe essere sempre un array
//						
//						exGame.setExerGameSessiondate(actual);
//						cal.set(Calendar.HOUR_OF_DAY, r.nextInt(23));
//						cal.set(Calendar.MINUTE,r.nextInt(59));
//						String start=DateMgt.getReadableTime(cal);
//						exGame.setExerGameSessionstartTime(start);
//						int duration=20+r.nextInt(45);
//						cal.add(Calendar.MINUTE, duration);
//						String end=DateMgt.getReadableTime(cal);
//						exGame.setExerGameSessionendTime(end);
//						exGame.setExerGameSessionduration(duration);
//						
//						exGame.setExerGameSessionexependitureObservationValue(350+r.nextInt(251));
//						
//						exGame.setExerGameSessionwarmingUpInfoDuration((int) Math.round(duration*wutp));
//						int min=wuMin;
//						int max=wuMax;
//						float avg=(max+min)/2;
//						max=max+r.nextInt(8);
//						
//						exGame.setExerGameSessionwarmingUpInfoDuration((int) Math.round(duration*wutp));
//						exGame.setExerGameSessionwarmingUpInfoMaxHRBpm(max);
//						exGame.setExerGameSessionwarmingUpInfoMinHRBpm(min);
//						exGame.setExerGameSessionwarmingUpInfoAverageHRBpm((double) avg);
//						
//						
//						min=aeMin;
//						max=aeMax;
//						avg=(max+min)/2;
//						max=max+r.nextInt(8);
//						exGame.setExerGameSessionmainInfoDuration((int) Math.round(duration*aetp));
//						exGame.setExerGameSessionmainInfoMaxHRBpm(max);
//						exGame.setExerGameSessionmainInfoMinHRBpm(min);
//						exGame.setExerGameSessionmainInfoAverageHRBpm((double) avg);
//						
//						
//						min=cdMin;
//						max=cdMax;
//						avg=(max+min)/2;
//						max=max+r.nextInt(8);
//						exGame.setExerGameSessioncoolDownInfoDuration((int) Math.round(duration*cdtp));
//						exGame.setExerGameSessioncoolDownInfoMaxHRBpm(max);
//						exGame.setExerGameSessioncoolDownInfoMinHRBpm(min);
//						exGame.setExerGameSessioncoolDownInfoAverageHRBpm((double) avg);
//
//						
//						exGame.setExerGameSessionscore(5+r.nextInt(25));
//						
////						sessions.add(exGame);
//						countGame++;
//					}
//					break;
//				case 3:
//					if(countActivity<activity+N){
//						
//						ActiveLifestylePASessionSS pa = new ActiveLifestylePASessionSS();
//						
//						pa.setActiveLifestylePASessiondate(actual);
//						cal.set(Calendar.HOUR_OF_DAY, r.nextInt(23));
//						cal.set(Calendar.MINUTE,r.nextInt(59));
//						String start=DateMgt.getReadableTime(cal);
//						pa.setActiveLifestylePASessionstartTime(start);
//						int duration=20+r.nextInt(45);
//						cal.add(Calendar.MINUTE, duration);
//						String end=DateMgt.getReadableTime(cal);
//						pa.setActiveLifestylePASessionendTime(end);
//						pa.setActiveLifestylePASessionduration(duration);
//						
//						pa.setActiveLifestylePASessionexpenditureObservationValue(350+r.nextInt(251));
//						
//						pa.setActiveLifestylePASessiontype(r.nextInt(ActivityType.values().length));
//						
//						pa.setActiveLifestylePASessionmonitored(r.nextInt(2));
//						
//						if (pa.getActiveLifestylePASessionmonitored()!=0){
//							pa.setActiveLifestylePASessionstepsNumber(6000+r.nextInt(4000));
//							pa.setActiveLifestylePASessionaverageHeartRate(80+r.nextInt(90));
//						}else{
//							pa.setActiveLifestylePASessionintensity(r.nextInt(ActiveLifestylePAIntensityType.values().length));
//							pa.setActiveLifestylePASessiondescription("in the park");
//						}
//						
//						
//						paSessions.add(pa);
//						
//						countActivity++;
//					}
//					break;
//				default:
//					break;
//				}
//			}
//
//			cal.add(Calendar.DAY_OF_MONTH, -i);
//		}
//			
//			result.put("exerClass", exClass);
//			result.put("exerGame", exGame);
//			result.put("paSessions", paProgress);
//			
//			
//			return result;
//		}else{
//			return null;
//		}
//		
//		
//	}
	
	
	
//	public static CardiacRehabilitationProgress getSessions(CardiacRehabilitionProgramme crp, int days, Date startDate){
//	PwLogger.printMethod();
//	List<ExerciseSession> sessions=new ArrayList<ExerciseSession>();
//	
//	Calendar cal=GregorianCalendar.getInstance();
//	cal.setTime(startDate);
//	
//	CurrentExerciseProgramme programme=crp.getCurrentExerciseProgramme();
//	int exerclass=programme.getNumberOfExerclass();
//	int exergame=programme.getNumberOfExerGame();
//	int activity=programme.getNumberOfActiveLifeStyleActivity();
//	
//	int weeks=((int) days/7);
//	
//	exerclass*=weeks;
//	exergame*=weeks;
//	activity*=weeks;
//	
//	int countClass=0;
//	int countGame=0;
//	int countActivity=0;
//	
//	Random r=new Random();
//	CardiacRehabilitationProgress crs=new CardiacRehabilitationProgress();
//	TrainingProfile tp=crp.getTrainingProfile();
//	
////	List<CardiacRehabilitationProgress> crps=new ArrayList<CardiacRehabilitationProgress>();
//	for (int i=0;i<days;i++){
//		cal.add(Calendar.DAY_OF_MONTH, i);
//		Date actual=cal.getTime();
//		int choice;
//		int perDay=0+r.nextInt(4);
//		for (int j=0;j<perDay;j++){
//			
//			choice=r.nextInt(8);
//			
//			switch (choice) {
//			case 0:
//				break;
//			case 1:
//				if(countClass<exerclass+N){
//					ExerClassSession exClass=new ExerClassSession();
//					exClass.setDate(actual);
//					cal.set(Calendar.HOUR_OF_DAY, r.nextInt(23));
//					cal.set(Calendar.MINUTE,r.nextInt(59));
//					String start=DateMgt.getReadableTime(cal);
//					exClass.setStartTime(start);
//					int duration=20+r.nextInt(45);
//					cal.add(Calendar.MINUTE, duration);
//					String end=DateMgt.getReadableTime(cal);
//					exClass.setEndTime(end);
//					exClass.setDuration(duration);
//					
//					EnergyExpenditureObservation kcal=new EnergyExpenditureObservation();
//					kcal.setValue(350+r.nextInt(251));
//					exClass.setEnergyExpenditure(kcal);
//					
//					TrainingPhaseInfo wu=new TrainingPhaseInfo();
//					wu.setDuration((int) Math.round(duration*wutp));
//					int min=tp.getWarmingHRzoneMin();
//					int max=tp.getWarmingHRzoneMax();
//					float avg=(max+min)/2;
//					max=max+r.nextInt(8);
//					wu.setMaxHR(max);
//					wu.setMinHR(min);
//					wu.setAverageHR(avg);
//					exClass.setWarmingDuration(wu);
//					
////					TrainingPhaseInfo st=new TrainingPhaseInfo();
////					st.setDuration((int) Math.round(duration*sttp));
////					min=tp.getStretchingHRzoneMin();
////					max=tp.getStretchingHRzoneMax();
////					avg=(max+min)/2;
////					max=max+r.nextInt(8);
////					st.setMaxHR(max);
////					st.setMinHR(min);
////					st.setAverageHR(avg);
////					exClass.setStretchingDuration(st);
//					
//					TrainingPhaseInfo ae=new TrainingPhaseInfo();
//					ae.setDuration((int) Math.round(duration*aetp));
//					min=tp.getMainHRzoneMin();
//					max=tp.getMainHRzoneMax();
//					avg=(max+min)/2;
//					max=max+r.nextInt(8);
//					ae.setMaxHR(max);
//					ae.setMinHR(min);
//					ae.setAverageHR(avg);
//					exClass.setMainDuration(ae);
//					
//					TrainingPhaseInfo cd=new TrainingPhaseInfo();
//					cd.setDuration((int) Math.round(duration*cdtp));
//					min=tp.getCooldownHRZoneMin();
//					max=tp.getCooldownHRZoneMax();
//					avg=(max+min)/2;
//					max=max+r.nextInt(8);
//					cd.setMaxHR(max);
//					cd.setMinHR(min);
//					cd.setAverageHR(avg);
//					exClass.setCoolDownDuration(cd);
//					
////
////					TrainingPhaseInfo rx=new TrainingPhaseInfo();
////					rx.setDuration((int) Math.round(duration*rxtp));
////					min=tp.getRelaxationHRzoneMin();
////					max=tp.getRelaxationHRzoneMax();
////					avg=(max+min)/2;
////					max=max+r.nextInt(8);
////					rx.setMaxHR(max);
////					rx.setMinHR(min);
////					rx.setAverageHR(avg);
////					exClass.setRelaxationDuration(rx);
//					
//					sessions.add(exClass);
//					countClass++;
//				}
//				break;
//				
//			case 2:
//				if(countGame<exergame+N){
//					ExerGameSession exGame=new ExerGameSession();
//					exGame.setDate(actual);
//					cal.set(Calendar.HOUR_OF_DAY, r.nextInt(23));
//					cal.set(Calendar.MINUTE,r.nextInt(59));
//					String start=DateMgt.getReadableTime(cal);
//					exGame.setStartTime(start);
//					int duration=20+r.nextInt(45);
//					cal.add(Calendar.MINUTE, duration);
//					String end=DateMgt.getReadableTime(cal);
//					exGame.setEndTime(end);
//					exGame.setDuration(duration);
//					
//					EnergyExpenditureObservation kcal=new EnergyExpenditureObservation();
//					kcal.setValue(350+r.nextInt(251));
//					exGame.setEnergyExpenditure(kcal);
//					
//					TrainingPhaseInfo wu=new TrainingPhaseInfo();
//					wu.setDuration((int) Math.round(duration*wutp));
//					int min=tp.getWarmingHRzoneMin();
//					int max=tp.getWarmingHRzoneMax();
//					float avg=(max+min)/2;
//					max=max+r.nextInt(8);
//					wu.setMaxHR(max);
//					wu.setMinHR(min);
//					wu.setAverageHR(avg);
//					exGame.setWarmingDuration(wu);
//					
////					TrainingPhaseInfo st=new TrainingPhaseInfo();
////					st.setDuration((int) Math.round(duration*sttp));
////					min=tp.getStretchingHRzoneMin();
////					max=tp.getStretchingHRzoneMax();
////					avg=(max+min)/2;
////					max=max+r.nextInt(8);
////					st.setMaxHR(max);
////					st.setMinHR(min);
////					st.setAverageHR(avg);
////					exGame.setStretchingDuration(st);
//					
//					TrainingPhaseInfo ae=new TrainingPhaseInfo();
//					ae.setDuration((int) Math.round(duration*aetp));
//					min=tp.getMainHRzoneMin();
//					max=tp.getMainHRzoneMax();
//					avg=(max+min)/2;
//					max=max+r.nextInt(8);
//					ae.setMaxHR(max);
//					ae.setMinHR(min);
//					ae.setAverageHR(avg);
//					exGame.setMainDuration(ae);
//					
////					exGame.setCoolDownDuration((int) Math.round(duration*cdtp));
////					
////					exGame.setRelaxationDuration((int) Math.round(duration*wutp));
//					
//					TrainingPhaseInfo cd=new TrainingPhaseInfo();
//					cd.setDuration((int) Math.round(duration*cdtp));
//					min=tp.getCooldownHRZoneMin();
//					max=tp.getCooldownHRZoneMax();
//					avg=(max+min)/2;
//					max=max+r.nextInt(8);
//					cd.setMaxHR(max);
//					cd.setMinHR(min);
//					cd.setAverageHR(avg);
//					exGame.setCoolDownDuration(cd);
//					
//
//					
//					exGame.setScore(5+r.nextInt(25));
//					
//					sessions.add(exGame);
//					countGame++;
//				}
//				break;
//			case 3:
//				if(countActivity<activity+N){
//					
//					ActiveLifestylePASession pa=new ActiveLifestylePASession();
//					pa.setDate(actual);
//					cal.set(Calendar.HOUR_OF_DAY, r.nextInt(23));
//					cal.set(Calendar.MINUTE,r.nextInt(59));
//					String start=DateMgt.getReadableTime(cal);
//					pa.setStartTime(start);
//					int duration=20+r.nextInt(45);
//					cal.add(Calendar.MINUTE, duration);
//					String end=DateMgt.getReadableTime(cal);
//					pa.setEndTime(end);
//					pa.setDuration(duration);
//					
//					EnergyExpenditureObservation kcal=new EnergyExpenditureObservation();
//					kcal.setValue(350+r.nextInt(251));
//					pa.setEnergyExpenditure(kcal);
//					
//					pa.setType(ActivityType.values()[r.nextInt(3)]);
//					
//					pa.setMonitored(!(r.nextInt(4)==0));
//					if (pa.isMonitored()){
//						pa.setStepsNumber(6000+r.nextInt(4000));
//						pa.setAverageHeartRate(120);
//					}else{
//						pa.setIntensity(ActiveLifestylePAIntensityType.MODERATE);
//						pa.setDescription("in the park");
//					}
//					
//					pa.setIntensity(ActiveLifestylePAIntensityType.values()[r.nextInt(3)]);
//					
//					sessions.add(pa);
//					
//					countActivity++;
//				}
//				break;
//			default:
//				break;
//			}
//		}
//
//		cal.add(Calendar.DAY_OF_MONTH, -i);
//	}
//	
//	crs.setExerciseSession(sessions);
//	
//	return crs;
//}
	
}
