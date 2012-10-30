package ch21.ex21_07;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<E> {
	ArrayList<E> list = new ArrayList<E>();
	int index = 0;

	public void push(final E e) {
		this.list.add(e);
		this.index++;
	}

	public E pop() {
		E e = peek();
	    list.remove(list.size() - 1);
	    return e;
	}

	public E peek() {
		if (empty())
			throw new EmptyStackException();
		return list.get(list.size() - 1);
	}

	public boolean empty() {
		return list.size() <= 0;
	}

	public int search(E e) {
	    int index = list.lastIndexOf(e);
	    if (index >= 0)
	      return list.size() - index;
	    return -1;
	  }
}
