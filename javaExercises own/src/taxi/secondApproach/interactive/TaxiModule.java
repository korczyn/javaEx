package taxi.secondApproach.interactive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TaxiModule {

	private static Scanner sc;
	private static int maxTaxis = 100;
	private static int maxProximity = 500;
	Taxi[] taxis;
	int custX;
	int custY;

	public static Taxi[] sortTaxisByDistance(Taxi[] taxis) {
		Arrays.sort(taxis, new Comparator<Taxi>() {
			public int compare(Taxi t1, Taxi t2) {
				if (t1.getDistance() > t2.getDistance())
					return 1;
				if (t1.getDistance() < t2.getDistance())
					return -1;
				return 0;
			}
		});
		return taxis;
	}

	public static List<Taxi> returnMaxAvailableTaxisInGivenProximity(Taxi[] taxis, int maxTaxisToReturn,
			int proximity) {
		List<Taxi> closeTaxis = new ArrayList<Taxi>();
		for (int i = 0; i < taxis.length; i++) {
			if (taxis[i].getDistance() < proximity && taxis[i].isAvailable()) {
				closeTaxis.add(taxis[i]);
			}
		}
		int max = Math.min(maxTaxisToReturn, closeTaxis.size());
		return closeTaxis.subList(0, max);
	}

	public Taxi getTaxiByNymber(int requiredNumber) {
		for (Taxi taxi : taxis) {
			if (taxi.getNumber() == requiredNumber) {
				return taxi;
			}
		}
		return null;
	}
	
	public void createCustomer(){
		Random r = new Random();
		custX = r.nextInt(1000);
		custY = r.nextInt(1000);
	}

	public void createTaxis(int numberOfTaxis){
		taxis = new Taxi[numberOfTaxis];
		for (int i = 0; i < taxis.length; i++) {
			taxis[i] = new Taxi(i, custX, custY);
			taxis[i].start();
		}
		System.out.println("All taxis dispatched");
	}
	
	
	public void setMaxReturnedTaxis(int maxDesiredTaxis){
		maxTaxis = maxDesiredTaxis;
	}
	
	public void setMaxProximity(int proximity){
		maxProximity = proximity;
	}
	
	public int getMaxReturnedTaxis(){
		return maxTaxis;
	}
	
	public int getMaxProximity(){
		return maxProximity;
	}

	
	public void getTaxis(){
		sortTaxisByDistance(taxis);
		List<Taxi> closeTaxis = returnMaxAvailableTaxisInGivenProximity(taxis, maxTaxis, maxProximity);
		for (int i = 0; i < closeTaxis.size(); i++) {
			System.out.println(taxis[i].getNumber() + "  " + taxis[i].getDistance() + "m");
		}
		System.out.println("Available taxis " + closeTaxis.size());
	}
	

}
