package ch02.ex02_06;

import ch02.ex02_05.Vehicle;

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
