package ch20.ex20_09;

import java.io.File;
import java.io.IOException;

public class FileInfo {
	public static void showFileInfo(String fileName) throws IOException{
		File file = new File(fileName);
		String canonicalPath = file.getCanonicalPath();

		System.out.println(file);
		System.out.println("exists?\t\t" + file.exists());
		System.out.println("name:\t\t" + file.getName());
		System.out.println("path:\t\t" + file.getPath());
		System.out.println("absolute path:\t" + file.getAbsolutePath());
		System.out.println("canonical path:\t" + file.getCanonicalPath());
		System.out.println("parent:\t\t" + file.getParent());
		System.out.println("is a file?:\t" + file.isFile());
		System.out.println("is a dir?:\t" + file.isDirectory());

		System.out.println("length:\t\t" + file.length());
		System.out.println("can read:\t" + file.canRead());
		System.out.println("can write:\t" + file.canWrite());
		System.out.println("last modified:\t" + file.lastModified());
		System.out.println("canonical path:\t" + file.getCanonicalPath());
	}


	public static void main(String[] args) throws IOException{
		showFileInfo("JPL/ch20/ex20_09/FileInfo.java");
	}
}
