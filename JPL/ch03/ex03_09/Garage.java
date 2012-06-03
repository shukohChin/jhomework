package ch03.ex03_09;

import ch03.ex03_08.Vehicle;

public class Garage implements Cloneable{
	private Vehicle[] v;
	private int num;

	public Garage(int capacity) {
		v = new Vehicle[capacity];
		num = -1;
	}

	public void park(Vehicle v) {
		num++;
		this.v[num] = v;
	}

	public Object clone() {
        try {
            Garage obj = (Garage) super.clone();
            obj.v = new Vehicle[v.length];
            for (int i = 0; i <= num; i++) {
                obj.v[i] = (Vehicle) v[i].clone();
            }
            return obj;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }

    public static void main(String[] args) {
        Garage garage = new Garage(5);

        Vehicle v1 = new Vehicle("Jack");
        v1.setAngle(2.0);
        v1.setSpeed(0);
        garage.park(v1);

        Vehicle v2 = new Vehicle("Mike");
        v2.setAngle(30.0);
        v2.setSpeed(0);
        garage.park(v2);

        Garage copyGarage = (Garage)garage.clone();

        for (int i = 0; i <= copyGarage.num; i++) {
            System.out.println(copyGarage.v[i]);
        }
    }
}
