package ch10.ex10_01;

public class SpecialCharReplace {

	public static String replaceSpecialChar(String str){
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(c == '\n'){
				s.append('\\');
				s.append('n');
			}else if(c == '\\'){
				s.append('\\');
				s.append('\\');
			}else if(c == '\''){
				s.append('\\');
				s.append('\'');
			}else if(c == '\"'){
				s.append('\\');
				s.append('\"');
			}else if(c == '\t'){
				s.append('\\');
				s.append('t');
			}else if(c == '\b'){
				s.append('\\');
				s.append('b');
			}else if(c == '\r'){
				s.append('\\');
				s.append('r');
			}else if(c == '\f'){
				s.append('\\');
				s.append('f');
			}else{
				s.append(c);
			}

		}

		return s.toString();
	}


	public static void main(String[] args){
		String str = "1gfd5\n698uh0\r\\123abc\'de543fg\\hijk\"lmn";
		System.out.println("Original:\n" + str + "\n");

		String result = replaceSpecialChar(str);
		System.out.println(result);
	}
}

