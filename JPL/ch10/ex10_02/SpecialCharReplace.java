package ch10.ex10_02;

public class SpecialCharReplace {
	public static String replaceSpecialChar(String str){
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			switch (c){
			case '\t':
				s.append('\\');
				s.append('t');
				break;
			case '\b':
				s.append('\\');
				s.append('b');
				break;
			case '\r':
				s.append('\\');
				s.append('r');
				break;
			case '\f':
				s.append('\\');
				s.append('f');
				break;
			case '\n':
				s.append('\\');
				s.append('n');
				break;
			case '\\':
				s.append('\\');
				s.append('\\');
				break;
			case '\'':
				s.append('\\');
				s.append('\'');
				break;
			case '\"':
				s.append('\\');
				s.append('\"');
				break;
			default:
				s.append(c);
			}

		}

		return s.toString();
	}


	public static void main(String[] args){
		String str = "1gfd5\n698uh0\r\\123abc\'de543fg\\hijk\"lmn";
		System.out.println(str);

		String result = replaceSpecialChar(str);
		System.out.println(result);
	}
}
