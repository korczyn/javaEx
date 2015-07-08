package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PokerTest {

	static Hand highCard, onePair, twoPairs, threeOaK, straight, flush, full, fourOaK, straightFlush, royalFlush;

	@BeforeClass
	public static void setUpHands() {
		highCard = new Hand("7S 5S 9S JD KD");
		onePair = new Hand("5D KC 3H 5S AC");
		twoPairs = new Hand("6D 6C TD TH KD");
		threeOaK = new Hand("TC TD QC JD TS");
		straight = new Hand("6H 4H 5C 3H 2H");
		flush = new Hand("6H 2H 8H KH 4H");
		full = new Hand("6H 6S 6C KS KH");
		fourOaK = new Hand("7S 7S 7S JD 7D");
		straightFlush = new Hand("6H 7H 8H 5H 4H");
		royalFlush = new Hand("KH JH TH QH AH");
	}

	@Test
	public void compareHighToOnePair() {
		assertEquals(-1, highCard.compareTo(onePair));
	}

	@Test
	public void compareHighToTwoPairs() {
		assertEquals(-1, highCard.compareTo(twoPairs));
	}

	@Test
	public void compareHighToThreeOaK() {
		assertEquals(-1, highCard.compareTo(threeOaK));
	}

	@Test
	public void compareHighToStraight() {
		assertEquals(-1, highCard.compareTo(straight));
	}

	@Test
	public void compareHighToFlush() {
		assertEquals(-1, highCard.compareTo(flush));
	}

	@Test
	public void compareHighToFull() {
		assertEquals(-1, highCard.compareTo(full));
	}

	@Test
	public void compareHighToFourOaK() {
		assertEquals(-1, highCard.compareTo(fourOaK));
	}

	@Test
	public void compareHighToStraightFlush() {
		assertEquals(-1, highCard.compareTo(straightFlush));
	}

	@Test
	public void compareHighToRoyalFlush() {
		assertEquals(-1, highCard.compareTo(royalFlush));
	}

	@Test
	public void compareOnePairToTwoPairs() {
		assertEquals(-1, onePair.compareTo(twoPairs));
	}

	@Test
	public void compareOnePairToThreeOaK() {
		assertEquals(-1, onePair.compareTo(threeOaK));
	}

	@Test
	public void compareOnePairToStraight() {
		assertEquals(-1, onePair.compareTo(straight));
	}

	@Test
	public void compareOnePairToFlush() {
		assertEquals(-1, onePair.compareTo(flush));
	}

	@Test
	public void compareOnePairToFull() {
		assertEquals(-1, onePair.compareTo(full));
	}

	@Test
	public void compareOnePairToFourOaK() {
		assertEquals(-1, onePair.compareTo(fourOaK));
	}

	@Test
	public void compareOnePairToStraightFlush() {
		assertEquals(-1, onePair.compareTo(straightFlush));
	}

	@Test
	public void compareOnePairToRoyalFlush() {
		assertEquals(-1, onePair.compareTo(royalFlush));
	}

	@Test
	public void compareTwoPairsToThreeOaK() {
		assertEquals(-1, twoPairs.compareTo(threeOaK));
	}

	@Test
	public void compareTwoPairsToStraight() {
		assertEquals(-1, twoPairs.compareTo(straight));
	}

	@Test
	public void compareTwoPairsToFlush() {
		assertEquals(-1, twoPairs.compareTo(flush));
	}

	@Test
	public void compareTwoPairsToFull() {
		assertEquals(-1, twoPairs.compareTo(full));
	}

	@Test
	public void compareTwoPairsToFourOaK() {
		assertEquals(-1, twoPairs.compareTo(fourOaK));
	}

	@Test
	public void compareTwoPairsToStraightFlush() {
		assertEquals(-1, twoPairs.compareTo(straightFlush));
	}

	@Test
	public void compareTwoPairsToRoyalFlush() {
		assertEquals(-1, twoPairs.compareTo(royalFlush));
	}

	@Test
	public void compareThreeOaKToStraight() {
		assertEquals(-1, threeOaK.compareTo(straight));
	}

	@Test
	public void compareThreeOaKToFlush() {
		assertEquals(-1, threeOaK.compareTo(flush));
	}

	@Test
	public void compareThreeOaKToFull() {
		assertEquals(-1, threeOaK.compareTo(full));
	}

	@Test
	public void compareThreeOaKToFourOaK() {
		assertEquals(-1, threeOaK.compareTo(fourOaK));
	}

	@Test
	public void compareThreeOaKToStraightFlush() {
		assertEquals(-1, threeOaK.compareTo(straightFlush));
	}

	@Test
	public void compareThreeOaKToRoyalFlush() {
		assertEquals(-1, threeOaK.compareTo(royalFlush));
	}

	@Test
	public void compareStraightToFlush() {
		assertEquals(-1, straight.compareTo(flush));
	}

	@Test
	public void compareStraightToFull() {
		assertEquals(-1, straight.compareTo(full));
	}

	@Test
	public void compareStraightToFourOaK() {
		assertEquals(-1, straight.compareTo(fourOaK));
	}

	@Test
	public void compareStraightToStraightFlush() {
		assertEquals(-1, straight.compareTo(straightFlush));
	}

	@Test
	public void compareStraightToRoyalFlush() {
		assertEquals(-1, straight.compareTo(royalFlush));
	}

	@Test
	public void comapreFlushToFull() {
		assertEquals(-1, flush.compareTo(full));
	}

	@Test
	public void comapreFlushToFourOaK() {
		assertEquals(-1, flush.compareTo(fourOaK));
	}

	@Test
	public void comapreFlushToflushFlush() {
		assertEquals(-1, flush.compareTo(straightFlush));
	}

	@Test
	public void comapreFlushToRoyalFlush() {
		assertEquals(-1, flush.compareTo(royalFlush));
	}

	@Test
	public void comapreFullToFourOaK() {
		assertEquals(-1, full.compareTo(fourOaK));
	}

	@Test
	public void comapreFullToflushFlush() {
		assertEquals(-1, full.compareTo(straightFlush));
	}

	@Test
	public void comapreFullToRoyalFlush() {
		assertEquals(-1, full.compareTo(royalFlush));
	}

	@Test
	public void comapreFourOaKToflushFlush() {
		assertEquals(-1, fourOaK.compareTo(straightFlush));
	}

	@Test
	public void comapreFourOaKToRoyalFlush() {
		assertEquals(-1, fourOaK.compareTo(royalFlush));
	}

	@Test
	public void comapreStraightFlushToRoyalFlush() {
		assertEquals(-1, straightFlush.compareTo(royalFlush));
	}
}
