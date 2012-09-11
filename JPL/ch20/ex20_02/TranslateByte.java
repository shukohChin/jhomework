package ch20.ex20_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte extends FilterInputStream{
	byte from;
	byte to;
	protected TranslateByte(InputStream in, byte from, byte to) {
		super(in);
		this.from = from;
		this.to = to;
	}

	public void translateByte(InputStream in, OutputStream out, byte from, byte to) throws IOException{
		int b;
		while((b = in.read()) != -1){
			out.write(b == from ? to : b);
		}
	}

	public int read() throws IOException{
		int b;
		while((b = super.read()) != -1){
			return (b == from ? to : b);
		}
		return -1;
	}

    public int read(byte buf[], int offset, int count) throws IOException{
		int b;
		while((b = super.read(buf, offset, count)) != -1){
			return (b == from ? to : b);
		}
		return -1;
	}

    public static void main(String[] args)throws IOException{
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
		InputStream in = new FileInputStream(in_f);
		OutputStream out = new FileOutputStream(out_f);

		TranslateByte trans = new TranslateByte(in, from, to);
		trans.translateByte(in, out, from, to);
    }
}
