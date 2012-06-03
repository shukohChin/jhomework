package ch09.ex09_02;

public class Ex09_02 {
	public static void main(String[] args){
		System.out.println("2の中の1: " + getBitCount(2));
		System.out.println("5の中の1: " + getBitCount(5));
		System.out.println("10の中の1: " + getBitCount(10));
		System.out.println("100の中の1: " + getBitCount(100));

	}

	public static int getBitCount(int value) {
		int count = 0;
		while (value > 0) {
			count++;
			value &= (value - 1);
		}
		return count;
	}
}
