package ch12.ex12_01;

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

	public E getEle() {
		return element;
	}

	public void setEle(E ele) {
		this.element = ele;
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

	public LinkedList<E> find(E ele)throws ObjectNotFoundException{
		LinkedList<E> current = this.next;
		while(current != null){
			if(current.element == ele){
				return current;
			}
			current = current.next;
		}
		throw new ObjectNotFoundException(ele);
	}

	public static void main(String[] args) throws ObjectNotFoundException {
		Vehicle bike = new Vehicle("Jack");
		bike.setAngle(2.0);
		bike.setSpeed(100);
		Vehicle car = new Vehicle("Tom");
		car.setAngle(3.0);
		car.setSpeed(200);

        LinkedList<Vehicle> item1 = new LinkedList<Vehicle>();
		LinkedList<Vehicle> item2 = new LinkedList<Vehicle>();
		item1.setEle(bike);
		item2.setEle(car);
		item1.setNext(item2);
		item2.setNext(null);
		System.out.println(item1 + "\n");
		item1.find(bike);
	}
}
