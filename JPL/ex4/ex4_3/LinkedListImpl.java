package ex4.ex4_3;

public class LinkedListImpl implements LinkedList{
	private Object obj;
	private LinkedListImpl next;

	public LinkedListImpl() {

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

	public void setNext(LinkedListImpl next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return obj + "next:\n" + next + "\n";
	}

	public Object clone() {
		try {
			LinkedListImpl list = (LinkedListImpl) super.clone();
			if (next != null) {
				list.next = (LinkedListImpl) next.clone();
			}
			return list;

		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}
