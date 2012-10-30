package ch20.ex20_07;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Attr {
	private final String name;
	private Object value = null;

	public Attr(String name) {
		this.name = name;
	}

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public Attr(ObjectInputStream in) throws IOException, ClassNotFoundException{
		this.name = in.readUTF();
		this.value = in.readObject();
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}

	public String toString() {
		return name + "='" + value + "'";
	}

	public void save(ObjectOutputStream out) throws IOException{
		out.writeUTF(name);
		out.writeObject(value);
	}
}
