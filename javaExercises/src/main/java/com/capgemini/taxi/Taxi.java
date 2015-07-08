package com.capgemini.taxi;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Taxi extends Thread {

	private int number;
	private int gpsX;
	private int gpsY;
	private boolean available = true;

	Taxi(int number) {
		this.number = number;
	}

	public void run() {
		Random r = new Random();
		gpsX = r.nextInt(1000);
		gpsY = r.nextInt(1000);

		while (true) {
			gpsX = gpsX + (10 - r.nextInt(21));
			gpsY = gpsY + (10 - r.nextInt(21));
			int tmp = r.nextInt(500);
			if (tmp > 325) {
				available = false;
			} else {
				available = true;
			}

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public int getGpsX() {
		return gpsX;
	}

	public int getGpsY() {
		return gpsY;
	}

	public boolean getAvailability() {
		return available;
	}

}
