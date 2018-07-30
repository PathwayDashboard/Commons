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

public class TrainingPhaseInfo {

	private Integer duration;

	private Integer minHR;

	private Integer maxHR;

	private float averageHR;

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getMinHR() {
		return minHR;
	}

	public void setMinHR(Integer minHR) {
		this.minHR = minHR;
	}

	public Integer getMaxHR() {
		return maxHR;
	}

	public void setMaxHR(Integer maxHR) {
		this.maxHR = maxHR;
	}

	public float getAverageHR() {
		return averageHR;
	}

	public void setAverageHR(float averageHR) {
		this.averageHR = averageHR;
	}

	@Override
	public String toString() {
		return "TrainingPhaseInfo [duration=" + duration + ", minHR=" + minHR + ", maxHR=" + maxHR + ", averageHR="
				+ averageHR + "]";
	}

	
}
