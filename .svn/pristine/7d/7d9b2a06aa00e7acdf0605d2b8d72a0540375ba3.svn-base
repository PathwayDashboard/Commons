package it.eng.pathway.fake.model;

import java.util.Date;

public class DailyActivity {
	
	private Date day;
	private Integer steps;
	private Integer kcal;
	
	public DailyActivity() {
		super();
	}

	public DailyActivity(Date day, Integer steps, Integer kcal) {
		super();
		this.day = day;
		this.steps = steps;
		this.kcal = kcal;
	}

	@Override
	public String toString() {
		return "DailyActivity [day=" + day + ", steps=" + steps + ", kcal=" + kcal + "]";
	}
	
	public io.swagger.client.model.DailyActivity getHDMSDA() {
		io.swagger.client.model.DailyActivity da = new io.swagger.client.model.DailyActivity();
		da.setDay(day);
		da.setKcal(kcal);
		da.setSteps(steps);
		return da;
	}

}
