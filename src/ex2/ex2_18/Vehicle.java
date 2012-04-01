package ex2.ex2_18;

public class Vehicle {
	public long speed;
	public double angle;
	private String owner;
	public static long nextId = 0;;
	public long id;

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

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	@Override
	public String toString() {
		return " [speed=" + speed + ", angle=" + angle + ", owner="
				+ owner + ", id=" + id + "]";
	}

	public static void main(String[] args) {
		if(args.length == 0)
			return;

		Vehicle bike = new Vehicle(args[0]);
		bike.setSpeed(100);
		bike.setAngle(30.0);

		System.out.println("bike" + bike);
	}
}
