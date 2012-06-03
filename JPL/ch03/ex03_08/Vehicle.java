package ch03.ex03_08;

public class Vehicle implements Cloneable{
	private long speed;
	private double angle;
	private String owner;
	private static long nextId = 0;
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

	public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }
}
