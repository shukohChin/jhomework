package ch20.ex20_03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream{
	private byte b;
	public EncryptOutputStream(OutputStream out, byte b) {
		super(out);
		this.b = b;
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void write(int i) throws IOException {
		super.write(i ^ b);
	}
}
