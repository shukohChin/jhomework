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
		File in_f = new File("TranslateByte.java");
		File out_f = new File("TranslateByte.java.translate");
		if(!in_f.exists()){
			in_f.createNewFile();
		}
		if(!out_f.exists()){
			out_f.createNewFile();
		}
		InputStream fin = new FileInputStream(in_f);
		OutputStream fout = new FileOutputStream(out_f);

		TranslateByte trans = new TranslateByte();
		trans.translateByte(fin, fout, from, to);
	}

	public void translateByte(InputStream in, OutputStream out, byte from, byte to) throws IOException{
		int b;
		while((b = in.read()) != -1)
			out.write(b == from ? to : b);
	}
}
