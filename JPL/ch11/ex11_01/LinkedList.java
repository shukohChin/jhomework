package ch11.ex11_01;

import ch03.ex03_08.Vehicle;

public class LinkedList<E> {
	private E element;
	private LinkedList<E> next;

	public int getNumber() {
		if(next == null) {
			return 1;
		} else {
			return (1 + next.getNumber());
		}
	}

	public E getObj() {
		return element;
	}

	public void setObj(E obj) {
		this.element = obj;
	}

	public LinkedList<E> getNext() {
		return next;
	}

	public void setNext(LinkedList<E> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "element:" + element + "\nnext " + next;
	}


	public static void main(String[] args) {
		Vehicle bike = new Vehicle("Jack");
		bike.setAngle(2.0);
		bike.setSpeed(100);
		Vehicle car = new Vehicle("Tom");
		car.setAngle(3.0);
		car.setSpeed(200);

        LinkedList<Vehicle> item1 = new LinkedList<Vehicle>();
		LinkedList<Vehicle> item2 = new LinkedList<Vehicle>();
		item1.setObj(bike);
		item2.setObj(car);
		item1.setNext(item2);
		item2.setNext(null);
		System.out.println(item1 + "\n");
	}

}
