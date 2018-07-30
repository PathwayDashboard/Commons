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

import it.eng.pathway.utility.StringUtil;

public enum ActivityType {

//	RUNNING(1,"resources/images/jpg/running_filled.png"),
//	WALKING(3,"resources/images/jpg/walking_filled.png"),
//	CYCLING(2,"resources/images/jpg/regular_biking_filled.png"), 
//	GOLF(32,"resources/images/jpg/golf_filled.png"), 
//	GUIDEDWORKOUT(105,"resources/images/jpg/gymnastic_filled.png"), 
//	FREEPLAY(0,"resources/images/jpg/trampoline_park_filled.png"),
//	
//	
//	DAILYLIVINGACTIVITY(0,""),
//	ROWING(8,""),
//	SWIMMING(22,""),
//	SOCCER(35,""),
//	CRICKET(36,""),
//	BASKETBALL(37,""),
//	RUGBY(39,""),
//	VOLLEYBALL(41,""),
//	HANDBALL(44,""),
//	BEACHVOLLEY(45,""),
//	DANCING(48,""),
//	RIDING(50,""),
//	FITNESSMARTIALARTS(52,""),
//	BOOTCAMP(54,""),
//	AEROBICS(57,""),
//	AQUAFITNESS(58,""),
//	STEPWORKOUT(59,""),
//	SAILING(69,""),
//	TABLETENNIS(72,""),
//	CLIMBING(74,""),
//	GYMNASTICS(90,""),
//	RACKETSPORTS(104,""),
//	STRENGTHCONDITIONING(105,""),
//	MOBILITYSTABILITY(106,"");
	
	 
	FREEPLAY(1,"resources/images/jpg/trampoline_park_filled.png",0),
	DAILYLIVINGACTIVITY(1,"",0),
	RUNNING(2,"resources/images/jpg/running_filled.png",1),
	CYCLING(3,"resources/images/jpg/regular_biking_filled.png",2), 
	WALKING(4,"resources/images/jpg/walking_filled.png",3),
	ROWING(5,"",8),
	SWIMMING(6,"",22),
	GOLF(7,"resources/images/jpg/golf_filled.png",32), 
	SOCCER(8,"",35),
	CRICKET(9,"",36),
	BASKETBALL(10,"",37),
	RUGBY(11,"",39),
	VOLLEYBALL(12,"",41),
	HANDBALL(13,"",44),
	BEACHVOLLEY(14,"",45),
	DANCING(15,"",48),
	RIDING(16,"",50),
	FITNESSMARTIALARTS(17,"",52),
	BOOTCAMP(18,"",54),
	AEROBICS(19,"",57),
	AQUAFITNESS(20,"",58),
	STEPWORKOUT(21,"",59),
	SAILING(22,"",69),
	TABLETENNIS(23,"",72),
	CLIMBING(24,"",74),
	GYMNASTICS(25,"",90),
	RACKETSPORTS(26,"",104),
	STRENGTHCONDITIONING(27,"resources/images/jpg/gymnastic_filled.png",105),
	MOBILITYSTABILITY(28,"",106),
	OTHER(29,"",107);
	
	private int pos;
	private String path;
	private int code;

	ActivityType(int numVal, String path, int code) {
        this.pos = numVal;
        this.path = StringUtil.isValid(path) ? path : "resources/images/jpg/walking_filled.png"; 
        this.code = code;
    }

    public int getPos() {
        return pos;
    }
    
    public String getPath(){
    	return path;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
    
}
