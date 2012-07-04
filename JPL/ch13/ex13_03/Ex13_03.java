package ch13.ex13_03;

import java.util.ArrayList;
import java.util.List;

public class Ex13_03 {
	public static String[] delimitedString(String from, char start, char end){
		List<String> subStrList = new ArrayList<String>();
		int startPos = 0;
		int endPos = 0;
		int newStartPos = 0;
		while(true){
			startPos = from.indexOf(start, newStartPos);
			endPos = from.indexOf(end, startPos + 1);
			if(startPos == -1){
				break;
			}else if(endPos == -1){
				subStrList.add(from.substring(startPos));
				break;
			}else{
				subStrList.add(from.substring(startPos, endPos + 1));
				newStartPos = endPos + 1;
			}
		}

		String[] subStringArr = new String[subStrList.size()];
		for(int i = 0; i < subStringArr.length; i++){
			subStringArr[i] = subStrList.get(i);
		}
		return subStringArr;
	}

	public static void main(String[] args){
		String[] str = delimitedString("adfghjklzxcvbnmasc", 'a', 'c');
		for(int i = 0; i < str.length; i++){
			System.out.println(str[i]);
		}
	}
}
