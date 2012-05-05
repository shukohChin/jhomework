package ex3.ex3_6;

public class Battery extends EnergySource{
	public double v = 2.0;

	boolean empty(){
		return v <= 0;
	}
}
