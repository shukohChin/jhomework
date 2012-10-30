package ch20.ex20_11;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter implements FilenameFilter{
	String suffix;

	MyFilenameFilter(String suffix) {
		this.suffix = suffix;
	}

	public boolean accept(File dir, String name) {
		// TODO 自動生成されたメソッド・スタブ
		return name.endsWith(suffix);
	}

	public static void main(String[] args) {
		File dir = new File("JPL/ch20/ex20_11");

		File[] files = dir.listFiles(new MyFilenameFilter("txt"));
		System.out.println(files.length + "dir(s)");
		for(File file : files) {
			System.out.println("\t" + file);
		}
	}

}
