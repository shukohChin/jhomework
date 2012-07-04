package ch13.ex13_04;

import java.util.ArrayList;
import java.util.List;

public class MapReader {
	private static List<Object> list = new ArrayList<Object>();
	public static List<Object> convert(String input){
		String strs[] = input.split("\n");
		for(String str : strs){
			String[] s = str.split(" ");
			String type = s[0];
			String value = s[1];
			convertToObject(type, value);
		}
		return list;
	}

	public static void convertToObject(String type, String value){
		if(type.equals("Boolean")) {
			list.add(new Boolean(value));
		}
		else if(type.equals("Character")) {
			list.add(new Character(value.charAt(0)));
		}
		else if(type.equals("Integer")) {
			list.add(new Integer(value));
		}
		else if(type.equals("Float")){
			list.add(new Float(value));
		}else if(type.equals("Double")){
			list.add(new Double(value));
		}else{
			throw new IllegalArgumentException("? " + type);
		}
	}

	public static void main(String[] args){
		String str = "Boolean true\nCharacter c\nInteger 1\nFloat 2\nDouble 3\n";
		List<Object> list = convert(str);
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}
