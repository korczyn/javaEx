package pokerHands.interactive;

import java.math.BigInteger;
import java.util.Scanner;

public class PokerGame {

	static Deck deck;
	static BigInteger monies = new BigInteger("1351786562627354052702");
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

	public String changeCard(Card[] cards, String card) {
		for (int i = 0; i < cards.length; i++) {
			String type = String.valueOf(cards[i].getRank()) + String.valueOf(cards[i].getSuit());
			if (card.equals(type)) {
				cards[i] = deck.drawACard();
				return String.valueOf(cards[i].getRank()) + String.valueOf(cards[i].getSuit());
			}
		}
		return null;
	}

	public static void resolveBet() {
		print2ndHand();
		int winner = h1.compareTo(h2);
		if (winner == 1) {
			System.out.println("You've won " + Numbers.toScientificNotation(bet));
			monies = monies.add(bet);
			if (monies.compareTo(BigInteger.valueOf(1000000000)) == 1 && germoney) {
				System.out.println(">=================GERMONEY================<");
				germoney = false;
			}
		}
		if (winner == -1) {
			System.out.println("You've lost " + Numbers.toScientificNotation(bet));
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
			try {
				System.out.println("Your monies: " + Numbers.convertToCurrency(monies) + " ("
						+ Numbers.toScientificNotation(monies) + ")");
				setUpHands();
				System.out.print("Bet ");
				input = sc.nextLine();
				if (input.equals("a")) {
					bet = monies;
				} else if (input.equals("h")) {
					bet = monies.divide(BigInteger.valueOf(2));
				} else {
					bet = monies.min(new BigInteger(input));
				}
				resolveBet();
				System.out.println("===========================================");
			} catch (NumberFormatException e) {
				System.err.println(">==========Wrong input, next game=========<");
			}
		}
	}
}
