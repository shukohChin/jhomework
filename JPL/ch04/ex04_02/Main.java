package ch04.ex04_02;

import ch03.ex03_12.SortMetrics;

public class Main {
	static Object[] value = { 3, 5, 4, 2, 8 };

	public static void main(String[] args) {
		SortHarnessImpl sort = new SortHarnessImpl();
		SortMetrics metrics = sort.sort(value);
		System.out.println("Metrics: " + metrics);
		for (int i = 0; i < value.length; i++)
			System.out.print(value[i] + "\t");
	}
}
