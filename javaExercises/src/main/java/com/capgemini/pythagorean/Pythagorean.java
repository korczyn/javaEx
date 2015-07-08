package com.capgemini.pythagorean;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which, a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52. There exists
 * exactly one Pythagorean triplet for which a + b + c = 1000. Find the product
 * abc.
 */
public class Pythagorean {

	public static int a, b, c;

	public static int findPythagoreanTriplet() {
		for (a = 1; a < 1000; a++) {
			for (b = a + 1; b < 1000; b++) {
				c = 1000 - a - b;
				if (a * a + b * b == c * c) {
					System.out.println(a + " " + b + " " + c);
					return 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		findPythagoreanTriplet();
		System.out.println(a+b+c);
	}
}
