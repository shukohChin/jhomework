package ex2.ex2_13;

public class Vehicle {
	private long speed;
	private String angle;
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

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public String getAngle() {
		return angle;
	}

	public void setAngle(String angle) {
		this.angle = angle;
	}


	@Override
	public String toString() {
		return "Vehicle [speed=" + speed + ", angle=" + angle + ", owner="
				+ owner + ", id=" + id + "]";
	}

}
