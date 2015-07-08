package com.capgemini.pythagorean;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PythagoreanTest {
	
	@Before
	public void setUp(){
		Pythagorean.findPythagoreanTriplet();
	}

	@Test
	public void testIsPythagoreanTriplet() {
		assertEquals(Pythagorean.c*Pythagorean.c, Pythagorean.a*Pythagorean.a+Pythagorean.b*Pythagorean.b);
	}
	
	@Test
	public void testSumsUpTo1000() {
		assertEquals(1000, Pythagorean.a + Pythagorean.b + Pythagorean.c);
	}

}
