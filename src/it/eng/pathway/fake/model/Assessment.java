package it.eng.pathway.fake.model;

import java.util.Date;
import java.util.List;

public class Assessment {


	private Date submissionDate;

	private GoalCategoryType category;

	private List<Answer> answers;


	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public GoalCategoryType getCategory() {
		return category;
	}

	public void setCategory(GoalCategoryType category) {
		this.category = category;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	
}
