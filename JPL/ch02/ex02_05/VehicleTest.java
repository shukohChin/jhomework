package ch02.ex02_05;

import org.junit.Test;

import junit.framework.TestCase;


public class VehicleTest extends TestCase{
	@Test
	public void testShow() {
		Vehicle bike = new Vehicle();
		bike.id = Vehicle.nextId++;
		bike.speed = 100;
		bike.angle = "east";
		bike.owner = "Jack";
		bike.show("bike");

		System.out.println();

		Vehicle car = new Vehicle();
		car.id = Vehicle.nextId++;
		car.speed = 200;
		car.angle = "west";
		car.owner = "Cindy";
		car.show("car");
	}
}
