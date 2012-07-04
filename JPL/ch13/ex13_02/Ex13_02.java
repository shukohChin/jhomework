package ch13.ex13_02;

public class Ex13_02 {
	public static int count(String str, String sub){
		int count = 0;
		int index = 0;
		int subLength = sub.length();
		while(index < str.length() - 1){
			if(str.subSequence(index, index + subLength).toString().equals(sub)){
				count++;
			}
			index ++;
		}
		return count;
	}

	public static void main(String[] args){
		System.out.println(count("abcdefpoieruyqwert", "er"));
	}
}
