package ex1.ex1_12;

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String fibonacci = "fibonacci: ";
		fibonacci = fibonacci + lo + " ";
		for(int i = 2; i <= MAX_INDEX; i++) {
			fibonacci = fibonacci + hi + " ";
			hi = lo + hi;
			lo = hi -lo;
		}

		System.out.print(fibonacci);
	}
}
