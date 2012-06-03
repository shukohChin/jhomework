package ch09.ex09_01;

public class Ex09_01 {
	public static void main(String[] args) {
		double p = Double.POSITIVE_INFINITY;
		double p2 = Double.POSITIVE_INFINITY;
		double n = Double.NEGATIVE_INFINITY;
		double n2 = Double.NEGATIVE_INFINITY;

		System.out.println(p + p2);
		System.out.println(p - p2);
		System.out.println(p * p2);
		System.out.println(p / p2);

		System.out.println(p + n);
		System.out.println(p - n);
		System.out.println(p * n);
		System.out.println(p / n);
	}
}
