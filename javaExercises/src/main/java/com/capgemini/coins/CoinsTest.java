package com.capgemini.coins;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CoinsTest {

	public static List<Integer> input(int[] nums){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++){
			list.add(nums[i]);
		}
		return list;
	}
	
	@Test
	public void testSolution() {
		assertEquals(4, Coins.solution(input(new int[] {1,1,0,1,0,0})));
		assertEquals(2, Coins.solution(input(new int[] {1,0,1,0,1,0})));
	}
	
	@Test
	public void testNotBinaryList(){
		List<Integer> coins = new ArrayList<Integer>();
		coins.add(1);
		coins.add(1);
		coins.add(0);
		coins.add(1);
		coins.add(3);
		assertEquals(-1, Coins.solution(coins));
	}

}
