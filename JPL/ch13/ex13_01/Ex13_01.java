package ch13.ex13_01;

public class Ex13_01 {
	public static int count(String str, char ch){
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(c == ch)
				count++;
		}
		return count;
	}

	public static void main(String[] args){
		System.out.println(count("abcdefpoiuyqwert", 'e'));
	}
}
