package ch23.ex23_02;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class MyProcess {
	public static void exec(String cmd[]) {
		try {
			Process child = Runtime.getRuntime().exec(cmd);
			InputStream in = child.getInputStream();
			InputStreamReader r = new InputStreamReader(in);
			LineNumberReader l = new LineNumberReader(r);

			String line;
			while((line = l.readLine()) != null) {
				System.out.println(l.getLineNumber() + ": " + line);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		exec(args);
	}
}
