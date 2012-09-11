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
		return c == -1 ? c : c ^ b;
	}

	public int read(byte[] buf, int offset, int count) throws IOException {
		int nread = super.read(buf, offset, count);
		int last = offset + nread;

		for(int i = offset; i < last; i++){
			buf[i] = (byte)(buf[i] ^ b);
		}
		return nread;

	}
}
