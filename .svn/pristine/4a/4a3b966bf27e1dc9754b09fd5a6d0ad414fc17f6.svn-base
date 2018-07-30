package it.eng.pathway.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class HrFileHandler {
	
	
	public static List<HrMeasure> parse(String read){
		ArrayList<HrMeasure> hrs=new ArrayList<HrMeasure>();
		if (StringUtil.isValid(read)){
			StringTokenizer st=new StringTokenizer(read, ";");
			while(st.hasMoreTokens()){
//				Integer s=Integer.parseInt(st.nextToken());
				Integer v=Integer.parseInt(st.nextToken());
//				hrs.add(new HrMeasure(s, v));
				hrs.add(new HrMeasure(v));
			}
		}
		return hrs;
	}
	
	public static String createString(List<HrMeasure> hrs){
		String hrFile = "";
		if (hrs!=null){
//			int tot=hrs.size();
//			for (int i=0;i<tot-1;i++){
//				hrFile+=hrs.get(i).toString();
//			}
//			hrFile+=hrs.get(tot-1).toString();
			for (HrMeasure current : hrs) {
				hrFile+=current.toString();
			}
		}
		return hrFile;
	}
	/**
	 * 
	 * @param min
	 * @param max
	 * @param duration in minutes
	 * @param adding TODO
	 * @param speed TODO
	 * @return
	 */
	public static List<HrMeasure> createFile(int min, int max, int duration, boolean adding, double speed){
		Random r=new Random();
		ArrayList<HrMeasure> hrs=new ArrayList<HrMeasure>();
		int secs=duration*60;
		for (int i=1;i<=secs;i++){
			Integer value = 0;
			Integer minute = (Integer) (i/60); 
			Integer random = adding ? 3 + r.nextInt(4) : 3 + r.nextInt(3);
			if (adding){
				double mps = (double) (1+minute)/2 * (speed);
				double rand = (double) random*(speed/(double) 2);
				value = (int) ( min + mps + rand);
			}else{
				double mps = (double) (1+minute)/2 * (speed);
				double rand = (double) random;
				double v = max;
				if (i<(secs/3)){
					v = max*1.5;
				}else{
					v = max*1.3;
				}
				value = (int) ( v - mps - rand);
//				System.out.println(String.format("Decrescente: value[%d] max[%d] mps[%.2f] rand[%.2f] ", value, max, mps, rand));
			}
			HrMeasure hr=new HrMeasure(value);
			hrs.add(hr);
		}
		return hrs;
	}
	
	public static Double calculateAverage(List<HrMeasure> hrs){
		Double sum = (double) 0;
		Double count = (double) hrs.size();
		if (hrs!=null){
			for (HrMeasure current : hrs) {
				sum+=(double) current.getValue();
			}
		}
		Double avg = sum/count;
		return avg;
	}
	
	public static List<HrMeasure> combinePhases(int wumin, int wumax, int wuduration, int aemin, int aemax, int aeduration, int cdmin, int cdmax, int cdduration){
		List<HrMeasure> hrs = new ArrayList<HrMeasure>();
//		System.out.println(String.format("WUmin %d WUmax %d WUDuration %d AEmin %d AEmax  %d AEDuration %d CDmin %d CDMax %d CDDuration %d ",
//				wumin, wumax, wuduration, aemin, aemax, aeduration,cdmin, cdmax, cdduration));
		hrs.addAll(createFile(wumin, wumax, wuduration, true, 8));
		hrs.addAll(createFile(aemin, aemax, aeduration, true, 3.7));
		hrs.addAll(createFile(cdmin, cdmax, cdduration, false, 15));
		
//		for (HrMeasure hrMeasure : hrs) {
//			System.out.print(hrMeasure);
//		}
//		System.out.println();
		return hrs;
	}
	/**
	 * 
	 * @param hrs
	 * @param wuduration in minutes
	 * @param aeduration in minutes
	 * @param cdduration in minutes
	 * @return
	 */
	public static Double[] calculateAllAverage(List<HrMeasure> hrs, int wuduration, int aeduration, int cdduration){
		Double[] avgs = new Double[3];
		Double sum = (double) 0;
		if (hrs!=null){
			int wumax=60*wuduration;
			int aemax=wumax+ 60*aeduration;
			int cdmax=aemax+ 60*cdduration;
			
			for (int i=0;i<wumax;i++){
				sum+=(double) hrs.get(i).getValue();
			}
			avgs[0] = sum/(double) (60*wuduration);
			sum = (double) 0;
			
			for (int i=wumax;i<aemax;i++){
				sum+=(double) hrs.get(i).getValue();
			}
			avgs[1] = sum/(double) (60*aeduration);
			sum = (double) 0;
			
			for (int i=aemax;i<cdmax;i++){
				sum+=(double) hrs.get(i).getValue();
			}
			avgs[2] = sum/(double) (60*cdduration);
		}
		
		return avgs;
	}

}
