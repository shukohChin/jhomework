package ch13.ex13_05;

public class Ex13_05 {
	public static String replace(String str){
		int strLength = str.length();
		int refVal = strLength % 3;
		StringBuilder sb = new StringBuilder();

		sb.append(str.subSequence(0, refVal));
		if(refVal != 0){
			sb.append(',');
		}

		for(int i = refVal; i + 3 <= strLength;){
			sb.append(str.subSequence(i, i + 3));
			if((i + 3) != strLength){
				sb.append(',');
			}
			i += 3;
		}
		return sb.toString();
	}

	public static void main(String[] args){
		System.out.println(replace("1234567890000000000"));
	}
}
