package pokerHands.interactive;

import java.math.BigInteger;
import java.util.Scanner;

public class PokerGame {

	static Deck deck;
	static BigInteger monies = new BigInteger("57167010188990208");
	static Card[] c1;
	static Card[] c2;
	static Hand h1;
	static Hand h2;
	static BigInteger bet;
	static boolean germoney = true;
	private static Scanner sc;

	public static void setUpHands() {
		deck = new Deck();
		c1 = new Card[5];
		System.out.println("Hand 1");
		for (int i = 0; i < 5; i++) {
			c1[i] = deck.drawACard();
			System.out.print("{" + c1[i].getRank() + " " + c1[i].getSuit() + "} ");
		}
		h1 = new Hand(c1);
		System.out.println("\n" + h1.getRes());

		c2 = new Card[5];
		for (int i = 0; i < 5; i++) {
			c2[i] = deck.drawACard();
		}
		h2 = new Hand(c2);
	}

	public static void print2ndHand() {
		System.out.println("Hand 2");
		for (int i = 0; i < 5; i++) {
			System.out.print("{" + c2[i].getRank() + " " + c2[i].getSuit() + "} ");
		}
		System.out.println("\n" + h2.getRes());
	}

	public static void resolveBet() {
		print2ndHand();
		int winner = h1.compareTo(h2);
		if (winner == 1) {
			System.out.println("You've won " + Numbers.convertToCurrency(bet));
			monies = monies.add(bet);
			if (monies.compareTo(BigInteger.valueOf(1000000000)) == 1 && germoney) {
				System.out.println(">=================GERMONEY================<");
				germoney = false;
			}
		}
		if (winner == -1) {
			System.out.println("You've lost " + Numbers.convertToCurrency(bet));
			monies = monies.subtract(bet);
			if (monies.compareTo(BigInteger.valueOf(1000000000)) == -1) {
				System.out.println(">=============Goodbye Greece==============<");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String input;
		while (true) {
			try{
				System.out.println("Your monies: " + Numbers.convertToCurrency(monies) + " (" + Numbers.nameANumber(monies) + ")");
				setUpHands();
				System.out.print("Bet ");
				input = sc.nextLine();
				if(input.equals("all")){
					bet = monies;
				} else if(input.equals("half")){
					bet = monies.divide(BigInteger.valueOf(2));
				} else {
					bet = monies.min(new BigInteger(input));
				}
				resolveBet();
				System.out.println("===========================================");
			} catch (NumberFormatException e){
				System.err.println(">==========Wrong input, next game=========<");
			}
		}
	}
}
