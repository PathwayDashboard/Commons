package it.eng.pathway.fake.model;

public class QuantitativeScore {

	private boolean greaterThan;

	private boolean strictly;

	private float value;

	private float score;

	public boolean isGreaterThan() {
		return greaterThan;
	}

	public void setGreaterThan(boolean greaterThan) {
		this.greaterThan = greaterThan;
	}

	public boolean isStrictly() {
		return strictly;
	}

	public void setStrictly(boolean strictly) {
		this.strictly = strictly;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	
	
}
