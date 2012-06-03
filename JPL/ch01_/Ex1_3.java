package ch01_;

public class Ex1_3 {
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		int title = 1;
		System.out.println(title + ": " + lo);
		while(hi < 50) {
			title ++;
			System.out.println(title + ": " + hi);
			hi = lo + hi;
			lo = hi -lo;
		}
	}
}
