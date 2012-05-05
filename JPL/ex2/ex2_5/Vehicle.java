package ex2.ex2_5;

public class Vehicle {
	public long speed;
	public String angle;
	public String owner;
	public static long nextId = 0;;
	public long id;

	public void show(String type) {
		System.out.println(type);
		System.out.println("speed: " + speed);
		System.out.println("angle: " + angle);
		System.out.println("owner: " + owner);
		System.out.println("id: " + id);
	}

	@Override
	public String toString() {
		return "Vehicle [speed=" + speed + ", angle=" + angle + ", owner="
				+ owner + ", id=" + id + "]";
	}

}
