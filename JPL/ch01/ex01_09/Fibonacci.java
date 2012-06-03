package ch01.ex01_09;

public class Fibonacci {
	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		int[] array = new int[MAX_INDEX];
		array[0] = lo;

		for(int i = 2; i <= MAX_INDEX; i++) {
			array[i - 1] = hi;
			hi = lo + hi;
			lo = hi -lo;
		}

		for(int i = 0; i < 9; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
