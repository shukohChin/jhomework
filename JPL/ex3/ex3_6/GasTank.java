package ex3.ex3_6;

public class GasTank extends EnergySource{
	public double f = 20.0;

	boolean empty(){
		return f <= 0;
	}
}
