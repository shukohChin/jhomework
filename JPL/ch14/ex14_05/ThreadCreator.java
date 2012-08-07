package ch14.ex14_05;

public class ThreadCreator implements Runnable{
	public void run() {
		// TODO 自動生成されたメソッド・スタブ
		try {
			for (int i = 0; i < 10; i++) {
				Accumulator.add();
				Thread.sleep(50);
			}

			for (int i = 0; i < 10; i++) {
				Accumulator.minus();
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ThreadCreator threadCreator = new ThreadCreator();
		Thread th1 = new Thread(threadCreator, "thread1");
		Thread th2 = new Thread(threadCreator, "thread2");

		th1.start();
		th2.start();
	}
}
