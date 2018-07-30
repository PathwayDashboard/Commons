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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import io.swagger.client.model.CardiacRehabilitationProgrammeExerciseProgrammeSubSection;
import io.swagger.client.model.CardiacRehabilitationProgrammeSection;
import it.eng.pathway.utility.ExerciseProgrammeComparator;

public class CardiacRehabilitationProgramme {

	private Date creationDate;

	private List<ExerciseProgramme> exerciseProgrammes;

	private PhysicalActivityProgramme physicalActivityProgramme;

	private BehaviouralChangeProgramme behaviouralChangeProgramme;

	private ExerciseProgramme currentExerciseProgramme;

//	private TrainingProfile trainingProfile;

//	private PreScreeningQuestionnaire preScreeningQuestionnaire;

	private ExerClassDescription exerClassDescription;
	
	
	
	public CardiacRehabilitationProgramme() {
		super();
	}

	public CardiacRehabilitationProgramme(CardiacRehabilitationProgrammeSection hdmsProg) {
		
		this.creationDate = hdmsProg!=null ? hdmsProg.getCreationDate() : null;
		
		List<CardiacRehabilitationProgrammeExerciseProgrammeSubSection> hdmsExs = hdmsProg.getExerciseProgrammes();
		
		List<ExerciseProgramme> exs=new ArrayList<ExerciseProgramme>();
		if (hdmsExs!=null){
			ExerciseProgrammeComparator comparator = new ExerciseProgrammeComparator();
			Collections.sort(hdmsExs, comparator);
			
//			if(this.creationDate==null && hdmsExs.size()>0){
				this.creationDate = hdmsExs.get(0).getDate();
//			}
			
			for (CardiacRehabilitationProgrammeExerciseProgrammeSubSection curr : hdmsExs) {
				ExerciseProgramme exProg = new ExerciseProgramme(curr);
				exs.add(exProg);
			}
		}
		this.exerciseProgrammes=exs;
		
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public PhysicalActivityProgramme getPhysicalActivityProgramme() {
		return physicalActivityProgramme;
	}

	public void setPhysicalActivityProgramme(PhysicalActivityProgramme physicalActivityProgramme) {
		this.physicalActivityProgramme = physicalActivityProgramme;
	}

	public BehaviouralChangeProgramme getBehaviouralChangeProgramme() {
		return behaviouralChangeProgramme;
	}

	public void setBehaviouralChangeProgramme(BehaviouralChangeProgramme behaviouralChangeProgramme) {
		this.behaviouralChangeProgramme = behaviouralChangeProgramme;
	}

	public ExerciseProgramme getCurrentExerciseProgramme() {
		return currentExerciseProgramme;
	}

	public void setCurrentExerciseProgramme(ExerciseProgramme currentExerciseProgramme) {
		this.currentExerciseProgramme = currentExerciseProgramme;
	}


//	public TrainingProfile getTrainingProfile() {
//		return trainingProfile;
//	}
//
//	public void setTrainingProfile(TrainingProfile trainingProfile) {
//		this.trainingProfile = trainingProfile;
//	}

//	public PreScreeningQuestionnaire getPreScreeningQuestionnaire() {
//		return preScreeningQuestionnaire;
//	}
//
//	public void setPreScreeningQuestionnaire(PreScreeningQuestionnaire preScreeningQuestionnaire) {
//		this.preScreeningQuestionnaire = preScreeningQuestionnaire;
//	}

	public ExerClassDescription getExerClassDescription() {
		return exerClassDescription;
	}

	public void setExerClassDescription(ExerClassDescription exerClassDescription) {
		this.exerClassDescription = exerClassDescription;
	}


	public HealthFitnessAssessmentPreScreeningQuestionnaire getHealthFitnessAssessmentPreScreeningQuestionnaire() {
		return healthFitnessAssessmentPreScreeningQuestionnaire;
	}

	public void setHealthFitnessAssessmentPreScreeningQuestionnaire(
			HealthFitnessAssessmentPreScreeningQuestionnaire healthFitnessAssessmentPreScreeningQuestionnaire) {
		this.healthFitnessAssessmentPreScreeningQuestionnaire = healthFitnessAssessmentPreScreeningQuestionnaire;
	}

	private HealthFitnessAssessmentPreScreeningQuestionnaire healthFitnessAssessmentPreScreeningQuestionnaire;


	public List<ExerciseProgramme> getExerciseProgrammes() {
		return exerciseProgrammes;
	}

	public void setExerciseProgrammes(List<ExerciseProgramme> exerciseProgramme) {
		this.exerciseProgrammes = exerciseProgramme;
	}
	
	

}
