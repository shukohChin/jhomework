package ch12.ex12_01;

public class ObjectNotFoundException extends Exception{
	Object obj;

	public ObjectNotFoundException(Object obj){
		this.obj = obj;
	}

}
