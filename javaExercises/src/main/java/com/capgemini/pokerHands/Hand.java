package com.capgemini.pokerHands;

/**
 * Class that contains variables used to specify hand rank
 * 
 * @author MKORCZYN
 *
 */
class Figures {
	int same1 = 0;
	int same2 = 0;
	int largeGroupRank = 0;
	int smallGroupRank = 0;
	boolean flush = true;
	boolean straight = false;
	int topStraight = 0;
	int[] ordered;

	Figures(int same1, int same2, int largeGroupRank, int smallGroupRank, boolean flush, boolean straight,
			int topStraight, int[] ordered) {
		this.same1 = same1;
		this.same2 = same2;
		this.largeGroupRank = largeGroupRank;
		this.smallGroupRank = smallGroupRank;
		this.flush = flush;
		this.straight = straight;
		this.topStraight = topStraight;
		this.ordered = ordered;
	}

}

public class Hand {

	private Card[] cards;
	int[] value;

	/**
	 * Creates Card object
	 * 
	 * @param c
	 *            - string in form RS (R - rank of card
	 *            {2,3,4,5,6,7,8,9,T,J,Q,K,A}, S - suit of card {H,D,C,S})
	 * @return card object
	 */
	private static Card makeCard(String c) {
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

	Hand(String hand) {
		cards = new Card[5];
		String[] tmp = hand.split(" ");
		for (int i = 0; i < tmp.length; i++) {
			cards[i] = makeCard(tmp[i]);
		}

		int[] ranks = new int[14];
		for (int i = 0; i < cards.length; i++) {
			ranks[cards[i].getRank()]++;
		}

		int same1 = 0;
		int same2 = 0;
		int largeGroupRank = 1;
		int smallGroupRank = 1;
		for (int i = ranks.length - 1; i >= 1; i--) {
			if (ranks[i] > same1) {
				if (same1 != 1) {
					same2 = same1;
					smallGroupRank = largeGroupRank;
				}
				same1 = ranks[i];
				largeGroupRank = i;
			} else if (ranks[i] > same2) {
				same2 = ranks[i];
				smallGroupRank = i;
			}
		}

		boolean flush = true;
		for (int i = 0; i < cards.length - 1; i++) {
			if (cards[i].getSuit() != cards[i + 1].getSuit()) {
				flush = false;
			}
		}

		int topStraight = 0;
		boolean straight = false;
		for (int i = 1; i <= 9; i++) {
			if (ranks[i] == 1 && ranks[i + 1] == 1 && ranks[i + 2] == 1 && ranks[i + 3] == 1 && ranks[i + 4] == 1) {
				straight = true;
				topStraight = i + 4;
				break;
			}
		}
		if (ranks[10] == 1 && ranks[11] == 1 && ranks[12] == 1 && ranks[12] == 1 && ranks[1] == 1) {
			straight = true;
			topStraight = 14;
		}

		int[] ordered = new int[5];
		int index = 0;
		if (ranks[1] == 1) {
			ordered[index] = 14;
			index++;
		}
		for (int i = 13; i >= 2; i--) {
			if (ranks[i] == 1) {
				ordered[index] = i;
				index++;
			}
		}

		value = new int[6];
		Figures f = new Figures(same1, same2, largeGroupRank, smallGroupRank, flush, straight, topStraight, ordered);
		value = recognizeHand(f);

	}

	/**
	 * 
	 * @param f
	 *            - Figures object containing variables to specify hand rank
	 * @return array value[0] contains hand rank next fields contains groups
	 *         rank and high cards ranks to compare hands of same rank
	 */
	int[] recognizeHand(Figures f) {
		if (f.same1 == 1) {
			value[0] = 1;
			value[1] = f.ordered[0];
			value[2] = f.ordered[1];
			value[3] = f.ordered[2];
			value[4] = f.ordered[3];
			value[5] = f.ordered[4];
		}
		if (f.same1 == 2) {
			value[0] = 2;
			value[1] = f.largeGroupRank;
			value[2] = f.ordered[0];
			value[3] = f.ordered[1];
			value[4] = f.ordered[2];
		}
		if (f.same2 == 2) {
			value[0] = 3;
			if (f.largeGroupRank > f.smallGroupRank) {
				value[1] = f.largeGroupRank;
				value[2] = f.smallGroupRank;
			} else {
				value[1] = f.smallGroupRank;
				value[2] = f.largeGroupRank;
			}
			value[3] = f.ordered[0];
		}
		if (f.same1 == 3 && f.same2 != 2) {
			value[0] = 4;
			value[1] = f.largeGroupRank;
			value[2] = f.ordered[0];
			value[3] = f.ordered[1];
		}
		if (f.straight) {
			value[0] = 5;
			value[1] = f.topStraight;
		}
		if (f.flush) {
			value[0] = 6;
			value[1] = f.ordered[0];
			value[2] = f.ordered[1];
			value[3] = f.ordered[2];
			value[4] = f.ordered[3];
			value[5] = f.ordered[4];
		}
		if (f.same1 == 3 && f.same2 == 2) {
			value[0] = 7;
			value[1] = f.largeGroupRank;
			value[2] = f.smallGroupRank;
		}
		if (f.same1 == 4) {
			value[0] = 8;
			value[1] = f.largeGroupRank;
			value[2] = f.ordered[2];
		}
		if (f.straight && f.flush) {
			value[0] = 9;
			value[1] = f.topStraight;
		}
		if (f.flush && f.topStraight == 14) {
			value[0] = 10;
		}
		return value;
	}

	/**
	 * Compares two poker hands. It compares values stored in value array in
	 * each Hand value[0] contains hand ranks, and next field contains
	 * information to compare hands of same rank
	 * 
	 * @param second
	 *            - opponet's hand
	 * @return 1 if players hand is stronger
	 * @return -1 if opponent's hand is stronger
	 */
	int compareTo(Hand second) {
		for (int i = 0; i < 6; i++) {
			if (this.value[i] > second.value[i]) {
				return 1;
			} else if (this.value[i] < second.value[i]) {
				return -1;
			}
		}
		return 0;
	}

}
