package ch14.ex14_04;

public class ThreadCreator implements Runnable {
	public void run() {
		// TODO 自動生成されたメソッド・スタブ
		try {
			for(int i = 0; i < 10; i++) {
				Accumulator.add();
				Thread.sleep(1000);
			}
		} catch(InterruptedException e) {
			return;
		}
	}

	public static void main(String[] args) {
		ThreadCreator threadCreator = new ThreadCreator();
		Thread th1 = new Thread(threadCreator, "thread1");
		Thread th2 = new Thread(threadCreator, "thread2");
		Thread th3 = new Thread(threadCreator, "thread3");
		Thread th4 = new Thread(threadCreator, "thread4");

		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}
}
