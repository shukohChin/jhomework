package ch03.ex03_08;

public class Main {
	public static void
	main(String[] args) {
		PassengerVehicle bus = new PassengerVehicle("Jack");
		bus.setAngle(20.0);
		bus.setNumOfPassengers(0);
		bus.setSeatingCapacity(20);
		bus.setSpeed(50);
		System.out.println(bus + "\n");

	    PassengerVehicle busCopy = (PassengerVehicle) bus.clone();
	    System.out.println("COPY:\n" + busCopy);
	}
}
