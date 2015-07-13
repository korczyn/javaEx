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
	public void shouldReturn1IfHighCard(){
		assertEquals(1, highCard.value[0]);
	}
	@Test
	public void shouldReturn2IfOnePair(){
		assertEquals(2, onePair.value[0]);
	}
	@Test
	public void shouldReturn3IfTwoPairs(){
		assertEquals(3, twoPairs.value[0]);
	}
	@Test
	public void shouldReturn4IfThreeOaK(){
		assertEquals(4, threeOaK.value[0]);
	}
	@Test
	public void shouldReturn5IfStraight(){
		assertEquals(5, straight.value[0]);
	}
	@Test
	public void shouldReturn6IfFlush(){
		assertEquals(6, flush.value[0]);
	}
	@Test
	public void shouldReturn7IfFull(){
		assertEquals(7, full.value[0]);
	}
	@Test
	public void shouldReturn8IfFourOaK(){
		assertEquals(8, fourOaK.value[0]);
	}
	@Test
	public void shouldReturn9IfStraightFlush(){
		assertEquals(9, straightFlush.value[0]);
	}
	@Test
	public void shouldReturn10IfRoyalFlush(){
		assertEquals(10, royalFlush.value[0]);
	}
	
	

	@Test
	public void shouldReturnNeg1WithComparePairOf7ToPairOfJacks() {
		Hand pairOf7 = new Hand("7D KC 3H 7S AC");
		Hand pairOfJacks = new Hand("JD KC 3H JS AC");
		assertEquals(-1, pairOf7.compareTo(pairOfJacks));
	}

	@Test
	public void shouldReturnNeg1WithComparePairOf7WithKingToPairOf7WithAce() {
		Hand pairOf7WithKing = new Hand("7D KC 3H 7S 4C");
		Hand pairOf7WithAce = new Hand("JD KC 3H JS AC");
		assertEquals(-1, pairOf7WithKing.compareTo(pairOf7WithAce));
	}

	@Test
	public void shouldReturnNeg1WithCompareStraightWithTop6ToStraightWithTopJack() {
		Hand straightWithTop6 = new Hand("6H 4H 5C 3H 2H");
		Hand straightWithTopJack = new Hand("JH 9H TC 7H 8H");
		assertEquals(-1, straightWithTop6.compareTo(straightWithTopJack));
	}

	@Test
	public void shouldReturnNeg1WithCompareFullWith3NinesAnd2KingsToFullWith3TensAnd2Fives() {
		Hand fullWith3NinesAnd2Kings = new Hand("KH 9H KC 9H 9H");
		Hand fullWith3TensAnd2Fives = new Hand("TH TH 5C TH 5H");
		assertEquals(-1, fullWith3NinesAnd2Kings.compareTo(fullWith3TensAnd2Fives));
	}

	@Test
	public void shouldReturnNeg1WithCompareFlusWithHighTenToFlushWithHighJack() {
		Hand flushWithHighTen = new Hand("2H 4H 6H 8H TH");
		Hand flushWithHighJack = new Hand("JS 9S 7S 6S 3S");
		assertEquals(-1, flushWithHighTen.compareTo(flushWithHighJack));
	}

	@Test
	public void shouldReturn0WithCompareFlushOfHeartsToFlushOfSpadesWithSameCardRanks() {
		Hand flushOfHearts = new Hand("2H 4H 6H 8H TH");
		Hand flushOfSpades = new Hand("2S TS 4S 6S 8S");
		assertEquals(0, flushOfHearts.compareTo(flushOfSpades));
	}

	@Test
	public void shouldReturnNeg1WithCompareHighToOnePair() {
		assertEquals(-1, highCard.compareTo(onePair));
	}

	@Test
	public void shouldReturnNeg1WithCompareHighToTwoPairs() {
		assertEquals(-1, highCard.compareTo(twoPairs));
	}

	@Test
	public void shouldReturnNeg1WithCompareHighToThreeOaK() {
		assertEquals(-1, highCard.compareTo(threeOaK));
	}

	@Test
	public void shouldReturnNeg1WithCompareHighToStraight() {
		assertEquals(-1, highCard.compareTo(straight));
	}

	@Test
	public void shouldReturnNeg1WithCompareHighToFlush() {
		assertEquals(-1, highCard.compareTo(flush));
	}

	@Test
	public void shouldReturnNeg1WithCompareHighToFull() {
		assertEquals(-1, highCard.compareTo(full));
	}

	@Test
	public void shouldReturnNeg1WithCompareHighToFourOaK() {
		assertEquals(-1, highCard.compareTo(fourOaK));
	}

	@Test
	public void shouldReturnNeg1WithCompareHighToStraightFlush() {
		assertEquals(-1, highCard.compareTo(straightFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareHighToRoyalFlush() {
		assertEquals(-1, highCard.compareTo(royalFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareOnePairToTwoPairs() {
		assertEquals(-1, onePair.compareTo(twoPairs));
	}

	@Test
	public void shouldReturnNeg1WithCompareOnePairToThreeOaK() {
		assertEquals(-1, onePair.compareTo(threeOaK));
	}

	@Test
	public void shouldReturnNeg1WithCompareOnePairToStraight() {
		assertEquals(-1, onePair.compareTo(straight));
	}

	@Test
	public void shouldReturnNeg1WithCompareOnePairToFlush() {
		assertEquals(-1, onePair.compareTo(flush));
	}

	@Test
	public void shouldReturnNeg1WithCompareOnePairToFull() {
		assertEquals(-1, onePair.compareTo(full));
	}

	@Test
	public void shouldReturnNeg1WithCompareOnePairToFourOaK() {
		assertEquals(-1, onePair.compareTo(fourOaK));
	}

	@Test
	public void shouldReturnNeg1WithCompareOnePairToStraightFlush() {
		assertEquals(-1, onePair.compareTo(straightFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareOnePairToRoyalFlush() {
		assertEquals(-1, onePair.compareTo(royalFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareTwoPairsToThreeOaK() {
		assertEquals(-1, twoPairs.compareTo(threeOaK));
	}

	@Test
	public void shouldReturnNeg1WithCompareTwoPairsToStraight() {
		assertEquals(-1, twoPairs.compareTo(straight));
	}

	@Test
	public void shouldReturnNeg1WithCompareTwoPairsToFlush() {
		assertEquals(-1, twoPairs.compareTo(flush));
	}

	@Test
	public void shouldReturnNeg1WithCompareTwoPairsToFull() {
		assertEquals(-1, twoPairs.compareTo(full));
	}

	@Test
	public void shouldReturnNeg1WithCompareTwoPairsToFourOaK() {
		assertEquals(-1, twoPairs.compareTo(fourOaK));
	}

	@Test
	public void shouldReturnNeg1WithCompareTwoPairsToStraightFlush() {
		assertEquals(-1, twoPairs.compareTo(straightFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareTwoPairsToRoyalFlush() {
		assertEquals(-1, twoPairs.compareTo(royalFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareThreeOaKToStraight() {
		assertEquals(-1, threeOaK.compareTo(straight));
	}

	@Test
	public void shouldReturnNeg1WithCompareThreeOaKToFlush() {
		assertEquals(-1, threeOaK.compareTo(flush));
	}

	@Test
	public void shouldReturnNeg1WithCompareThreeOaKToFull() {
		assertEquals(-1, threeOaK.compareTo(full));
	}

	@Test
	public void shouldReturnNeg1WithCompareThreeOaKToFourOaK() {
		assertEquals(-1, threeOaK.compareTo(fourOaK));
	}

	@Test
	public void shouldReturnNeg1WithCompareThreeOaKToStraightFlush() {
		assertEquals(-1, threeOaK.compareTo(straightFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareThreeOaKToRoyalFlush() {
		assertEquals(-1, threeOaK.compareTo(royalFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareStraightToFlush() {
		assertEquals(-1, straight.compareTo(flush));
	}

	@Test
	public void shouldReturnNeg1WithCompareStraightToFull() {
		assertEquals(-1, straight.compareTo(full));
	}

	@Test
	public void shouldReturnNeg1WithCompareStraightToFourOaK() {
		assertEquals(-1, straight.compareTo(fourOaK));
	}

	@Test
	public void shouldReturnNeg1WithCompareStraightToStraightFlush() {
		assertEquals(-1, straight.compareTo(straightFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareStraightToRoyalFlush() {
		assertEquals(-1, straight.compareTo(royalFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareFlushToFull() {
		assertEquals(-1, flush.compareTo(full));
	}

	@Test
	public void shouldReturnNeg1WithCompareFlushToFourOaK() {
		assertEquals(-1, flush.compareTo(fourOaK));
	}

	@Test
	public void shouldReturnNeg1WithCompareFlushToStraightFlush() {
		assertEquals(-1, flush.compareTo(straightFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareFlushToRoyalFlush() {
		assertEquals(-1, flush.compareTo(royalFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareFullToFourOaK() {
		assertEquals(-1, full.compareTo(fourOaK));
	}

	@Test
	public void shouldReturnNeg1WithCompareFullTofStraightFlush() {
		assertEquals(-1, full.compareTo(straightFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareFullToRoyalFlush() {
		assertEquals(-1, full.compareTo(royalFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareFourOaKToflushFlush() {
		assertEquals(-1, fourOaK.compareTo(straightFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareFourOaKToRoyalFlush() {
		assertEquals(-1, fourOaK.compareTo(royalFlush));
	}

	@Test
	public void shouldReturnNeg1WithCompareStraightFlushToRoyalFlush() {
		assertEquals(-1, straightFlush.compareTo(royalFlush));
	}
}
