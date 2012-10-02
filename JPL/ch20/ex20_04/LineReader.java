package ch20.ex20_04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class LineReader extends FilterReader {

	protected LineReader(Reader in) {
		super(in);
	}

	public String readLine() throws IOException {

		StringBuilder sb = new StringBuilder();

		int c;

		while ((c = super.read()) != -1) {
			// Windows CR+LF

			if (c == '\r') // CR
				continue;

			if (c == '\n') // LF
				return sb.toString();

			sb.append((char) c);
		}

		if (sb.toString().length() == 0)
			return null;
		else
			return sb.toString();

	}

}
