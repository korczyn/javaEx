package com.capgemini.placeToSplit;

/**
 * Given a non-empty array, return true if there is a place to split the array
 * so that the sum of the numbers on one side is equal to the sum of the numbers
 * on the other side. Example: {{{ canBalance({1, 1, 1, 2, 1}) → true
 * canBalance({2, 1, 1, 2, 1}) → false canBalance({10, 10}) → true }}}
 */
public final class PlaceToSplit {

	/**
	 * Calculates if it is possible to split an array to two arrays with the
	 * same value of sum of elements Firstly it calculates the whole sum and
	 * subtract elements in a loop. If temporary sum is equal to half of whole
	 * sum, then array can be split
	 * 
	 * @param nums
	 *            - array to check
	 * @return true if array can be split
	 * @return false if not
	 */
	public static boolean canBalance(int[] nums) {

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		if (sum % 2 == 1) {
			return false;
		}

		int sum2 = 0;
		for (int i = 0; i < nums.length; i++) {
			sum2 += nums[i];
			if (sum2 == sum / 2) {
				return true;
			}
		}

		return false;
	}
}