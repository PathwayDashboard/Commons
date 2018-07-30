package it.eng.pathway.tests;

import java.util.ArrayList;
import java.util.Date;

import it.eng.pathway.utility.DateMgt;

public class ExerciseProgrammeComparison {
	
	public Date getLastOfTheWeekProgramme(Date endRequest, ArrayList<Date> dates) {
		//TODO - logica per il weekly breakdown
		//QUI POTREBBE ESSERE FATTA UNA CHIAMATA PER RECUPERARE SOLO I PROGRAMME NELL'INTERVALLO
		String endDate;
		//o lo richiedo esplicitamente, o si prende quello che c'è in sessione
		endDate=DateMgt.getComparableRangeDayTimeString(endRequest);
		
		
		Date end=DateMgt.getDate(endDate);
		boolean found=false;
		//ipotizzando un'ordinamento crescente
		int last=dates.size()-1;
		for (int i=last;i>=0;i--){
			Date ex=dates.get(i);
//			if (found){
//				return ex; //prendo quello immediatamente precedente all'ultimo - che sarebbe la prescrizione per l'ultimo
//			}
			Date curr=ex;
			
			int days=DateMgt.getDays(end, curr);
//			PwLogger.logger.fine("Days Between: "+days);
			System.out.println("Days Between: "+days+" ExerciseProgramme CurrDate: "+DateMgt.getReadableDateTime(curr));
			
			int hours=DateMgt.getHours(end, curr);
//			PwLogger.logger.fine("Hours Between: "+hours);
			
			if (days<=1 || hours<=24){
				System.out.println("FOUND");
				System.out.println("Days Between: "+days+" ExerciseProgramme CurrDate: "+DateMgt.getReadableDateTime(curr));
				found=true; //il primo che trovo è quello relativo al giorno della fine della settimana
				return ex;
			}else if(i==0 && !found){
				ex=dates.get(i);
				System.out.println("Returned ExerciseProgramme Date [THE FIRST ONE]: "+DateMgt.getReadableDateTime(ex));
				return ex;
			}
		}
		
		return null;
	}

}
