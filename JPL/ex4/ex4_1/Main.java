package ex4.ex4_1;

public class Main {
	public static void main(String[] args){
		Vehicle gasV = new Vehicle(new GasTank());
        gasV.start();

        Vehicle batteryV = new Vehicle(new Battery());
        batteryV.start();
	}
}
