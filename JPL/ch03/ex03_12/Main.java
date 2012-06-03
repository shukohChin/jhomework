package ch03.ex03_12;

public class Main {
	static Object[] value = { 3, 5, 4, 2, 8 };

	public static void main(String[] args) {
		SortHarness sortHarness = new SimpleSortHarness();
		SortMetrics metrics = sortHarness.sort(value);
		System.out.println("Metrics: " + metrics);
		for (int i = 0; i < value.length; i++)
			System.out.print(value[i] + "\t");
	}
}
