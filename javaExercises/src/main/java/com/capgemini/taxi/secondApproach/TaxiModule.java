package com.capgemini.taxi.secondApproach;

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

	public static Taxi getTaxiByNymber(Taxi[] taxis, int requiredNumber) {
		for (Taxi taxi : taxis) {
			if (taxi.getNumber() == requiredNumber) {
				System.out.println("Taxi number " + taxi.getNumber() + " is located at (" + taxi.getGpsX() + ","
						+ taxi.getGpsY() + ") and it is " + taxi.getDistance() + "m from you");
				return taxi;
			}
		}
		return null;
	}

	public static void main(String[] args) {

		Random r = new Random();
		int custX = r.nextInt(1000);
		int custY = r.nextInt(1000);
		Taxi[] taxis = new Taxi[10000];

		for (int i = 0; i < taxis.length; i++) {
			taxis[i] = new Taxi(i, custX, custY);
			taxis[i].start();
		}
		System.out.println("All taxis dispatched");

		sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if (input.equals("g")) {
				sortTaxisByDistance(taxis);
				List<Taxi> closeTaxis = returnMaxAvailableTaxisInGivenProximity(taxis, maxTaxis, maxProximity);
				for (int i = 0; i < closeTaxis.size(); i++) {
					System.out.println(closeTaxis.get(i).getNumber() + "  " + closeTaxis.get(i).isAvailable() + "  "
							+ closeTaxis.get(i).getDistance());
				}
				System.out.println("Available taxis " + closeTaxis.size());
			}
		}
	}

}
