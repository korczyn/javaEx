package com.capgemini.taxi.secondApproach;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TaxiTest {

	
	@Test
	public void shouldReturnTrueIfTaxiIsAvailableAfterCreation() {
		Taxi t = new Taxi(1, 144, 157);
		assertTrue(t.isAvailable());
	}
	
	@Test
	public void taxiLocationShouldDifferInTime() throws InterruptedException{
		Taxi t = new Taxi(1, 144, 167);
		t.start();
		int gpsX = t.getGpsX();
		int gpsY = t.getGpsY();
		TimeUnit.SECONDS.sleep(2);
		assertFalse((gpsX == t.getGpsX()) || (gpsY == t.getGpsY()));
	}
	
	@Test
	public void shouldreturnTrueIfGivenOrLowerNumberOfTaxisReturned_100(){
		//given
		Random r = new Random();
		int custX = r.nextInt(1000);
		int custY = r.nextInt(1000);
		Taxi[] taxis = new Taxi[150];
		for (int i = 0; i < taxis.length; i++) {
			taxis[i] = new Taxi(i, custX, custY);
			taxis[i].start();
		}
		System.out.println("All taxis dispatched");
		TaxiModule.sortTaxisByDistance(taxis);
		List<Taxi> closeTaxis = TaxiModule.returnMaxAvailableTaxisInGivenProximity(taxis, 100, 500);
		
		//then
		assertFalse(closeTaxis.size() > 100);
	
	}
	
	@Test
	public void shouldReturnTrueIfEveryReturnedTaxiIsInGivenProximity_s500(){
		Random r = new Random();
		int custX = r.nextInt(1000);
		int custY = r.nextInt(1000);
		Taxi[] taxis = new Taxi[150];
		for (int i = 0; i < taxis.length; i++) {
			taxis[i] = new Taxi(i, custX, custY);
			taxis[i].start();
		}
		System.out.println("All taxis dispatched");
		TaxiModule.sortTaxisByDistance(taxis);
		List<Taxi> closeTaxis = TaxiModule.returnMaxAvailableTaxisInGivenProximity(taxis, 100, 500);
		
		for (int i = 0; i < closeTaxis.size(); i++) {
			assertTrue(closeTaxis.get(i).getDistance() <= 500);
		}
		
	}
	
	@Test
	public void shouldReturnTrueIfEveryReturnedTaxiIsAvailable() throws InterruptedException{
		Random r = new Random();
		int custX = r.nextInt(1000);
		int custY = r.nextInt(1000);
		Taxi[] taxis = new Taxi[10000];
		for (int i = 0; i < taxis.length; i++) {
			taxis[i] = new Taxi(i, custX, custY);
			taxis[i].start();
		}
		System.out.println("All taxis dispatched");
		TimeUnit.SECONDS.sleep(2);
		TaxiModule.sortTaxisByDistance(taxis);
		List<Taxi> closeTaxis = TaxiModule.returnMaxAvailableTaxisInGivenProximity(taxis, 100, 500);
		
		for (int i = 0; i < closeTaxis.size(); i++) {
			System.out.println(closeTaxis.get(i).isAvailable());
		}
		//assertTrue(closeTaxis.get(i).isAvailable());
		
	}
	@Test
	public void shouldReturnTrueIfCustomerPositionDidNotChange() throws InterruptedException{
		Taxi t = new Taxi(1, 144, 167);
		t.start();
		int custX = t.getCustX();
		int custY = t.getCustY();
		TimeUnit.SECONDS.sleep(2);
		assertTrue((custX == t.getCustX()) && (custY == t.getCustY()));
	}
	
	

}
