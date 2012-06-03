package ch01.ex01_08;

public class Point {
	public double x, y;

	public void clear() {
		x = 0;
		y = 0;
	}

	public void setLocation(Point target) {
		this.x = target.x;
		this.y = target.y;
	}

	public static void main(String[] args) {
		Point p = new Point();
		p.x = 1;
		p.y = 2;

		Point pNew = new Point();
		pNew.setLocation(p);
		System.out.println("x = " + pNew.x);
		System.out.println("y = " + pNew.y);
	}
}
