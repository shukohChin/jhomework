package ch02.ex02_10;

public class Vehicle {
	public long speed;
	public String angle;
	private String owner;
	public static long nextId = 0;;
	public long id;

	public Vehicle() {

	}

	public Vehicle(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return " [speed=" + speed + ", angle=" + angle + ", owner="
				+ owner + ", id=" + id + "]";
	}

}
