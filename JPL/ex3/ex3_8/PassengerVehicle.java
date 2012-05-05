package ex3.ex3_8;

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
}
