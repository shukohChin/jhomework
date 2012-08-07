package ch14.ex14_02;

public class PrintServer implements Runnable {
	private final PrintQueue requests = new PrintQueue();
	private final long id;

	public PrintServer() {
		Thread thisThread = new Thread(this);
		id = thisThread.getId();
		thisThread.start();
	}
	public void run() {
		// TODO 自動生成されたメソッド・スタブ
		if(Thread.currentThread().getId() != id) {
			return;
		}
		for(;;) {
			realPrint(requests.remove());
		}
	}

	private void realPrint(PrintJob job) {
		//do the real work of printing
	}

}
