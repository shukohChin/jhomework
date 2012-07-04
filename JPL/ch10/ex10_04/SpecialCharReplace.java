package ch10.ex10_04;

//forはわかりやすい
public class SpecialCharReplace {
	public static String replaceSpecialChar(String str){
		StringBuilder s = new StringBuilder();
		int i = 0;
		while(i < str.length()){
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
			i++;
		}

		return s.toString();
	}

	public static String replaceSpecialChar2(String str){
		StringBuilder s = new StringBuilder();
		int i = 0;
		do{
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
			i++;
		}while(i < str.length());

		return s.toString();
	}

	public static void main(String[] args){
		String str = "1gfd5\n698uh0\r\\123abc\'de543fg\\hijk\"lmn";
		System.out.println(str);

		System.out.println(replaceSpecialChar(str));
		System.out.println(replaceSpecialChar2(str));
	}
}
