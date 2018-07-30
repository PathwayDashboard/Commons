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

public class Patient {

	private CardiacRehabilitationProgramme cardiacRehabilitationProgramme;


	private CardiacRehabilitationProgress cardiacRehabilitationProgress;

	private ExerciseSession exerciseSession;

	private ExerciseRealTimeFeedback exerciseRealTimeFeedback;

	private PatientFeedback patientFeedback;

	private BehaviouralChangeProgramme behaviouralChangeProgramme;

	private BehaviouralChangeProgress behaviouralChangeProgress;

	private PersonalInfo personalInfo;

	public CardiacRehabilitationProgramme getCardiacRehabilitationProgramme() {
		return cardiacRehabilitationProgramme;
	}

	public void setCardiacRehabilitationProgramme(CardiacRehabilitationProgramme cardiacRehabilitationProgramme) {
		this.cardiacRehabilitationProgramme = cardiacRehabilitationProgramme;
	}

	public CardiacRehabilitationProgress getCardiacRehabilitationProgress() {
		return cardiacRehabilitationProgress;
	}

	public void setCardiacRehabilitationProgress(CardiacRehabilitationProgress cardiacRehabilitationProgress) {
		this.cardiacRehabilitationProgress = cardiacRehabilitationProgress;
	}

	public ExerciseSession getExerciseSession() {
		return exerciseSession;
	}

	public void setExerciseSession(ExerciseSession exerciseSession) {
		this.exerciseSession = exerciseSession;
	}

	public ExerciseRealTimeFeedback getExerciseRealTimeFeedback() {
		return exerciseRealTimeFeedback;
	}

	public void setExerciseRealTimeFeedback(ExerciseRealTimeFeedback exerciseRealTimeFeedback) {
		this.exerciseRealTimeFeedback = exerciseRealTimeFeedback;
	}

	public PatientFeedback getPatientFeedback() {
		return patientFeedback;
	}

	public void setPatientFeedback(PatientFeedback patientFeedback) {
		this.patientFeedback = patientFeedback;
	}

	public BehaviouralChangeProgramme getBehaviouralChangeProgramme() {
		return behaviouralChangeProgramme;
	}

	public void setBehaviouralChangeProgramme(BehaviouralChangeProgramme behaviouralChangeProgramme) {
		this.behaviouralChangeProgramme = behaviouralChangeProgramme;
	}

	public BehaviouralChangeProgress getBehaviouralChangeProgress() {
		return behaviouralChangeProgress;
	}

	public void setBehaviouralChangeProgress(BehaviouralChangeProgress behaviouralChangeProgress) {
		this.behaviouralChangeProgress = behaviouralChangeProgress;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

}
