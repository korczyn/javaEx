package com.capgemini.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.fibonacci.Fibonacci;

public class FibbTest {

	@Test
	public void testNegativeN() {
		assertEquals(-1, Fibonacci.fib(-2));
	}
	
	@Test
	public void testOnPositive(){
		assertEquals(0, Fibonacci.fib(0));
		assertEquals(1, Fibonacci.fib(1));
		assertEquals(1, Fibonacci.fib(2));
		assertEquals(2, Fibonacci.fib(3));
		assertEquals(3, Fibonacci.fib(4));
	}
	
	@Test
	public void testTooBigNumber(){
		assertEquals(-1, Fibonacci.fib(100));
	}

}
