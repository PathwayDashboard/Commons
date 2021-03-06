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
package it.eng.pathway.fake.model;

import java.util.Arrays;
import java.util.List;

import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionCoolDownInfohrRangeSubSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessioncoolDownInfoSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionmainInfoSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionmainInfohrRange;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionwarmingUpInfoSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionwarmingUpInfohrRangeSubSubSubsection;
import it.eng.pathway.utility.DateMgt;
import it.eng.pathway.utility.StringUtil;

public class ExerClassSession extends ExerciseSession {

	private StatusType status;

	private TrainingPhaseInfo warmingDuration;

//	private TrainingPhaseInfo stretchingDuration;

	private TrainingPhaseInfo mainDuration;

	private TrainingPhaseInfo coolDownDuration;

//	private TrainingPhaseInfo relaxationDuration;

	private SatisfactionLevelType sessionSatisfactionLevel;

	private List executedExercises;

	private StatusType statusType;

	private SatisfactionLevelType satisfactionLevelType;

	private HRZone hRZone;

	private ExerClassExercise[] exerClassExercise;

	private TrainingPhaseInfo trainingPhaseInfo;
	
	private RatedPerceivedEffort rpe;
	

	public ExerClassSession() {
		super();
	}
	
	public ExerClassSession (CardiacRehabilitationProgressExerClassSessionSubsection hdmsClassSession){ //per conservare l'ereditarietà 
		super();
		setDate(hdmsClassSession.getDate());
		setDuration(hdmsClassSession.getDuration());
//		setEndTime(hdmsClassSession.getCrProgressExerClassSessionEndTime());
		if (hdmsClassSession.getEnergyExpenditure() != null)
			setEnergyExpenditure(new EnergyExpenditureObservation(hdmsClassSession.getEnergyExpenditure().getKcal()));
//		setStartTime(hdmsClassSession.getCrProgressExerClassSessionStartTime());
		
		setStartTime(DateMgt.getReadableTime(hdmsClassSession.getStartTime()));
		setEndTime(DateMgt.getReadableTime(hdmsClassSession.getEndTime()));
		
		warmingDuration=new TrainingPhaseInfo();
		CardiacRehabilitationProgressExerClassSessionwarmingUpInfoSubSubsection wu=hdmsClassSession.getWarmingUpInfo();
		warmingDuration.setDuration(wu.getDuration());
		Double val=wu.getAverageHRBpm()!=null ?  wu.getAverageHRBpm() : 0; //TODO issue to report
		warmingDuration.setAverageHR(val!=null ? val.floatValue() : 0);
		CardiacRehabilitationProgressExerClassSessionwarmingUpInfohrRangeSubSubSubsection wuR = wu.getHrRange();
		warmingDuration.setMinHR(wuR.getMinBpm());
		warmingDuration.setMaxHR(wuR.getMaxBpm());
		
		mainDuration=new TrainingPhaseInfo();
		CardiacRehabilitationProgressExerClassSessionmainInfoSubSubsection main=hdmsClassSession.getMainInfo();
		mainDuration.setDuration(main.getDuration());
		val=main.getAverageHRBpm();
		mainDuration.setAverageHR(val!=null ? val.floatValue() : 0);
		CardiacRehabilitationProgressExerClassSessionmainInfohrRange mainR = main.getHrRange();
		mainDuration.setMinHR(mainR.getMinBpm());
		mainDuration.setMaxHR(mainR.getMaxBpm());
		
		coolDownDuration=new TrainingPhaseInfo();
		CardiacRehabilitationProgressExerClassSessioncoolDownInfoSubSubsection cd=hdmsClassSession.getCoolDownInfo();
		coolDownDuration.setDuration(cd.getDuration());
		val=cd.getAverageHRBpm();
		coolDownDuration.setAverageHR(val!=null ? val.floatValue() : 0);
		CardiacRehabilitationProgressExerClassSessionCoolDownInfohrRangeSubSubSubsection cdR = cd.getHrRange();
		coolDownDuration.setMinHR(cdR.getMinBpm());
		coolDownDuration.setMaxHR(cdR.getMaxBpm());
		
//		executedExercises=hdmsClassSession.getExerClassSessionExerClassExercisess(); //old version
//		executedExercises=hdmsClassSession.getExecutedExerClassSessionExercisess(); // richiede una nuova chiamata al server
		Integer pos;
		pos=hdmsClassSession.getStatus();
		if (pos!=null && pos<StatusType.values().length)
			status=StatusType.values()[pos]; //non è un'enumeration. Provo a prendere l'Integer che c'è e creando un array dalla nostra enumeration ne prend il valore
		
		pos=hdmsClassSession.getSessionSatisfactionLevel();
		if (pos!=null && pos<SatisfactionLevelType.values().length)
			sessionSatisfactionLevel=SatisfactionLevelType.values()[pos]; //stesso ragionamento
		
		TrainingProfile tprofile = new TrainingProfile(hdmsClassSession.getLinkedTrainingProfile());
		
//		setTrainingProfile(creteFakeTrainingProfile()); // - questo dovrebbe essere compreso nel
		setTrainingProfile(tprofile);
	
//		try {
//			setStatusType(StatusType.values()[hdmsClassSession.getStatus()-1]); //enumeration di HDMS 1-based
//		} catch (Exception e1) {
//			setStatusType(StatusType.values()[0]); //enumeration di HDMS 1-based
//		}
//			
//		
//		try {
//				setRpe(RatedPerceivedEffort.values()[hdmsClassSession.getRpe()-1]);
//		} catch (Exception e) {
//			setRpe(RatedPerceivedEffort.values()[4]);
//		}
//		
//		try {
//			setSatisfactionLevelType(SatisfactionLevelType.values()[hdmsClassSession.getSessionSatisfactionLevel()-1]);
//		} catch (Exception e) {
//			setSatisfactionLevelType(SatisfactionLevelType.values()[2]);
//		}
//		
		
		try {
			setStatusType(StatusType.values()[hdmsClassSession.getStatus()]); //enumeration di HDMS 0-based
		} catch (Exception e1) {
			setStatusType(StatusType.values()[0]); //enumeration di HDMS 1-based
		}
			
		
		try {
				setRpe(RatedPerceivedEffort.values()[hdmsClassSession.getRpe()]);
		} catch (Exception e) {
			setRpe(RatedPerceivedEffort.values()[4]);
		}
		
		try {
			setSatisfactionLevelType(SatisfactionLevelType.values()[hdmsClassSession.getSessionSatisfactionLevel()]);
		} catch (Exception e) {
			setSatisfactionLevelType(SatisfactionLevelType.values()[2]);
		}
			
		
		
		String file=hdmsClassSession.getHrFile();
		if (StringUtil.isValid(file))
			this.setHr_file(file);
		
		this.setAcceptable(hdmsClassSession.getAcceptable()!=null ? hdmsClassSession.getAcceptable() : false);
	}
	

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public TrainingPhaseInfo getWarmingDuration() {
		return warmingDuration;
	}

	public void setWarmingDuration(TrainingPhaseInfo warmingDuration) {
		this.warmingDuration = warmingDuration;
	}

	public TrainingPhaseInfo getMainDuration() {
		return mainDuration;
	}

	public void setMainDuration(TrainingPhaseInfo mainDuration) {
		this.mainDuration = mainDuration;
	}

	public TrainingPhaseInfo getCoolDownDuration() {
		return coolDownDuration;
	}

	public void setCoolDownDuration(TrainingPhaseInfo coolDownDuration) {
		this.coolDownDuration = coolDownDuration;
	}

	public SatisfactionLevelType getSessionSatisfactionLevel() {
		return sessionSatisfactionLevel;
	}

	public void setSessionSatisfactionLevel(SatisfactionLevelType sessionSatisfactionLevel) {
		this.sessionSatisfactionLevel = sessionSatisfactionLevel;
	}

	public List getExecutedExercises() {
		return executedExercises;
	}

	public void setExecutedExercises(List executedExercises) {
		this.executedExercises = executedExercises;
	}

	public StatusType getStatusType() {
		return statusType;
	}

	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}

	public SatisfactionLevelType getSatisfactionLevelType() {
		return satisfactionLevelType;
	}

	public void setSatisfactionLevelType(SatisfactionLevelType satisfactionLevelType) {
		this.satisfactionLevelType = satisfactionLevelType;
	}

	public HRZone gethRZone() {
		return hRZone;
	}

	public void sethRZone(HRZone hRZone) {
		this.hRZone = hRZone;
	}

	public ExerClassExercise[] getExerClassExercise() {
		return exerClassExercise;
	}

	public void setExerClassExercise(ExerClassExercise[] exerClassExercise) {
		this.exerClassExercise = exerClassExercise;
	}

	public TrainingPhaseInfo getTrainingPhaseInfo() {
		return trainingPhaseInfo;
	}

	public void setTrainingPhaseInfo(TrainingPhaseInfo trainingPhaseInfo) {
		this.trainingPhaseInfo = trainingPhaseInfo;
	}



	public static TrainingProfile creteFakeTrainingProfile() {
		// TODO al momento manca il training profile agganciato alla sessione,
		// quindi me lo creo a mano
		TrainingProfile profile = new TrainingProfile();
		profile.setWarmingUpDuration(5);
		HRZone hrs = new HRZone();
		hrs.setMinimumHR(90);
		hrs.setMaximumHR(110);
		profile.setWuHR(hrs);

		profile.setMainDuration(35);
		hrs = new HRZone();
		hrs.setMinimumHR(120);
		hrs.setMaximumHR(180);
		profile.setAeHR(hrs);

		profile.setCooldownDuration(5);
		hrs = new HRZone();
		hrs.setMinimumHR(90);
		hrs.setMaximumHR(120);
		profile.setCdHR(hrs);

		return profile;
	}

	public RatedPerceivedEffort getRpe() {
		return rpe;
	}

	public void setRpe(RatedPerceivedEffort rpe) {
		this.rpe = rpe;
	}

	@Override
	public String toString() {
		return "ExerClassSession [status=" + status + ", warmingDuration=" + warmingDuration + ", mainDuration="
				+ mainDuration + ", coolDownDuration=" + coolDownDuration + ", sessionSatisfactionLevel="
				+ sessionSatisfactionLevel + ", executedExercises=" + executedExercises + ", statusType=" + statusType
				+ ", satisfactionLevelType=" + satisfactionLevelType + ", hRZone=" + hRZone + ", exerClassExercise="
				+ Arrays.toString(exerClassExercise) + ", trainingPhaseInfo=" + trainingPhaseInfo + ", rpe=" + rpe
				+ ", getDuration()=" + getDuration() + ", getEnergyExpenditure()=" + getEnergyExpenditure()
				+ ", getStartTime()=" + getStartTime() + ", getEndTime()=" + getEndTime() + "]";
	}
	

}
