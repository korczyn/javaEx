package pokerHands.interactive;

import java.util.Scanner;

public class PokerGame {
	
	static Deck deck;
	static int monies = 100;
	static Card[] c1;
	static Card[] c2;
	static Hand h1;
	static Hand h2;
	static int bet;
	
	public static void setUpHands(){
		deck = new Deck();
		c1 = new Card[5];
		System.out.println("Hand 1");
		for(int i = 0; i < 5; i++){
			c1[i] = deck.drawACard();
			System.out.print("{" + c1[i].getRank() + " " + c1[i].getSuit() + "} " );
		}
		h1 = new Hand(c1);
		System.out.println("\n" + h1.getRes());
		
		c2 = new Card[5];
		for(int i = 0; i < 5; i++){
			c2[i] = deck.drawACard();
			//System.out.print("{" + c[i].getRank() + " " + c[i].getSuit() + "} " );
		}
		h2 = new Hand(c2);
		//System.out.println("\n" + h2.getRes());
	}
	
	public static void print2ndHand(){
		System.out.println("Hand 2");
		for(int i = 0; i < 5; i++){
			System.out.print("{" + c2[i].getRank() + " " + c2[i].getSuit() + "} " );
		}
		System.out.println("\n" + h2.getRes());
	}
	
	public static void resolveBet(){
		print2ndHand();
		int winner = h1.compareTo(h2);
		if(winner == 1){
			System.out.println("You've won " + bet + "€");
			monies = monies + bet;
		}
		if(winner == -1){
			System.out.println("You've lost " + bet + "€");
			monies = monies - bet;
			if(monies <= 0){
				System.out.println("Goodbye Greece");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args){
		
//		int winner = h1.compareTo(h2);
//
//		if (winner == 1) {
//			System.out.println("1st player wins");
//		} else if (winner == -1) {
//			System.out.println("2nd player wins");
//		}
//		if (winner == 0) {
//			System.out.println("tie");
//		}
//		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String input;
		while(true){
			System.out.println("Your monies: " + monies + "€");
			System.out.println("Rozdac? (y/n)");
			input = sc.nextLine();
			if(input.equals("y")){
				setUpHands();
				System.out.println("Bet ");
				bet = Math.min(Integer.parseInt(sc.nextLine()), monies);
				resolveBet();
			}
			System.out.println("===========================================");
			
			
		}
		
		
	}

}
