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
