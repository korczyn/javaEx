package com.capgemini.pascalrectangle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.pascalrectangle.PascalRectangle;

public class pascalrectangleTest {

	@Test
	public void testTopOfTriangle(){
		assertEquals(1, PascalRectangle.pascal(0, 0));
	}
	
	@Test
	public void testCorrectNumbers1(){
		assertEquals(1, PascalRectangle.pascal(2, 2));
	}
	
	@Test
	public void testCorrectNumbers2(){
		assertEquals(10, PascalRectangle.pascal(5, 2));
	}
	
	@Test
	public void testNegativeRows(){
		assertEquals(-1, PascalRectangle.pascal(0, -1));
	}
	
	@Test
	public void testNegativeColumns(){
		assertEquals(-1, PascalRectangle.pascal(-1, 0));
	}

	@Test
	public void testTooMuchColumnsToRows(){
		assertEquals(-1, PascalRectangle.pascal(2, 3));
	}
}
