package ch06.ex06_02;

public class Vehicle {
	public enum Turn{
		TURN_LEFT, TURN_RIGHT,
	}
	private long speed;
	private double angle;
	private String owner;
	private static long nextId = 0;;
	private long id;

	public Vehicle() {
		id = nextId++;
	}

	public Vehicle(String owner) {
		this();
		this.owner = owner;
	}

	public void changeSpeed(long speedNow) {
		this.speed = speedNow;
	}

	public void turn(double angle) {
		this.angle += angle;
	}

	public void turn(Turn t) {
		switch (t) {
        case TURN_LEFT:
        	turn(-90.0);
        	break;
        case TURN_RIGHT:
        	turn(90.0);
        	break;
		}
	}

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	@Override
	public String toString() {
		return "Vehicle [owner=" + owner + ", angle=" + angle + "]";
	}
}
