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
package it.eng.pathway.utility;

import it.eng.pathway.fake.model.ActivityType;

public class EnumManagerJSP {
	
	public ActivityType[] getActivities(){
		return ActivityType.values();
	}
	
	public boolean equals(ActivityType a, ActivityType b){
		if (a != null && b!= null)
			return a.equals(b);
		else
			return false;
	}
	
	public String getImgPath(ActivityType a){
		if (a!=null)
			return a.getPath();
		return "";
	}

}
