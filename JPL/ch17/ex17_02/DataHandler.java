package ch17.ex17_02;

import java.io.File;
import java.lang.ref.WeakReference;

public class DataHandler {
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;


	byte[] readFile(File file) {
		byte[] data;

		if(lastFile == null || lastFile.get() == null){
			lastFile = new WeakReference<File>(file);
			data = readBytesFromFile(file);
			lastData = new WeakReference<byte[]>(data);
			return data;
		}


		// check to see if we remember the data
		if (file.equals(lastFile.get())) {
			data = lastData.get();
			if (data != null)
				return data;
		}

		data = readBytesFromFile(file);
		lastData = new WeakReference<byte[]>(data);
		return data;

	}


	byte[] readBytesFromFile(File file){
		return null;

	}
}
