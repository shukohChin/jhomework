package ch02.ex02_07;

import org.junit.Test;

import junit.framework.TestCase;


public class VehicleTest extends TestCase {
	@Test
	public void testShow() {
		Vehicle bike = new Vehicle("Jack");
		bike.id = Vehicle.nextId++;
		bike.speed = 100;
		bike.angle = "east";
		bike.show("bike");

		System.out.println();

		Vehicle car = new Vehicle("Cindy");
		car.id = Vehicle.nextId++;
		car.speed = 200;
		car.angle = "west";
		car.show("car");
	}
}
