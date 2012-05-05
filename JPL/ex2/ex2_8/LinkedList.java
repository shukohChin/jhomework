package ex2.ex2_8;

import ex2.ex2_5.Vehicle;

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
