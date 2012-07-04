package ch10.ex10_05;

public class Ex10_5 {
	public static void getSeq(char a, char b){
		char begin;
		char end;

		if(a < b){
			begin = a;
			end = b;
		}else{
			begin = b;
			end = a;
		}

		for(char c= begin; c <= end; c++){
			System.out.print(begin++);
		}
		System.out.println();
	}

	public static void main(String[] args){
		getSeq('a', 'z');
		getSeq('9', '1');
		getSeq('a', '1');
	}
}
