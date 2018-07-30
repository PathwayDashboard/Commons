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

import java.util.List;

public class ExerClassExerciseDescription {

	private Integer id;

	private ExerClassExerciseCategory category;

	private DifficultyType difficulty;

	private ExerClassExerciseType type;

	private IntensityType intensity;

	private AccuracyZone targetAccuracyZone;

	private List possibleTrainingProfilePhases ;

	private String textualExplanation;

	private List involvedBodyParts;

	private ExerClassDescription exerClassDescription;

	private ReferencePatientMotion referencePatientMotion;

	private Progression[] progression;

	private Adaptation[] adaptation;

	private ExerClassExerciseCategory exerClassExerciseCategory;

	private DifficultyType difficultyType;

	private ExerClassExerciseType exerClassExerciseType;

	private IntensityType intensityType;

	private ExerClassExercise exerClassExercise;

	private AccuracyZone accuracyZone;

}
