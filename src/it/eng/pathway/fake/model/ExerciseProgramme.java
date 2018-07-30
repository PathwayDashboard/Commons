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

import java.util.Date;

import io.swagger.client.model.CardiacRehabilitationProgrammeExerciseProgrammeSubSection;

public class ExerciseProgramme {

	private Integer weeklyFrequency;

	private Integer exerciseIntensity;

	private Integer weeklyTime;
	
	private Integer personalWeeklyTime;

	private Integer classDuration;
	
	private Integer gameDuration;

	private Integer numberOfExerClass;

	private Integer numberOfExerGame;

	private Integer numberOfActiveLifestyleActivity;
	
	private Date date;
	

	public ExerciseProgramme(CardiacRehabilitationProgrammeExerciseProgrammeSubSection curr) {
		this.weeklyFrequency = curr.getWeeklyFrequency();
		this.exerciseIntensity = curr.getExerciseIntensity();
		this.weeklyTime = curr.getWeeklyTime();
		this.personalWeeklyTime = curr.getPersonalWeeklyTime();
		this.classDuration = curr.getClassDuration();
		this.gameDuration = curr.getGameDuration();
		this.numberOfExerClass = curr.getNumberOfExerClass();
		this.numberOfExerGame = curr.getNumberOfExerGame();
		this.numberOfActiveLifestyleActivity = curr.getNumberOfActiveLifeStyleActivity();
		this.date = curr.getDate();
	}

	public Integer getWeeklyFrequency() {
		return weeklyFrequency;
	}

	public void setWeeklyFrequency(Integer weeklyFrequency) {
		this.weeklyFrequency = weeklyFrequency;
	}

	public Integer getExerciseIntensity() {
		return exerciseIntensity;
	}

	public void setExerciseIntensity(Integer exerciseIntensity) {
		this.exerciseIntensity = exerciseIntensity;
	}

	public Integer getWeeklyTime() {
		return weeklyTime;
	}

	public void setWeeklyTime(Integer weeklyTime) {
		this.weeklyTime = weeklyTime;
	}


	public Integer getNumberOfExerClass() {
		return numberOfExerClass;
	}

	public void setNumberOfExerClass(Integer numberOfExerClass) {
		this.numberOfExerClass = numberOfExerClass;
	}

	public Integer getNumberOfExerGame() {
		return numberOfExerGame;
	}

	public void setNumberOfExerGame(Integer numberOfExerGame) {
		this.numberOfExerGame = numberOfExerGame;
	}

	public Integer getNumberOfActiveLifestyleActivity() {
		return numberOfActiveLifestyleActivity;
	}

	public void setNumberOfActiveLifestyleActivity(Integer numberOfActiveLifestyleActivity) {
		this.numberOfActiveLifestyleActivity = numberOfActiveLifestyleActivity;
	}

	public static boolean isValid(io.swagger.client.model.CardiacRehabilitationProgrammeExerciseProgrammeSubSection hdmsProgramme){
		return hdmsProgramme.getWeeklyTime()!=null;
	}
	
	public static boolean isValid(ExerciseProgramme exProgramme){
		return (exProgramme.getWeeklyTime()!=null &&
				exProgramme.getClassDuration()!=null &&
				exProgramme.getClassDuration() > 0 &&
				exProgramme.getWeeklyTime() > 0);
	}

	public Integer getPersonalWeeklyTime() {
		return personalWeeklyTime;
	}

	public void setPersonalWeeklyTime(Integer personalWeeklyTime) {
		this.personalWeeklyTime = personalWeeklyTime;
	}

	public Integer getClassDuration() {
		return classDuration;
	}

	public void setClassDuration(Integer classDuration) {
		this.classDuration = classDuration;
	}

	public Integer getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(Integer gameDuration) {
		this.gameDuration = gameDuration;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
