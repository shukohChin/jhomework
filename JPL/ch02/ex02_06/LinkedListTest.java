package ch02.ex02_06;

import org.junit.Test;

import ch02.ex02_05.Vehicle;


import junit.framework.TestCase;


public class LinkedListTest extends TestCase {
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

		LinkedList item1 = new LinkedList();
		item1.obj = bike;
		LinkedList item2 = new LinkedList();
		item2.obj = car;
		item1.next = item2;
		item2.next = null;

		item1.show();
	}
}
