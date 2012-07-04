package ch13.ex13_06;

public class Ex13_06 {
	public static String replace(String str, int digit){
		int strLength = str.length();
		int refVal = strLength % digit;
		StringBuilder sb = new StringBuilder();

		sb.append(str.subSequence(0, refVal));
		if(refVal != 0){
			sb.append(',');
		}

		for(int i = refVal; i + digit <= strLength;){
			sb.append(str.subSequence(i, i + digit));
			if((i + digit) != strLength){
				sb.append(',');
			}
			i += digit;
		}
		return sb.toString();
	}

	public static void main(String[] args){
		System.out.println(replace("1234567890000000000", 1));
		System.out.println(replace("1234567890000000000", 2));
		System.out.println(replace("1234567890000000000", 3));
		System.out.println(replace("1234567890000000000", 4));
		System.out.println(replace("1234567890000000000", 5));
	}
}
