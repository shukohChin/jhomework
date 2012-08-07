package ch14.ex14_04;

public class Accumulator {
	private static int curNum = 0;

	public static synchronized void add() {
		curNum++;
		System.out.println(Thread.currentThread().getName() + ": " + curNum);
	}
}
