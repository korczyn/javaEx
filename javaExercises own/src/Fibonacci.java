import java.math.BigInteger;

/**
 * Created by ldrygala on 2015-01-23. F1 F2 F3 F4 F5 F6 F7 F8 F9 F10 F11 F12 F13
 * F14 F15 F16 F17 F18 F19 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597
 * 2584 4181
 */
public class Fibonacci {
	
	
	
	public static BigInteger fib(int n) {
		if (n < 0) {
			System.out.println("Enter positive number");
			return BigInteger.valueOf(-1);
		}

		BigInteger[] tmp = new BigInteger[3];
		tmp[0] = BigInteger.valueOf(1);
		tmp[1] = BigInteger.valueOf(1);
		tmp[2] = BigInteger.valueOf(0);

		if (n == 0) {
			return BigInteger.valueOf(0);
		} else if (n == 1) {
			return BigInteger.valueOf(1);
		} else if (n == 2) {
			return BigInteger.valueOf(1);
		}

		for (int i = 2; i < n; i++) {
			tmp[2] = tmp[0].add(tmp[1]);
//			if (Math.abs(tmp[2]) != tmp[0] + tmp[1]) {
//				System.out.println("Pick smaller number");
//				return -1;
//			}
			tmp = shiftArray(tmp);
			//System.out.println((i + 1) + " " + tmp[1]);
		}

		return tmp[1];
	}

	private static BigInteger[] shiftArray(BigInteger[] arr) {
		arr[0] = arr[1];
		arr[1] = arr[2];
		arr[2] = BigInteger.valueOf(0);
		return arr;
	}

	public static void main(String[] args) {
		int number = 2000000;
		System.out.println("fibb(" + number + ")");
		long start = System.currentTimeMillis();
		System.out.println(fib(number));
		long end = System.currentTimeMillis();
		long time = (end - start)/1000;
		System.out.println("Done in " + time + "s");

	}

}
