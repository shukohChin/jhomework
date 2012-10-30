package ch20.ex20_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {
	public static void main(String[] args) throws IOException{
		byte from = (byte) args[0].charAt(0);
		byte to   = (byte) args[1].charAt(0);
		File inFile = new File("TEST.java");
		File outFile = new File("TEST.java.translate");
		if(!inFile.exists()){
			inFile.createNewFile();
		}
		if(!outFile.exists()){
			outFile.createNewFile();
		}
		InputStream fin = new FileInputStream(inFile);
		OutputStream fout = new FileOutputStream(outFile);

		TranslateByte.translateByte(fin, fout, from, to);
	}

	public static void translateByte(InputStream in, OutputStream out, byte from, byte to) throws IOException{
		int b;
		while((b = in.read()) != -1)
			out.write(b == from ? to : b);
	}
}
