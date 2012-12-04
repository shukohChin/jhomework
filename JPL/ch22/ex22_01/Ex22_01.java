package ch22.ex22_01;

import java.util.Formatter;

public class Ex22_01 {
	public static void main(String[] args) {
		Double[] array = {0.0, 1.1, 2.22, 3.333, 4.4444, 5.55555};
		format(array, 5);
	}

	private static void format(Double[] array, int column) {
		// TODO 自動生成されたメソッド・スタブ
		int length = 80;

		int max = length / 10;

		Formatter formatter = new Formatter(System.out);

		int line = array.length / column + 1;

		int index = 0;

		for (int y = 0; y < line; y++) {
			for (int x = 0; x < column; x++) {
				index = x + y * column;
				if (x >= max) continue;
				if (index >= array.length) continue;
				formatter.format("%1$.3e ", array[index]);
			}
			System.out.println();
		}
	}
}
