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

public class BehaviouralChangeProgramme {

	private Integer assessmentPeriod;

	private Integer personalGoals;

	private Integer recommendedGoals;

	private CardiacRehabilitationProgramme cardiacRehabilitationProgramme;


	private LifeStyleAssessmentQuestionnaire[] lifeStyleAssessmentQuestionnaire;

	private Patient patient;

	private GoodHabit[] goodHabit;

	public Integer getAssessmentPeriod() {
		return assessmentPeriod;
	}

	public void setAssessmentPeriod(Integer assessmentPeriod) {
		this.assessmentPeriod = assessmentPeriod;
	}

	public Integer getPersonalGoals() {
		return personalGoals;
	}

	public void setPersonalGoals(Integer personalGoals) {
		this.personalGoals = personalGoals;
	}

	public Integer getRecommendedGoals() {
		return recommendedGoals;
	}

	public void setRecommendedGoals(Integer recommendedGoals) {
		this.recommendedGoals = recommendedGoals;
	}

	public CardiacRehabilitationProgramme getCardiacRehabilitationProgramme() {
		return cardiacRehabilitationProgramme;
	}

	public void setCardiacRehabilitationProgramme(CardiacRehabilitationProgramme cardiacRehabilitationProgramme) {
		this.cardiacRehabilitationProgramme = cardiacRehabilitationProgramme;
	}

	public LifeStyleAssessmentQuestionnaire[] getLifeStyleAssessmentQuestionnaire() {
		return lifeStyleAssessmentQuestionnaire;
	}

	public void setLifeStyleAssessmentQuestionnaire(LifeStyleAssessmentQuestionnaire[] lifeStyleAssessmentQuestionnaire) {
		this.lifeStyleAssessmentQuestionnaire = lifeStyleAssessmentQuestionnaire;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public GoodHabit[] getGoodHabit() {
		return goodHabit;
	}

	public void setGoodHabit(GoodHabit[] goodHabit) {
		this.goodHabit = goodHabit;
	}

}
