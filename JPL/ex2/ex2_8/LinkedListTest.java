package ex2.ex2_8;

import org.junit.Test;

import ex2.ex2_5.Vehicle;

import junit.framework.TestCase;


public class LinkedListTest extends TestCase{
	@Test
	public void testShow() {
		Vehicle bike = new Vehicle();
		bike.id = Vehicle.nextId++;
		bike.angle = "east";
		bike.owner = "Jack";
		bike.speed = 100;
		Vehicle car = new Vehicle();
		car.id = Vehicle.nextId++;
		car.angle = "west";
		car.owner = "Cindy";
		car.speed = 200;

		LinkedList item1 = new LinkedList(bike, null);
		LinkedList item2 = new LinkedList(car, item1);

		item2.show();
	}
}
