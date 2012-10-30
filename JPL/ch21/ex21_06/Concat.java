package ch21.ex21_06;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Concat {
	public static void main(String[] args) throws IOException{
		InputStream in;
		if (args.length == 0) {
			in = System.in;
		} else {
			InputStream fileIn, bufIn;
			List<InputStream> inputs = new ArrayList<InputStream>(args.length);
			for (String arg : args) {
				fileIn = new FileInputStream(arg);
				bufIn = new BufferedInputStream(fileIn);
				inputs.add(bufIn);
			}
			Enumeration<InputStream> files = Collections.enumeration(inputs);

			while (files.hasMoreElements()) {
				in = files.nextElement();
				int ch;
				while ((ch = in.read()) != -1)
					System.out.write(ch);
			}

		}

	}
}
