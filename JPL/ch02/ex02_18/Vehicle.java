package ch02.ex02_18;

public class Vehicle {
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
		return  "id=" + id + "\n"
				+ "owner=" + owner + "\n"
				+ "speed=" + speed + "\n"
				+ "angle=" + angle + "\n";
	}

	public static void main(String[] args) {
		if(args.length == 0)
			return;

		Vehicle bike = new Vehicle(args[0]);
		bike.setSpeed(100);
		bike.setAngle(30.0);

		System.out.println("bike:\n" + bike);
	}
}
