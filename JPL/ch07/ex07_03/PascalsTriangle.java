package ch07.ex07_03;

import java.util.Scanner;

public class PascalsTriangle {
	public static void main(String[] args) {
		PascalsTriangle pascal = new PascalsTriangle();
		pascal.pascalAssemble(12);
	}

	public void pascalAssemble(int num) {
		int[][] value = new int[num][num];
		for (int i = 0; i < num; i++) {
			value[i][0] = 1;
			value[i][i] = 1;
			if (i > 1) {
				for (int j = 1; j < i; j++) {
					value[i][j] = value[i - 1][j - 1] + value[i - 1][j];
				}
			}
		}
		for (int i = 0; i < num; i++) {
			for (int k = 0; k <= num - i; k++) {
				System.out.print("   ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print(value[i][j] + "     ");
			}
			System.out.println();
		}
	}
}
