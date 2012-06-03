package ch02.ex02_13;

import org.junit.Test;

import junit.framework.TestCase;


public class VehicleTest extends TestCase {
	@Test
	public void testEX13() {
		Vehicle bike = new Vehicle("Jack");
		bike.setSpeed(100);
		bike.setAngle("east");

		System.out.println(bike);
	}
}
