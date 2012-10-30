package ch22.ex22_14;

import java.util.StringTokenizer;

public class Sum {
	public static double sum(String source) {
		StringTokenizer tokens = new StringTokenizer(source, " ");
		double total = 0;
		while (tokens.hasMoreTokens()) {
			String value = tokens.nextToken();
			Double d = Double.valueOf(value);
			total += d;
		}
		return total;
	}

	public static void main(final String[] args) {
		String str = "1.0 2.0 1.1 2.1";
		System.out.println(Sum.sum(str));
	}
}
