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

import io.swagger.client.model.CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfileSubSubsection;
import io.swagger.client.model.CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfileSubSubsection;

public class TrainingProfile {
	
	private Integer warmingUpDuration;
	private Integer mainDuration;
	private Integer cooldownDuration;
	
	private HRZone wuHR;
	private HRZone aeHR;
	private HRZone cdHR;
	
	
	
	public TrainingProfile() {
		super();
	}
	public TrainingProfile(
			CardiacRehabilitationProgressExerClassSessionlinkedTrainingProfileSubSubsection linkedTrainingProfile) {
		if (linkedTrainingProfile!=null){
			this.warmingUpDuration=linkedTrainingProfile.getWarmingUpDuration();
			this.mainDuration=linkedTrainingProfile.getMainDuration();
			this.cooldownDuration=linkedTrainingProfile.getCoolDownDuration();
			
			this.wuHR=(new HRZone(linkedTrainingProfile.getWarmingUpHRZone().getMinBpm(),linkedTrainingProfile.getWarmingUpHRZone().getMaxBpm()));
			this.aeHR=(new HRZone(linkedTrainingProfile.getMainHRZone().getMinBpm(),linkedTrainingProfile.getMainHRZone().getMaxBpm()));
			this.cdHR=(new HRZone(linkedTrainingProfile.getCoolDownHRZone().getMinBpm(),linkedTrainingProfile.getCoolDownHRZone().getMaxBpm()));
		}
			
	}
	
	public TrainingProfile(
			CardiacRehabilitationProgressExerGameSessionExecutedExerciselinkedTrainingProfileSubSubsection linkedTrainingProfile) {
		if (linkedTrainingProfile!=null){
			this.warmingUpDuration=linkedTrainingProfile.getWarmingUpDuration();
			this.mainDuration=linkedTrainingProfile.getMainDuration();
			this.cooldownDuration=linkedTrainingProfile.getCoolDownDuration();
			
			this.wuHR=(new HRZone(linkedTrainingProfile.getWarmingUpHRZone().getMinBpm(),linkedTrainingProfile.getWarmingUpHRZone().getMaxBpm()));
			this.aeHR=(new HRZone(linkedTrainingProfile.getMainHRZone().getMinBpm(),linkedTrainingProfile.getMainHRZone().getMaxBpm()));
			this.cdHR=(new HRZone(linkedTrainingProfile.getCoolDownHRZone().getMinBpm(),linkedTrainingProfile.getCoolDownHRZone().getMaxBpm()));
		}
			
	}
	
	public Integer getWarmingUpDuration() {
		return warmingUpDuration;
	}
	public void setWarmingUpDuration(Integer wuDuration) {
		this.warmingUpDuration = wuDuration;
	}
	public Integer getMainDuration() {
		return mainDuration;
	}
	public void setMainDuration(Integer aeDuration) {
		this.mainDuration = aeDuration;
	}
	public Integer getCooldownDuration() {
		return cooldownDuration;
	}
	public void setCooldownDuration(Integer cdDuration) {
		this.cooldownDuration = cdDuration;
	}
	public HRZone getWuHR() {
		return wuHR;
	}
	public void setWuHR(HRZone wuHR) {
		this.wuHR = wuHR;
	}
	public HRZone getAeHR() {
		return aeHR;
	}
	public void setAeHR(HRZone aeHR) {
		this.aeHR = aeHR;
	}
	public HRZone getCdHR() {
		return cdHR;
	}
	public void setCdHR(HRZone cdHR) {
		this.cdHR = cdHR;
	}
	public int getWarmingHRzoneMax() {
		return wuHR.getMaximumHR();
	}
	public int getWarmingHRzoneMin() {
		return wuHR.getMinimumHR();
	}
	
	public int getMainHRzoneMax() {
		return aeHR.getMaximumHR();
	}
	public int getMainHRzoneMin() {
		return aeHR.getMinimumHR();
	}
	public int getCooldownHRZoneMax() {
		return cdHR.getMaximumHR();
	}
	public int getCooldownHRZoneMin() {
		return cdHR.getMinimumHR();
	}
	

}
