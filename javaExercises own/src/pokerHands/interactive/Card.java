package pokerHands.interactive;

public class Card {
	private char suit;
	private int rank;

	Card(char suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public char getSuit() {
		return this.suit;
	}

	public int getRank() {
		return this.rank;
	}

}
