package ch01_;

public class Ex1_4 {
	public static void main(String[] args) {
		int row = 1;
		for(int j = row; j < 10; j++){
			for(int i = 1; i <10; i++) {
				System.out.print(i * row);
				System.out.printf("\t");
			}
			System.out.println();
			row++;
		}

	}
}
