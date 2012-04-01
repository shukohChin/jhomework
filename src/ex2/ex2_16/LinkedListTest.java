package ex2.ex2_16;

import org.junit.Test;

import ex2.ex2_15.Vehicle;

import junit.framework.TestCase;


public class LinkedListTest extends TestCase{
	@Test
	public void testGetNumber() {
		Vehicle bike = new Vehicle("Jack");
		bike.setAngle("east");
		bike.setSpeed(100);
		Vehicle car = new Vehicle("Cindy");
		car.setAngle("west");
		car.setSpeed(200);

		LinkedList item1 = new LinkedList();
		LinkedList item2 = new LinkedList();
		item2.setObj(car);
		item1.setObj(bike);
		item2.setNext(item1);
		item1.setNext(null);
		System.out.println(item2);

		int num = item2.getNumber();
		assertEquals(2, num);
	}
}
