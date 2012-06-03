package ch02.ex02_09;

import org.junit.Test;

import junit.framework.TestCase;


public class VehicleTest extends TestCase {
	@Test
	public void testGetMaxId() {
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

		System.out.println();

		long maxId = Vehicle.getMaxId();
		assertEquals(1, maxId);
	}
}
