package com.capgemini.taxi;

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

	/**
	 * Sorts the array of taxis by distance using custom comparator
	 * 
	 * @param taxis
	 *            - array of Taxi objects
	 * @return array of taxi objects sorted by distance
	 */
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

	/**
	 * Returns a list of size of Taxi objects that are available for customer
	 * and in given proximity. List have size of maxTaxisToReturn or lower if
	 * there is fewer taxis in given proximity than maxTaxisToReturn value
	 * 
	 * @param taxis
	 *            - array of taxi objects
	 * @param maxTaxisToReturn
	 *            - maximum number of taxis to return
	 * @param proximity
	 *            - maximum distance from customer to taxi
	 * @return
	 */
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

	/**
	 * Returns Taxi object with given number
	 * 
	 * @param requiredNumber
	 *            - number of Taxi object to return
	 * @return Taxi object with number requiredNumber
	 */
	public Taxi getTaxiByNymber(int requiredNumber) {
		for (Taxi taxi : taxis) {
			if (taxi.getNumber() == requiredNumber) {
				return taxi;
			}
		}
		return null;
	}

	/**
	 * Creates customer with random coordinates
	 */
	public void createCustomer() {
		Random r = new Random();
		custX = r.nextInt(1000);
		custY = r.nextInt(1000);
	}

	/**
	 * Creates array of Taxi objects of given size
	 * 
	 * @param numberOfTaxis
	 *            - array of Taxi objects
	 */
	public void createTaxis(int numberOfTaxis) {
		taxis = new Taxi[numberOfTaxis];
		for (int i = 0; i < taxis.length; i++) {
			taxis[i] = new Taxi(i, custX, custY);
			taxis[i].start();
		}
		System.out.println("All taxis dispatched");
	}

	public void setMaxReturnedTaxis(int maxDesiredTaxis) {
		maxTaxis = maxDesiredTaxis;
	}

	public void setMaxProximity(int proximity) {
		maxProximity = proximity;
	}

	public int getMaxReturnedTaxis() {
		return maxTaxis;
	}

	public int getMaxProximity() {
		return maxProximity;
	}

	/**
	 * Returns sorted by distance list of Taxi objects that fulfill user
	 * requirements such as maximum number of Taxi objects to return, Taxi
	 * availability or maximum distance to customer.
	 * 
	 * @return list of Taxi objects fulfilling user requirements
	 */
	public List<Taxi> getTaxis() {
		sortTaxisByDistance(taxis);
		List<Taxi> closeTaxis = returnMaxAvailableTaxisInGivenProximity(taxis, maxTaxis, maxProximity);
		for (int i = 0; i < closeTaxis.size(); i++) {
			System.out.println(closeTaxis.get(i).getNumber() + "  " + closeTaxis.get(i).getDistance() + "m");
		}
		System.out.println("Available taxis " + closeTaxis.size());
		return closeTaxis;
	}

}
