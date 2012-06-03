package ch02.ex02_15;

import org.junit.Test;

import junit.framework.TestCase;


public class VehicleTest extends TestCase {
	@Test
	public void testChangeSpeed() {
		Vehicle bike = new Vehicle("Jack");
		bike.setSpeed(100);
		bike.setAngle("east");

		System.out.println(bike);

		//change speed
		System.out.println("CHANGE:");
		bike.changeSpeed(150);
		System.out.println(bike);

		long speedNow = bike.getSpeed();
		assertEquals(150, speedNow);
	}
}
