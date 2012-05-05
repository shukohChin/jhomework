package ex2.ex2_10;

import org.junit.Test;

import junit.framework.TestCase;


public class VehicleTest extends TestCase{
	@Test
	public void testToString() {
		Vehicle bike = new Vehicle("Jack");
		bike.id = Vehicle.nextId++;
		bike.speed = 100;
		bike.angle = "east";

		System.out.println("bike" + bike);

		Vehicle car = new Vehicle("Cindy");
		car.id = Vehicle.nextId++;
		car.speed = 200;
		car.angle = "west";

		System.out.println("car" + car);
	}
}
