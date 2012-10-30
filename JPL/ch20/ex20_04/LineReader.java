package ch20.ex20_04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class LineReader extends FilterReader {
	public LineReader(Reader in) {
		super(in);
	}
	public String readLine() throws IOException {
		StringBuilder sb = new StringBuilder();
		int c;
		while ((c = super.read()) != -1) {
			sb.append((char) c);
			if (c == '\n') // LF
				break;
		}

		if (sb.toString().toString().equals(""))
			return null;
		else
			return sb.toString();

	}

}
