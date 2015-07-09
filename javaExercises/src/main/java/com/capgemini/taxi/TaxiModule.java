package com.capgemini.taxi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TaxiModule {

	public static int taxisQuan;
	public static int maxTaxisReturned;

	public static double calculateDistance(int taxiX, int taxiY, int custX, int custY) {
		double xSqr = Math.pow(taxiX - custX, 2);
		double ySqr = Math.pow(taxiY - custY, 2);
		double distance = Math.sqrt(xSqr + ySqr);
		return Math.round(distance);
	}

	public static List<String> returnTaxisCloserThanGivenDistance(Taxi[] taxis, int custX, int custY,
			int requiredDistance) {
		List<String> availableTaxisCloserThenGivenDistance = new ArrayList<String>();
		for (int i = 0; i < taxis.length; i++) {
			double distance = calculateDistance(taxis[i].getGpsX(), taxis[i].getGpsY(), custX, custY);
			boolean available = taxis[i].getAvailability();
			if (distance < 250 && available) {
				availableTaxisCloserThenGivenDistance.add("distance: " + distance * 4 + "      No: " + i);
			}
		}
		return availableTaxisCloserThenGivenDistance;
	}

	public static List<String> findTaxis(Taxi[] taxis, int custX, int custY, int distance, int numberOfTaxisToReturn) {
		
				System.out.println("customer's position x:" + custX + " y:" + custY);
				List<String> closeAvailableTaxis = returnTaxisCloserThanGivenDistance(taxis, custX, custY, distance);
				java.util.Collections.sort(closeAvailableTaxis);
				int max = Math.min(numberOfTaxisToReturn, closeAvailableTaxis.size());
				for (int i = 0; i < max; i++) {
					System.out.println(closeAvailableTaxis.get(i));
				}

				// TimeUnit.MILLISECONDS.sleep(100);
			
		return closeAvailableTaxis.subList(0, max);
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		taxisQuan = 1000;
		maxTaxisReturned = Math.round(taxisQuan / 20);

		Taxi[] taxis = new Taxi[taxisQuan];
		for (int i = 0; i < taxis.length; i++) {
			taxis[i] = new Taxi(i);
			taxis[i].start();
		}
		Random r = new Random();
		int custX = r.nextInt(1000);
		int custY = r.nextInt(1000);

		Scanner sc = new Scanner(System.in);
		System.out.println("All taxis dispatched. Type 'g' to get taxis near you");
		while (true) {
			String input = sc.nextLine();
			if (input.equals("g")) {
				List<String> closeAvailableTaxis = findTaxis(taxis, custX, custY, 250, maxTaxisReturned);
				System.out.println("Available taxis: " + closeAvailableTaxis.size());
			}
		}

	}

}
