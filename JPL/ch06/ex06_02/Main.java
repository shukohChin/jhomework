package ch06.ex06_02;

public class Main {
	/**
	 * enumの利点は型安全、Turn型かnullしかパラメータとして入れられない
	 */
	public static void main(String[] args) {
		Vehicle bike = new Vehicle("Jack");
		bike.setAngle(30.0);
		System.out.println(bike + "\n");

		bike.turn(Vehicle.Turn.TURN_LEFT);
		System.out.println("TURN_LEFT: \n" + bike + "\n");

		bike.turn(Vehicle.Turn.TURN_RIGHT);
		System.out.println("TURN_RIGHT: \n" + bike + "\n");
	}
}
