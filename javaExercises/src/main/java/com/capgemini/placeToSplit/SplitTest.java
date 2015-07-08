package com.capgemini.placeToSplit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.placeToSplit.PlaceToSplit;

public class SplitTest {

	@Test
	public void testOddSum() {
		assertFalse(PlaceToSplit.canBalance(new int[] { 1, 2, 4 }));
	}

	@Test
	public void testEvenSum() {
		assertFalse(PlaceToSplit.canBalance(new int[] { 1, 2, 3, 4 }));
	}

	@Test
	public void testOneElementArray() {
		assertFalse(PlaceToSplit.canBalance(new int[] { 1 }));
	}

	@Test
	public void testEmptyArray() {
		assertFalse(PlaceToSplit.canBalance(new int[] {}));
	}

}
