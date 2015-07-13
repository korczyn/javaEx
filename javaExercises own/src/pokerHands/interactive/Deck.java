package pokerHands.interactive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

	public List<Card> cards = new ArrayList<Card>();
	private String[] ranks = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
	private String[] suits = new String[] {"H", "D", "C", "S"};
	
	
	private Card makeCard(String c) {
		char suit = c.charAt(1);
		char tmp_rank = c.charAt(0);
		int rank = 0;

		if (tmp_rank == 'T') {
			rank = 10;
		} else if (tmp_rank == 'J') {
			rank = 11;
		} else if (tmp_rank == 'Q') {
			rank = 12;
		} else if (tmp_rank == 'K') {
			rank = 13;
		} else if (tmp_rank == 'A') {
			rank = 1;
		} else {
			rank = Integer.parseInt(String.valueOf(tmp_rank));
		}
		Card card = new Card(suit, rank);

		return card;
	}
	
	public Deck() {
		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				Card c = makeCard(ranks[i] + suits[j]);
				cards.add(c);
			}
		}
		shuffleDeck();
	}
	
	public void shuffleDeck(){
		long seed = System.nanoTime();
		Collections.shuffle(cards, new Random(seed));
	}
	
	public Card drawACard(){
		Card c = cards.get(0);
		cards.remove(0);
		return c;
	}

}
