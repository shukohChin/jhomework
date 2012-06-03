package ch01.ex01_10;

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;

	static class Result {
		int value;
		boolean isEven;
	}
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		Result[] result = new Result[MAX_INDEX];
		for(int i = 0; i < MAX_INDEX; i++){
			result[i] = new Result();
		}

		result[0].value = lo;
		result[0].isEven = (lo % 2 == 0);

		for(int i = 2; i <= MAX_INDEX; i++) {
			if(hi % 2 == 0)
				result[i -1].isEven = true;
			else
				result[i -1].isEven = false;
			result[i -1].value = hi;
			hi = lo + hi;
			lo = hi -lo;
		}

		String mark;
		for(int i = 0; i < result.length; i++) {
			if(result[i].isEven == true)
				mark = "* ";
			else
				mark = "";
			System.out.println(result[i].value + mark);
		}
	}
}
