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

import java.io.File;
import java.util.Date;

public class ExerciseSession{

	private Date date;

	private String startTime;

	private String endTime;

	private Integer duration;

	private String hr_file;

	private EnergyExpenditureObservation energyExpenditure;

	private File file;

	private CardiacRehabilitationProgress cardiacRehabilitationProgress;
	
	private TrainingProfile trainingProfile;
	
	private boolean acceptable;

	
	
	public ExerciseSession() {
		super();
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getHr_file() {
		return hr_file;
	}

	public void setHr_file(String hr_file) {
		this.hr_file = hr_file;
	}

	public EnergyExpenditureObservation getEnergyExpenditure() {
		return energyExpenditure;
	}

	public void setEnergyExpenditure(EnergyExpenditureObservation energyExpenditure) {
		this.energyExpenditure = energyExpenditure;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public CardiacRehabilitationProgress getCardiacRehabilitationProgress() {
		return cardiacRehabilitationProgress;
	}

	public void setCardiacRehabilitationProgress(CardiacRehabilitationProgress cardiacRehabilitationProgress) {
		this.cardiacRehabilitationProgress = cardiacRehabilitationProgress;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public boolean isValid() {
//		return (
//			date!=null &&
//			startTime !=null && 
//			endTime !=null && acceptable
//				);
		
		return (
				date!=null &&
				duration != null &&
				duration >=0
					);
	}


	public TrainingProfile getTrainingProfile() {
		return trainingProfile;
	}


	public void setTrainingProfile(TrainingProfile trainingProfile) {
		this.trainingProfile = trainingProfile;
	}


	public boolean isAcceptable() {
		return acceptable;
	}


	public void setAcceptable(boolean acceptable) {
		this.acceptable = acceptable;
	}



	
	

}
