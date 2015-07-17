package com.capgemini.taxi;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class TaxiTest {
	TaxiModule tm;
	
	@Before
	public void setUp(){
		tm = new TaxiModule();
		tm.createCustomer();
		tm.createTaxis(1000);
		tm.setMaxReturnedTaxis(15);
		tm.setMaxProximity(500);
	}
	
	@Test
	public void shouldReturnTrueForTaxiQuantityFewerOrEqualToRequired(){
		List<Taxi> t = tm.getTaxis();
		assertTrue(t.size() <= tm.getMaxReturnedTaxis());
	}
	
	@Test 
	public void shouldReturnTrueIfEveryTaxiIsAvailable(){
		List<Taxi> t = tm.getTaxis();
		for (Taxi taxi : t) {
			assertTrue(taxi.isAvailable());
		}
	}

	@Test 
	public void shouldReturnTrueIfEveryTaxiIsCloserThenRequired(){
		List<Taxi> t = tm.getTaxis();
		for (Taxi taxi : t) {
			assertTrue(taxi.getDistance() <= tm.getMaxProximity());
		}
	}

}
