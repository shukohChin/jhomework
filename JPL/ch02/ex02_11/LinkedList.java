package ch02.ex02_11;

import ch02.ex02_05.Vehicle;

public class LinkedList {
	private Object obj;
	private LinkedList next;

	public LinkedList(Object obj, LinkedList next) {
		this.obj = obj;
		this.next = next;
	}

	@Override
	public String toString() {
		return "LinkedList [obj=" + obj + ", next=" + next + "]";
	}

	public void show() {
		System.out.println(obj);
		if(next != null) {
			next.show();
		}
	}

}
