package ex2.ex2_6;

import ex2.ex2_5.Vehicle;

public class LinkedList {
	public Object obj;
	public LinkedList next;

	public void show(){
		System.out.println(obj);
		if(next != null) {
			next.show();
		}
	}

}
