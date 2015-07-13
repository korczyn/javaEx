package taxi.secondApproach.interactive;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Taxi extends Thread {

	private int number;
	private int gpsX;
	private int gpsY;
	private boolean available = true;
	private int custX;
	private int custY;
	private double distanceToCustomer;

	Taxi(int number, int custX, int custY) {
		this.number = number;
		this.custX = custX;
		this.custY = custY;
	}

	public int getNumber() {
		return number;
	}

	public boolean isAvailable() {
		return available;
	}

	public int getGpsX() {
		return gpsX;
	}

	public int getGpsY() {
		return gpsY;
	}

	public int getCustX() {
		return custX;
	}

	public int getCustY() {
		return custY;
	}

	public double getDistance() {
		return distanceToCustomer;
	}

	private void changeAvailability(Random r) {
		if (r.nextInt(500) > 350) {
			available = true;
		} else {
			available = false;
		}
	}

	private double calculateDistance(int gpsX, int gpsY, int custX, int custY) {
		double xSqr = Math.pow(gpsX - custX, 2);
		double ySqr = Math.pow(gpsY - custY, 2);
		double distance = Math.sqrt(xSqr + ySqr);
		return Math.round(distance);
	}

	public void run() {
		Random r = new Random();
		gpsX = r.nextInt(1000);
		gpsY = r.nextInt(1000);

		while (true) {
			gpsX = Math.abs(gpsX + (10 - r.nextInt(21)));
			gpsY = Math.abs(gpsY + (10 - r.nextInt(21)));

			distanceToCustomer = calculateDistance(gpsX, gpsY, custX, custY);
			changeAvailability(r);

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
