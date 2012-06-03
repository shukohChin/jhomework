package ch04.ex04_03;

public interface LinkedList {
	public void setObj(Object obj);

	public Object getObj();

	public LinkedList getNext();

	//インターフェースなのに、実装を意識しているので、インターフェースをすべきではない
	public void setNext(LinkedListImpl next);

}
