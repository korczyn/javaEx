package pokerHands.interactive;

public class Hand {

	String res = "";
	public Card[] cards;
	int[] value;

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

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.err.println(arr[i]);
		}
	}

	Hand(Card[] cards) {
		

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
		value = new int[6];
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

		if (same1 == 1) {
			res = "high card";
			value[0] = 1;
			value[1] = ordered[0];
			value[2] = ordered[1];
			value[3] = ordered[2];
			value[4] = ordered[3];
			value[5] = ordered[4];
		}
		if (same1 == 2) {
			res = "pair";
			value[0] = 2;
			value[1] = largeGroupRank;
			value[2] = ordered[0];
			value[3] = ordered[1];
			value[4] = ordered[2];
		}
		if (same2 == 2) {
			res = "two pairs";
			value[0] = 3;
			if (largeGroupRank > smallGroupRank) {
				value[1] = largeGroupRank;
				value[2] = smallGroupRank;
			} else {
				value[1] = smallGroupRank;
				value[2] = largeGroupRank;
			}
			value[3] = ordered[0];
		}
		if (same1 == 3 && same2 != 2) {
			res = "three of a kind";
			value[0] = 4;
			value[1] = largeGroupRank;
			value[2] = ordered[0];
			value[3] = ordered[1];
		}
		if (straight) {
			res = "straight";
			value[0] = 5;
			value[1] = topStraight;
		}
		if (flush) {
			res = "flush";
			value[0] = 6;
			value[1] = ordered[0];
			value[2] = ordered[1];
			value[3] = ordered[2];
			value[4] = ordered[3];
			value[5] = ordered[4];
		}
		if (same1 == 3 && same2 == 2) {
			res = "full";
			value[0] = 7;
			value[1] = largeGroupRank;
			value[2] = smallGroupRank;
		}
		if (same1 == 4) {
			res = "four of a kind";
			value[0] = 8;
			value[1] = largeGroupRank;
			value[2] = ordered[2];
		}
		if (straight && flush) {
			res = "straight flush";
			value[0] = 9;
			value[1] = topStraight;
		}
		if (flush && topStraight == 14) {
			res = "royal flush";
			value[0] = 10;
		}
	}

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
	
	String getRes(){
		return res;
	}

}
