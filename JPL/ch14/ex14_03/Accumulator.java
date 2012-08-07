package ch14.ex14_03;

public class Accumulator{
	private int curNum;

	Accumulator(int num) {
		this.curNum = num;
	}

	public synchronized void add() {
		curNum++;
		System.out.println(Thread.currentThread().getName() + ": " + curNum);
	}

}
