package ex2.ex2_7;

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

	public void show(String type) {
		System.out.println(type);
		System.out.println("speed: " + speed);
		System.out.println("angle: " + angle);
		System.out.println("owner: " + owner);
		System.out.println("id: " + id);
	}
}
