package ch02.ex02_14;

import ch02.ex02_13.Vehicle;

public class LinkedList {
	private Object obj;
	private LinkedList next;

	public LinkedList() {

	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "LinkedList [obj=" + obj + ", next=" + next + "]";
	}

}
