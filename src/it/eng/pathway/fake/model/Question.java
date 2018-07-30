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

import java.util.Collection;

/**
 * Sto ipotizzando solo domande con risposte chiuse e non a testo libero
 */
public class Question {

	private int id;

	private String questionText;

	/**
	 * how many answers are allowed
	 */
	private int maxAnswersNumber;

	private AnswerType answerType;

	private Collection<ClosedAnswer> closedAnswer;
	
	private YesNoScore yesNoScores;
	
	private Collection<QuantitativeScore> quantitativeScores;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public int getMaxAnswersNumber() {
		return maxAnswersNumber;
	}

	public void setMaxAnswersNumber(int maxAnswersNumber) {
		this.maxAnswersNumber = maxAnswersNumber;
	}

	public AnswerType getAnswerType() {
		return answerType;
	}

	public void setAnswerType(AnswerType answerType) {
		this.answerType = answerType;
	}

	public Collection<ClosedAnswer> getClosedAnswer() {
		return closedAnswer;
	}

	public void setClosedAnswer(Collection<ClosedAnswer> closedAnswer) {
		this.closedAnswer = closedAnswer;
	}


	public Collection<QuantitativeScore> getQuantitativeScores() {
		return quantitativeScores;
	}

	public void setQuantitativeScores(Collection<QuantitativeScore> quantitativeScores) {
		this.quantitativeScores = quantitativeScores;
	}

	public YesNoScore getYesNoScores() {
		return yesNoScores;
	}

	public void setYesNoScores(YesNoScore yesNoScores) {
		this.yesNoScores = yesNoScores;
	}
	
	

}
