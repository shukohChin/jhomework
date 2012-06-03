package ch03.ex03_10;

import ch03.ex03_08.Vehicle;

public class LinkedList implements Cloneable{
	private Object obj;
	private LinkedList next;

	public LinkedList() {

	}

	public int getNumber() {
		if(next == null) {
			return 1;
		} else {
			return (1 + next.getNumber());
		}
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Object getObj() {
		return obj;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return obj + "next:\n" + next + "\n";
	}

	public Object clone() {
		try {
			LinkedList list = (LinkedList) super.clone();
			if (next != null) {
				list.next = (LinkedList) next.clone();
			}
			return list;

		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	public static void main(String[] args) {
		Vehicle bike = new Vehicle("Jack");
		bike.setAngle(2.0);
		bike.setSpeed(100);
		Vehicle car = new Vehicle("Tom");
		car.setAngle(3.0);
		car.setSpeed(200);

        LinkedList item1 = new LinkedList();
		LinkedList item2 = new LinkedList();
		item1.setObj(bike);
		item2.setObj(car);
		item1.setNext(item2);
		item2.setNext(null);
		System.out.println(item1 + "\n");

        // COPY
        LinkedList copyList = (LinkedList) item1.clone();

        // Change order
        item2.setNext(item1);
        item1.setNext(null);

        // Change speed
        ((Vehicle)copyList.obj).setSpeed(20);

        System.out.println(item1 + "\n");
        System.out.println(copyList + "\n");

	}
}
