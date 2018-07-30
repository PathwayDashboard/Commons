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

import java.io.Serializable;

import org.joda.time.Minutes;

import io.swagger.client.model.CardiacRehabilitationProgressActiveLifestylePASessionSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressActiveLifestylePASessionminutesInZoneSubSubSection;
import it.eng.pathway.utility.DateMgt;

public class ActiveLifestylePASession extends ExerciseSession implements Comparable<ActiveLifestylePASession>,Serializable {

	private static final long serialVersionUID = 8648147965678498685L;

	private Integer averageHeartRate;

	private Integer stepsNumber;
	
	private ActivityType type;
	
	private String typeLabel;
	
	private boolean monitored;
	
	private String description;
	
	private ActiveLifestylePAIntensityType intensity;
	
	private Integer minIn050;
	
	private Integer minIn5160;
	
	private Integer minIn6170;
	
	private Integer minIn7180;
	
	private Integer minIn8190;
	
	private Integer minIn91100;
	
	private Integer minIn101;
	

	public ActiveLifestylePASession() {
		super();
	}

	public ActiveLifestylePASession(CardiacRehabilitationProgressActiveLifestylePASessionSubsection pa) {
		super();
		setDate(pa.getDate());
		setDuration(pa.getDuration());
//		setEndTime(pa.getCrProgressActiveLifestylePASessionEndTime());
		if (pa.getEnergyExpenditure()!=null)
			setEnergyExpenditure(new EnergyExpenditureObservation(pa.getEnergyExpenditure().getKcal()));
//		setStartTime(pa.getCrProgressActiveLifestylePASessionStartTime());
		if(pa.getStartTime() !=null)
			setStartTime(DateMgt.getReadableTime(pa.getStartTime()));
		if(pa.getEndTime() != null)
			setEndTime(DateMgt.getReadableTime(pa.getEndTime()));
		
		this.averageHeartRate=pa.getAverageHeartRate();
		this.description=pa.getDescription();
		
		Integer pos;
		pos=pa.getIntensity();
		if(pos!=null)
			this.intensity=ActiveLifestylePAIntensityType.values()[pos];
		try{
			this.monitored=pa.getMonitored();
		}catch (Exception e){
			this.monitored=false;
		}
		
		this.stepsNumber=pa.getStepsNumber();
		
		pos=pa.getType();
		if(pos!=null)
		this.type=ActivityType.values()[pos];
		
		this.setAcceptable(pa.getAcceptable() != null ? pa.getAcceptable() : false);
		
		
		//TODO
//		aggiungere i setting delle zone MS
		CardiacRehabilitationProgressActiveLifestylePASessionminutesInZoneSubSubSection mins = pa.getMinutesInZone();
		if (mins!=null){
			this.minIn050 = mins.getZone050() != null ? mins.getZone050() : 0;
			this.minIn5160 = mins.getZone5160() != null ? mins.getZone5160() : 0; 
			this.minIn6170 = mins.getZone6170() != null ? mins.getZone6170() : 0; 
			this.minIn7180 = mins.getZone7180() != null ? mins.getZone7180() : 0; 
			this.minIn8190 = mins.getZone8190() != null ? mins.getZone8190() : 0; 
			this.minIn91100 = mins.getZone91100() != null ? mins.getZone91100() : 0; 
			this.minIn101 = mins.getZone101() != null ? mins.getZone101() : 0;
		}
		
	}

	public Integer getAverageHeartRate() {
		return averageHeartRate;
	}

	public void setAverageHeartRate(Integer averageHeartRate) {
		this.averageHeartRate = averageHeartRate;
	}

	public Integer getStepsNumber() {
		return stepsNumber;
	}

	public void setStepsNumber(Integer stepsNumber) {
		this.stepsNumber = stepsNumber;
	}

	public ActivityType getType() {
		return type;
	}

	public void setType(ActivityType type) {
		this.type = type;
	}

	public boolean isMonitored() {
		return monitored;
	}

	public void setMonitored(boolean monitored) {
		this.monitored = monitored;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ActiveLifestylePAIntensityType getIntensity() {
		return intensity;
	}

	public void setIntensity(ActiveLifestylePAIntensityType intensity) {
		this.intensity = intensity;
	}

	@Override
	public String toString() {
		return "ActiveLifestylePASession [averageHeartRate=" + averageHeartRate + ", stepsNumber=" + stepsNumber
				+ ", type=" + type + ", monitored=" + monitored + ", description=" + description + ", intensity="
				+ intensity + ", getDate()=" + getDate() + ", getDuration()=" + getDuration() + ", getStart_time()="
				+ getStartTime() + ", getEnd_time()=" + getEndTime() + "]";
	}

	@Override
	public int compareTo(ActiveLifestylePASession o) {
//		return this.getDate().compareTo(o.getDate()); //crescente
		return o.getDate().compareTo(this.getDate()); //DEcrescente
	}

	public Integer getMinIn050() {
		return minIn050;
	}

	public void setMinIn050(Integer minIn050) {
		this.minIn050 = minIn050;
	}

	public Integer getMinIn5160() {
		return minIn5160;
	}

	public void setMinIn5160(Integer minIn5160) {
		this.minIn5160 = minIn5160;
	}

	public Integer getMinIn6170() {
		return minIn6170;
	}

	public void setMinIn6170(Integer minIn6170) {
		this.minIn6170 = minIn6170;
	}

	public Integer getMinIn7180() {
		return minIn7180;
	}

	public void setMinIn7180(Integer minIn7180) {
		this.minIn7180 = minIn7180;
	}

	public Integer getMinIn8190() {
		return minIn8190;
	}

	public void setMinIn8190(Integer minIn8190) {
		this.minIn8190 = minIn8190;
	}

	public Integer getMinIn91100() {
		return minIn91100;
	}

	public void setMinIn91100(Integer minIn91100) {
		this.minIn91100 = minIn91100;
	}

	public Integer getMinIn101() {
		return minIn101;
	}

	public void setMinIn101(Integer minIn101) {
		this.minIn101 = minIn101;
	}

	public String getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(String typeLabel) {
		this.typeLabel = typeLabel;
	}
	
	

}
