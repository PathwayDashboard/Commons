package it.eng.pathway.utility;

public class HrMeasure {
	
//	private Integer sec;
	private Integer value;
	
	public HrMeasure(/*Integer sec,*/ Integer value) {
		super();
//		this.sec = sec;
		this.value = value;
	}
	public HrMeasure() {
		super();
	}
//	public Integer getSec() {
//		return sec;
//	}
//	public void setSec(Integer sec) {
//		this.sec = sec;
//	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	@Override
	public String toString() {
//		return sec+";"+value+";";
		return value+";";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HrMeasure other = (HrMeasure) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
	

}
