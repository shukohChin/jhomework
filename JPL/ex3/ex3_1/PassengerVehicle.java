package ex3.ex3_1;

import ex2.ex2_18.Vehicle;


public class PassengerVehicle extends Vehicle{
	private int seatingCapacity;
	private int numOfPassengers;

	public PassengerVehicle(String owner){
		super(owner);
	}

	public void setSeatingCapacity(int s){
		this.seatingCapacity = s;
	}

	public int getSeatingCapacity(){
		return seatingCapacity;
	}

	public void setNumOfPassengers(int n){
		this.numOfPassengers = n;
	}

	public int getNumOfPassengers(){
		return numOfPassengers;
	}

	public String toString(){
		return super.toString()
			+ "seatingCapacity=" + seatingCapacity + "\n"
			+ "numOfPassengers=" + numOfPassengers;
	}

	public static void main(String[] args){
		PassengerVehicle bus = new PassengerVehicle("Jack");
		bus.setAngle(20.0);
		bus.setNumOfPassengers(0);
		bus.setSeatingCapacity(20);
		bus.setSpeed(50);
		System.out.println(bus);

		PassengerVehicle car = new PassengerVehicle("Cindy");
		car.setAngle(40.0);
		car.setNumOfPassengers(4);
		car.setSeatingCapacity(4);
		car.setSpeed(100);
		System.out.println(car);
	}
}
