package com.capgemini.pascalrectangle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.pascalrectangle.PascalRectangle;

public class pascalrectangleTest {

	@Test
	public void shouldReturn0For0_0(){
		assertEquals(1, PascalRectangle.pascal(0, 0));
	}
	
	@Test
	public void shouldReturn1For2_2(){
		assertEquals(1, PascalRectangle.pascal(2, 2));
	}
	
	@Test
	public void shouldReturn10For5_2(){
		assertEquals(10, PascalRectangle.pascal(5, 2));
	}
	
	@Test
	public void shouldReturnNeg1For0_Neg1(){
		assertEquals(-1, PascalRectangle.pascal(0, -1));
	}
	
	@Test
	public void shouldReturnNeg1ForNeg1_0(){
		assertEquals(-1, PascalRectangle.pascal(-1, 0));
	}

	@Test
	public void shouldReturnNeg1For2_3(){
		assertEquals(-1, PascalRectangle.pascal(2, 3));
	}
}
