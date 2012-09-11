package ch20.ex20_05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class SearchWord {
	public static void search(String word, String fileName)throws IOException{
		FileReader fileReader = new FileReader(fileName);
		LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

		String line;
		while((line = lineNumberReader.readLine()) != null){
			int lineNumber = lineNumberReader.getLineNumber();
			if(line.indexOf(word) != -1){
				line = lineNumber + " : " + word;
			}else
				line = String.valueOf(lineNumber) + " : not found";
			System.out.println(line);
		}
	}


	public static void main(String[] args)throws IOException{
		search("Reader", "JPL/ch20/ex20_05/SearchWord.java");
	}
}
