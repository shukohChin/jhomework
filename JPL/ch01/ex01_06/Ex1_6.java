package ch01.ex01_06;

public class Ex1_6 {
	static final String title = "Fibonacci";
	public static void main(String[] args) {

		int lo = 1;
		int hi = 1;
		System.out.println(title + ": " + lo);
		while(hi < 50) {
			System.out.println(title + ": " + hi);
			hi = lo + hi;
			lo = hi -lo;
		}
	}
}
