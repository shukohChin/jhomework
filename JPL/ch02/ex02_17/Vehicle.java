package ch02.ex02_17;

public class Vehicle {
	public final static int TURN_LEFT = 0;
    public final static int TURN_RIGHT = 1;

	private long speed;
	private double angle;
	private String owner;
	private static long nextId = 0;;
	private long id;

	public Vehicle() {
		nextId++;
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

	public void turn(int angle) {
		switch (angle) {
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
		return "Vehicle [speed=" + speed + ", angle=" + angle + ", owner="
				+ owner + ", id=" + id + "]";
	}

}
