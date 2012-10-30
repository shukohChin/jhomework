package ch21.ex21_01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ch20.ex20_04.LineReader;

public class LineSorter {
	public static void main(String[] args) throws IOException{
		FileReader fileReader = new FileReader("JPL/ch21/ex21_01/LineSorter.java");

		List<String> list = new ArrayList<String>();

		LineReader lineReader = new LineReader(fileReader);

		String line;
		while((line = lineReader.readLine()) != null){
			list.add(line);
		}

		Object[] objectArray = list.toArray();
		String[] stringArray = new String[objectArray.length];
		for(int i = 0; i < stringArray.length; i++){
			stringArray[i] = (String)objectArray[i];
		}

		Arrays.sort(stringArray, new StringCompare());
		for(String string : stringArray){
			System.out.println(string);
		}

	}
}
