package ch20.ex20_08;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Ex20_08 {
	public static void main(String[] args) {
		try {
			createTable();
			showEntry();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void createTable() throws IOException {

		RandomAccessFile randomFile = new RandomAccessFile("JPL/ch20/ex20_08/file", "r");
		RandomAccessFile tableFile = new RandomAccessFile("JPL/ch20/ex20_08/table", "rw");

		List<Long> table = new ArrayList<Long>();
		try {
			while (true) {
				if (randomFile.readByte() == '%'
						&& randomFile.readByte() == '%') {
					long pointer = randomFile.getFilePointer();
					table.add(pointer);
				}
			}
		} catch (EOFException e) {

		}

		for (Long pointer : table)
            tableFile.writeLong(pointer);
	}

	public static void showEntry() throws IOException {

		RandomAccessFile randomSource = new RandomAccessFile("JPL/ch20/ex20_08/file", "r");
		RandomAccessFile tableFile = new RandomAccessFile("JPL/ch20/ex20_08/table", "r");

		List<Long> table = new ArrayList<Long>();
		try {
			while (true) {
				long point = tableFile.readLong();
				table.add(point);
			}
		} catch (EOFException e) {

		}

		for (Long point : table) {
            randomSource.seek(point);
            String entry = randomSource.readLine();
            if (entry != null)
                System.out.println(entry);
        }
	}
}
