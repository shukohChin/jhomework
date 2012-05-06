package ex4.ex4_1;

public class Battery implements EnergySource{

	// TODO 自動生成されたメソッド・スタブ
	public double v = 2.0;

	public boolean empty() {
		return v <= 0;
	}
}
