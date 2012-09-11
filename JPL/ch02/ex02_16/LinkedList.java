package ch02.ex02_16;

public class LinkedList {
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
