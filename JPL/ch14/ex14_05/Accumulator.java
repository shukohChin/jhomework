package ch14.ex14_05;

public class Accumulator {
	private static int curNum = 0;

	public static synchronized void add() {
		curNum++;
		System.out.println(Thread.currentThread().getName() + ": " + curNum);
	}

	public static void minus() {
		synchronized(Accumulator.class) {
			curNum--;
			System.out.println(Thread.currentThread().getName() + ": " + curNum);
		}

	}
}
