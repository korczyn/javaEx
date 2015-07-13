
/**
 * Given a non-empty array, return true if there is a place to split the array
 * so that the sum of the numbers on one side is equal to the sum of the numbers
 * on the other side. Example: {{{ canBalance({1, 1, 1, 2, 1}) → true
 * canBalance({2, 1, 1, 2, 1}) → false canBalance({10, 10}) → true }}}
 */
public final class PlaceToSplit {
	private PlaceToSplit() {
	}

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

	public static void main(String[] args) {
		int[] nums = { 1, -5, -5, 1 };
		if (canBalance(nums)) {
			System.out.println("OK");
		} else {
			System.out.println("Not OK");
		}

	}

}
