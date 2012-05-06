package ex4.ex4_1;

public class GasTank implements EnergySource{
	public double f = 20.0;

	public boolean empty(){
		return f <= 0;
	}
}
