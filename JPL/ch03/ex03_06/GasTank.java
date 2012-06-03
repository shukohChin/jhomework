package ch03.ex03_06;

public class GasTank extends EnergySource{
	public double f = 20.0;

	boolean empty(){
		return f <= 0;
	}
}
