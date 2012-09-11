package ch19.ex19_01;

public class LinkedList {
	/**
	 * The content of this node.
	 */
	private Object obj;
	/**
	 * The next node.
	 */
	private LinkedList next;
	/**
	 * Create a linkedlist node.
	 */
	public LinkedList() {

	}

	/**
	 * Get the number of nodes in this linkedlist.
	 * @return The current node number.
	 */
	public int getNumber() {
		if(next == null) {
			return 1;
		} else {
			return (1 + next.getNumber());
		}
	}

	/**
	 * Get the content of this node.
	 * @return The content set by {@link #setObj(Object)}
	 */
	public Object getObj() {
		return obj;
	}
	/**
	 * Set the content of this node returned by {@link #getObj()}.
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	/**
	 * Get the next node in this linkedlist.
	 * @return The next node.
	 */
	public LinkedList getNext() {
		return next;
	}
	/**
	 * Set the next node in this linkedlist}.
	 */
	public void setNext(LinkedList next) {
		this.next = next;
	}

	/**
	 * Show information of this linkedlist.
	 * @return The string representing all nodes in this list.
	 */
	@Override
	public String toString() {
		return "LinkedList [obj=" + obj + ", next=" + next + "]";
	}

}
