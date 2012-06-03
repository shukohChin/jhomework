package ch02.ex02_08;

import ch02.ex02_05.Vehicle;

public class LinkedList {
	private Object obj;
	private LinkedList next;

	public LinkedList(Object obj, LinkedList next) {
		this.obj = obj;
		this.next = next;
	}

	public void show() {
		System.out.println(obj);
		if(next != null) {
			next.show();
		}
	}

}
