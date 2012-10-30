package ch20.ex20_04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class EX20_04 {

	public static void main(String[] args) {
		Reader fileReader;

		try {
			fileReader = new FileReader("TEST.java");
		} catch (FileNotFoundException e) {
			System.err.println(e);
			return;
		}

		LineReader lineReader = new LineReader(fileReader);

		try {
			String line;
			while ((line = lineReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
