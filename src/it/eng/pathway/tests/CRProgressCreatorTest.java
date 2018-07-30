package it.eng.pathway.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import io.swagger.client.model.CardiacRehabilitationProgressActiveLifestylePASessionminutesInZoneSubSubSection;
import it.eng.pathway.utility.CRProgressCreator;

public class CRProgressCreatorTest {

	@Test
	public void testCreateMinutesInZone() {
		int tot = 52;
		CardiacRehabilitationProgressActiveLifestylePASessionminutesInZoneSubSubSection zones = CRProgressCreator.createMinutesInZone(220, tot);
		int wholeDuration = zones.getZone050()+zones.getZone5160()+zones.getZone6170()+zones.getZone7180()+zones.getZone8190()+zones.getZone91100()+zones.getZone101();
		assertEquals(tot, wholeDuration);
	}

	@Test
	public void testIsAcceptable() {
		CardiacRehabilitationProgressActiveLifestylePASessionminutesInZoneSubSubSection msZ = new CardiacRehabilitationProgressActiveLifestylePASessionminutesInZoneSubSubSection();
		int[] zones = {0, 10, 
				5, 20, 15, 
				10 ,10};
		int wholeDuration = 0;
		for (int i : zones) {
			wholeDuration += i;
		}
		msZ.setZone050(zones[0]);
		msZ.setZone5160(zones[1]);
		msZ.setZone6170(zones[2]);
		msZ.setZone7180(zones[3]);
		msZ.setZone8190(zones[4]);
		msZ.setZone91100(zones[5]);
		msZ.setZone101(zones[6]);
		System.out.println(msZ);
		assertFalse(CRProgressCreator.isAcceptable(msZ, wholeDuration));
		
		int[] zonesTrue = {0, 5, 
				15, 15, 8, 
				1 ,0};
		wholeDuration = 0;
		for (int i : zonesTrue) {
			wholeDuration += i;
		}
		msZ.setZone050(zonesTrue[0]);
		msZ.setZone5160(zonesTrue[1]);
		msZ.setZone6170(zonesTrue[2]);
		msZ.setZone7180(zonesTrue[3]);
		msZ.setZone8190(zonesTrue[4]);
		msZ.setZone91100(zonesTrue[5]);
		msZ.setZone101(zonesTrue[6]);
		System.out.println(msZ);
		assertTrue(CRProgressCreator.isAcceptable(msZ, wholeDuration));
	}

}
