package ex2.ex2_17;

import org.junit.Test;

import junit.framework.TestCase;


public class VehicleTest extends TestCase {
	@Test
	public void testAngle() {
		Vehicle bike = new Vehicle("Jack");
		bike.setAngle(30.0);
		assertEquals(30.0, bike.getAngle());

		bike.turn(30.0);
		assertEquals(60.0, bike.getAngle());

		bike.turn(Vehicle.TURN_LEFT);
		assertEquals(-30.0, bike.getAngle());
	}
}
