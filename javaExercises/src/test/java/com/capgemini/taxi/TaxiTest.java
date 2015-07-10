package com.capgemini.taxi;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TaxiTest {

	static Taxi[] taxis;
	@BeforeClass
	public static void createTaxis(){
		int taxisQuan = 1000;
		taxis = new Taxi[taxisQuan];
		for (int i = 0; i < taxis.length; i++) {
			taxis[i] = new Taxi(i);
			taxis[i].start();
		}
		
	}
	
	@Test
	public void shouldReturnTrueForTaxiQuantityFewerOrEqualToRequired(){
		assertTrue(TaxiModule.findTaxis(taxis, 150, 150, 250, 15).size() <= 15);
	}
	
	@Test 
	public void shouldReturnTrueIfEveryTaxiIsCloserThenRequiredAndAvailable(){
		fail("Not yet implemented");
	}
	
	@Test
	public void shouldReturn1For0_0And0_1() {
		double DELTA = 1e-15;
		assertEquals(1, TaxiModule.calculateDistance(0, 0, 0, 1), DELTA);
	}
	@Test
	public void shouldReturn14For0_0And10_10() {
		double DELTA = 1e-15;
		assertEquals(14, TaxiModule.calculateDistance(0, 0, 10, 10), DELTA);
	}
	@Test
	public void shouldReturn14For0_0AndNeg10_Neg10() {
		double DELTA = 1e-15;
		assertEquals(14, TaxiModule.calculateDistance(0, 0, -10, -10), DELTA);
	}

}
