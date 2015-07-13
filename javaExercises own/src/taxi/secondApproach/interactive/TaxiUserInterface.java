package taxi.secondApproach.interactive;

import java.util.Scanner;

public class TaxiUserInterface {
	static TaxiModule tm;
	
	public static void handleInput(String input){
		if (input.equals("get")) {
			tm.getTaxis();
		}
		if (input.startsWith("setMax")) {
			String[] t = input.split(" ");
			tm.setMaxReturnedTaxis(Integer.parseInt(t[1]));
			System.err.println("MaxTaxisReturned changed to " + tm.getMaxReturnedTaxis());
		}
		if (input.startsWith("setProx")) {
			String[] t = input.split(" ");
			tm.setMaxProximity(Integer.parseInt(t[1]));
			System.err.println("MaxTaxisReturned changed to " + tm.getMaxProximity());
		}
		if (input.startsWith("getTaxi")) {
			String[] t = input.split(" ");
			Taxi taxi = tm.getTaxiByNymber(Integer.parseInt(t[1]));
			System.err.println("Taxi Info");
			System.err.println("Number: " + taxi.getNumber());
			System.err.println("Available: " + taxi.isAvailable());
			System.err.println("Coordinate X: " + taxi.getGpsX());
			System.err.println("Coordinate Y: " + taxi.getGpsY());
			System.err.println("Distance to you: " + taxi.getDistance() + "m");
		}
		if(input.equals("help")){
			System.err.println("Commands");
			System.err.println("get			returns taxis with given properties");
			System.err.println("setProx x		sets max proximity to x");
			System.err.println("setMax x		sets max taxis returned to x");
			System.err.println("getTaxi x		detailed information about taxi number x");
			System.err.println("exit			quits the program");
		}
		if (input.startsWith("exit")) {
			System.err.println("Bye");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		tm = new TaxiModule();
		tm.createCustomer();
		tm.createTaxis(1000);
		tm.setMaxReturnedTaxis(100);
		tm.setMaxProximity(500);

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.err.print("TaxiFinder:> ");
			String input = sc.nextLine();
			handleInput(input);
		}
	}
}
