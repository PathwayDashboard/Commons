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

import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessioncoolDownInfoSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionmainInfoSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionwarmingUpInfoSubSubsection;
import it.eng.pathway.utility.DateMgt;
import it.eng.pathway.utility.StringUtil;

public class ExerGameSession extends ExerciseSession {

	private Integer score;

	private StatusType statusType;

	private TrainingPhaseInfo warmingDuration;


	private TrainingPhaseInfo mainDuration;

	private TrainingPhaseInfo coolDownDuration;


	private SatisfactionLevelType satisfactionLevelType;

	private TrainingPhaseInfo trainingPhaseInfo;
	
	private RatedPerceivedEffort rpe;
	
	
	public ExerGameSession() {
		super();
	}
	
	public ExerGameSession(CardiacRehabilitationProgressExerGameSessionSubsection hdmsGame) {
		super();
		try {
			setDate(hdmsGame.getDate());
			setDuration(hdmsGame.getDuration());
//		setEndTime(hdmsGame.getCrProgressExerGameSessionEndTime());
			if (hdmsGame.getEnergyExpenditure()!=null)
				setEnergyExpenditure(new EnergyExpenditureObservation(hdmsGame.getEnergyExpenditure().getKcal()));
//		setStartTime(hdmsGame.getCrProgressExerGameSessionStartTime());
			
			setStartTime(DateMgt.getReadableTime(hdmsGame.getStartTime()));
			setEndTime(DateMgt.getReadableTime(hdmsGame.getEndTime()));
			
			warmingDuration=new TrainingPhaseInfo();
			CardiacRehabilitationProgressExerGameSessionwarmingUpInfoSubSubsection wu=hdmsGame.getWarmingUpInfo();
			warmingDuration.setDuration(wu.getDuration());
			Double val=wu.getAverageHRBpm()!=null ? (double) wu.getAverageHRBpm() : 0; 
			warmingDuration.setAverageHR(val!=null ? val.floatValue() : 0);
			warmingDuration.setMinHR(wu.getHrRange().getMinBpm());
			warmingDuration.setMaxHR(wu.getHrRange().getMaxBpm());
			
			mainDuration=new TrainingPhaseInfo();
			
			CardiacRehabilitationProgressExerGameSessionmainInfoSubSubsection main=hdmsGame.getMainInfo();
			mainDuration.setDuration(main.getDuration());
			val=main.getAverageHRBpm();
			mainDuration.setAverageHR(val!=null ? val.floatValue() : 0);
			mainDuration.setMinHR(main.getHrRange().getMinBpm());
			mainDuration.setMaxHR(main.getHrRange().getMaxBpm());
			
			coolDownDuration=new TrainingPhaseInfo();
			CardiacRehabilitationProgressExerGameSessioncoolDownInfoSubSubsection cd=hdmsGame.getCoolDownInfo();
			coolDownDuration.setDuration(cd.getDuration());
			val=cd.getAverageHRBpm();
			coolDownDuration.setAverageHR(val!=null ? val.floatValue() : 0);
			coolDownDuration.setMinHR(cd.getHrRange().getMinBpm());
			coolDownDuration.setMaxHR(cd.getHrRange().getMaxBpm());
			
			
			Integer pos;
			pos=hdmsGame.getStatus();
			if (pos!=null)
				statusType=StatusType.values()[pos]; //non è un'enumeration. Provo a prendere l'Integer che c'è e creando un array dalla nostra enumeration ne prend il valore
			
			pos=hdmsGame.getSessionSatisfactionLevel();
			if (pos!=null)
				satisfactionLevelType=SatisfactionLevelType.values()[pos]; //stesso ragionamento
			
			score=hdmsGame.getScore();
			
//				try {
//					setStatusType(StatusType.values()[hdmsGame.getStatus()-1]); //enumeration di HDMS 1-based
//				} catch (Exception e) {
//					setStatusType(StatusType.values()[0]); //enumeration di HDMS 1-based
//
//				}
//			
//				try {
//					setRpe(RatedPerceivedEffort.values()[hdmsGame.getRpe()-1]);
//				} catch (Exception e) {
//					setRpe(RatedPerceivedEffort.values()[4]);
//				}
//				
//			
//				try {
//					setSatisfactionLevelType(SatisfactionLevelType.values()[hdmsGame.getSessionSatisfactionLevel()-1]);
//				} catch (Exception e) {
//					setSatisfactionLevelType(SatisfactionLevelType.values()[2]);
//				}
				
				
				try {
					setStatusType(StatusType.values()[hdmsGame.getStatus()]); //enumeration di HDMS 1-based
				} catch (Exception e) {
					setStatusType(StatusType.values()[0]); //enumeration di HDMS 1-based

				}
			
				try {
					setRpe(RatedPerceivedEffort.values()[hdmsGame.getRpe()]);
				} catch (Exception e) {
					setRpe(RatedPerceivedEffort.values()[4]);
				}
				
			
				try {
					setSatisfactionLevelType(SatisfactionLevelType.values()[hdmsGame.getSessionSatisfactionLevel()]);
				} catch (Exception e) {
					setSatisfactionLevelType(SatisfactionLevelType.values()[2]);
				}
				
			
			TrainingProfile tprofile = new TrainingProfile(hdmsGame.getLinkedTrainingProfile());
//			setTrainingProfile(creteFakeTrainingProfile()); //TODO - questo dovrebbe essere compreso nel
			setTrainingProfile(tprofile);
			
			String file=hdmsGame.getHrFile();
			if (StringUtil.isValid(file))
				this.setHr_file(file);
			
			this.setAcceptable(hdmsGame.getAcceptable()!=null ? hdmsGame.getAcceptable() : false);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public StatusType getStatusType() {
		return statusType;
	}

	public void setStatusType(StatusType status) {
		this.statusType = status;
	}


	public TrainingPhaseInfo getCoolDownDuration() {
		return coolDownDuration;
	}

	public void setCoolDownDuration(TrainingPhaseInfo coolDownDuration) {
		this.coolDownDuration = coolDownDuration;
	}


	public SatisfactionLevelType getSatisfactionLevelType() {
		return satisfactionLevelType;
	}

	public void setSatisfactionLevelType(SatisfactionLevelType sessionSatisfactionLevel) {
		this.satisfactionLevelType = sessionSatisfactionLevel;
	}

	public TrainingPhaseInfo getTrainingPhaseInfo() {
		return trainingPhaseInfo;
	}

	public void setTrainingPhaseInfo(TrainingPhaseInfo trainingPhaseInfo) {
		this.trainingPhaseInfo = trainingPhaseInfo;
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


	public RatedPerceivedEffort getRpe() {
		return rpe;
	}

	public void setRpe(RatedPerceivedEffort rpe) {
		this.rpe = rpe;
	}

	@Override
	public String toString() {
		return "ExerGameSession [score=" + score + ", statusType=" + statusType + ", warmingDuration=" + warmingDuration
				+ ", mainDuration=" + mainDuration + ", coolDownDuration=" + coolDownDuration
				+ ", satisfactionLevelType=" + satisfactionLevelType + ", trainingPhaseInfo=" + trainingPhaseInfo
				+ ", rpe=" + rpe + ", getDate()=" + getDate() + ", getEnergyExpenditure()=" + getEnergyExpenditure()
				+ ", getStartTime()=" + getStartTime() + ", getEndTime()=" + getEndTime() + "]";
	}

	
	

}
