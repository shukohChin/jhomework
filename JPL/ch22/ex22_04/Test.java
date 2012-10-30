package ch22.ex22_04;

public class Test {
	public static void main(final String[] args) {
		Attr attr = new Attr("name", "cindy");
		Attributed observer = new Attributed(attr);
		attr.setValue("not change");
		attr.setValue("hey");
	}
}
