package ex3.ex3_6;

public class Vehicle {
	private long speed;
	private double angle;
	private String owner;
	private static long nextId = 0;;
	private long id;

	//追加
	EnergySource energy;

	public Vehicle() {
		id = nextId++;
	}

	public Vehicle(String owner) {
		this();
		this.owner = owner;
	}

	//追加
	public Vehicle(EnergySource e) {
		this.energy = e;
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

	//追加
	public void start(){
		if (energy.empty()) {
            System.out.println("燃料がない");
        } else {
            System.out.println("動作開始");
        }
	}
}
