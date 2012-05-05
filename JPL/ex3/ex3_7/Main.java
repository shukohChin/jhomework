package ex3.ex3_7;

public class Main {
	public static void main(String[] args) {
		ColorAttr red = new ColorAttr("red");
		ColorAttr green = new ColorAttr("green");

		System.out.println("red.equals(red): " + red.equals(red));
		System.out.println("red.equals(green): "+ red.equals(green));
		System.out.println("red.hashCode(): " + red.hashCode());
		System.out.println("green.equals(): " + green.hashCode());
	}
}
