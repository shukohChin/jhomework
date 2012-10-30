package ch20.ex20_10;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class WordCounter {


	public static void main(String[] args) throws IOException{
		FileReader fileReader = new FileReader("JPL/ch20/ex20_10/word");
		StreamTokenizer token = new StreamTokenizer(fileReader);
		Map<String, Integer> map  = new HashMap<String, Integer>();

		while(token.nextToken() != StreamTokenizer.TT_EOF){
			if(token.ttype == StreamTokenizer.TT_WORD){
				String word = token.sval;
				Integer count = map.get(word);
				if(count == null){
					map.put(word, 1);
				}else{
					map.put(word, count + 1);
				}
			}
		}

		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> entry : entrySet){
			System.out.println(entry.getKey() + ":\t" + entry.getValue() + " time(s)");
		}

	}
}
