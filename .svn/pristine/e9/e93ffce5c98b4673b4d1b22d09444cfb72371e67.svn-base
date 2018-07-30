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
