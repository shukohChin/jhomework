package ch20.ex20_03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryInputStream extends FilterInputStream{
	private byte b;

	public DecryInputStream(InputStream in, byte mask) {
		super(in);
		this.b = mask;
	}

	public int read() throws IOException {
		int c = super.read();
		return c ^ b;
	}

	public static void main(String[] args) throws IOException{
		byte key = 0;
		DecryInputStream in = new DecryInputStream(System.in, key);
		EncryptOutputStream out = new EncryptOutputStream(System.out, key);

		int b;
		while((b = in.read()) != -1) {
			out.write(b);
		}
	}
}
