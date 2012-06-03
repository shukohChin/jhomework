package ch09.ex09_04;

public class Ex09_04 {
	public static void main(String[] args) {
		System.out.println(3 << 2L - 1);										// 6
		System.out.println((3 << 2L) - 1);										// 11
		System.out.println(10 < 12 == 6 > 17);									// false
		System.out.println(10 << 12 == 6 >> 17);								// false
		System.out.println(13.5e-1 % Float.POSITIVE_INFINITY);					// 13.5e-1
		System.out.println(Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY);	// NaN
		System.out.println(Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY);	// Infinity
		System.out.println(0.0 / -0.0 == -0.0 / 0.0);							// false ??
		System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);				// -1
		System.out.println(Long.MAX_VALUE + 5);									// -9223372036854775804
		System.out.println((short) 5 * (byte) 10);								// 50
//???	(i < 15 ? 1.72e3f : 0)
		int i = 3;
		System.out.println(i++ + i++ + --i);									//11
	}
}
