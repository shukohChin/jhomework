package ch03.ex03_06;

public class Battery extends EnergySource{
	public double v = 2.0;

	boolean empty(){
		return v <= 0;
	}
}
