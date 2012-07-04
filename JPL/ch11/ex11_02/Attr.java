package ch11.ex11_02;

public class Attr<E> {

	private final String name;
	private E value = null;

	public Attr(String name) {
		this.name = name;
	}

	public Attr(String name, E value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public E getValue() {
		return value;
	}

	public E setValue(E newValue) {
		E oldVal = value;
		value = newValue;
		return oldVal;
	}

	public String toString() {
		return name + "= '" + value + "'";
	}

	public static void main(String[] args){
		Attr<String> attrName = new Attr<String>("attrName ");
		attrName.setValue("Cindy");
		System.out.println(attrName);

		Attr<Integer> attrAge = new Attr<Integer>("attrAge ");
		attrAge.setValue(25);
		System.out.println(attrAge);

	}
}
