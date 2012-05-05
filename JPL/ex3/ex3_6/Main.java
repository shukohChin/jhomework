package ex3.ex3_6;

public class Main {
	public static void main(String[] args){
		Vehicle gasV = new Vehicle(new GasTank());
        gasV.start();

        Vehicle batteryV = new Vehicle(new Battery());
        batteryV.start();
	}
}
