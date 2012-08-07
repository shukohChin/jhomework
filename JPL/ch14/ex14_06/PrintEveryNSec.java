package ch14.ex14_06;

public class PrintEveryNSec extends Thread{
	int second;
	PrintEveryNSec(int sec){
		this.second = sec;
	}
	public void run(){
		synchronized (this) {
			while (true)
				try {
					wait(second * 1000);
					System.out.println(second + "秒経過・・・");
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
		}
	}
}
