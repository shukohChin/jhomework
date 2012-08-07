package ch14.ex14_06;

public class TimerThread extends Thread{
	int count = 0;

	public void run(){
		try {
			for(int i = 0; i < 20; i++){
				System.out.println(count + "秒");
				count++;
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		TimerThread t1 = new TimerThread();
		PrintEveryNSec t2 = new PrintEveryNSec(7);
		PrintEveryNSec t3 = new PrintEveryNSec(15);
		t1.start();
		t2.start();
		t3.start();
	}
}
