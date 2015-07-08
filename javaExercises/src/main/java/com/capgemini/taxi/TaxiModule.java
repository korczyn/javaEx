package com.capgemini.taxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TaxiModule {

	public static List<String> nearestTaxisToHire = new ArrayList<String>();

	public static void nearestSetOfTaxis(int numberOfTaxis) {
		java.util.Collections.sort(nearestTaxisToHire);
		int max = Math.min(numberOfTaxis, nearestTaxisToHire.size());

		for (int i = 0; i < max; i++) {
			System.out.println(nearestTaxisToHire.get(i));
		}
		System.out.println("Available taxis: " + max);
		nearestTaxisToHire.clear();
	}

	public static double calculateDistance(Taxi taxi, int custX, int custY) {
		double xSqr = Math.pow(taxi.getGpsX() - custX, 2);
		double ySqr = Math.pow(taxi.getGpsY() - custY, 2);
		double distance = Math.sqrt(xSqr + ySqr);
		return Math.round(distance);
	}

	public static void main(String[] args) throws InterruptedException {

		int taxisQuan = 10000;
		Random r = new Random();
		int custX = r.nextInt(1000);
		int custY = r.nextInt(1000);

		Taxi[] taxis = new Taxi[taxisQuan];
		for (int i = 0; i < taxis.length; i++) {
			taxis[i] = new Taxi(i);
			taxis[i].start();
		}
		System.out.println("All taxis dispatched. Type 'g' to get taxis near you");

		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if (input.equals("g")) {
				System.out.println("customer's position x:" + custX + " y:" + custY);
				for (int i = 0; i < taxis.length; i++) {
					double distance = calculateDistance(taxis[i], custX, custY);
					boolean available = taxis[i].getAvailability();
					if (distance < 250 && available) {
						nearestTaxisToHire.add("distance: " + distance * 4 + "      No: " + i);
					}
				}
				nearestSetOfTaxis(Math.round(taxisQuan/10));
				//TimeUnit.MILLISECONDS.sleep(100);
			}
		}
	}

}
