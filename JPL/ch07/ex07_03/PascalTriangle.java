package ch07.ex07_03;

public class PascalTriangle {


	public static void main(String[] args) {
		PascalTriangle p = new PascalTriangle();
		p.calc();
		p.print();
	}



	private static final int DEPTH = 12;

	private int[][] array = new int[DEPTH][];

	public PascalTriangle() {

	}

	public void calc(){

		for(int i=0; i<DEPTH; i++){
			System.out.println("i=" + i);

			array[i] = new int[i+1];

			for(int j=0; j<i+1; j++){
				System.out.println("j=" + j);

				if((i-1) >= 0 && (j-1) >= 0 && j < i){
					array[i][j] = array[i-1][j-1] + array[i-1][j];
				}
				else{
					array[i][j] = 1;
				}
			}

		}

	}

	public void print() {
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++){
				System.out.printf(array[i][j] + " ");
			}
			System.out.printf("%n");
		}
	}

}
