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

public class BehaviouralChangeProgress {

	private BheaviouralStageType behaviouralChangeStage;

	private Patient patient;

	private LifeStyleAssessment[] lifeStyleAssessment;

	public BheaviouralStageType getBehaviouralChangeStage() {
		return behaviouralChangeStage;
	}

	public void setBehaviouralChangeStage(BheaviouralStageType behaviouralChangeStage) {
		this.behaviouralChangeStage = behaviouralChangeStage;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public LifeStyleAssessment[] getLifeStyleAssessment() {
		return lifeStyleAssessment;
	}

	public void setLifeStyleAssessment(LifeStyleAssessment[] lifeStyleAssessment) {
		this.lifeStyleAssessment = lifeStyleAssessment;
	}

	public BheaviouralStageType getBheaviouralStageType() {
		return bheaviouralStageType;
	}

	public void setBheaviouralStageType(BheaviouralStageType bheaviouralStageType) {
		this.bheaviouralStageType = bheaviouralStageType;
	}

	private BheaviouralStageType bheaviouralStageType;

}
