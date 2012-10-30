package ch21.ex21_02;

import java.util.WeakHashMap;
import java.io.File;
class DataHandler {
	private File lastFile;

	private WeakHashMap<File, byte[]> wmap = new WeakHashMap<File, byte[]>();

	byte[] readFile(File file) {
		byte[] data = null;

		if (wmap.containsKey(lastFile)) {
			data = wmap.get(lastFile);
		      if (data != null)
		        return data;
		}

		data = readBytesFromFile(file);
		lastFile = file;
		wmap.put(lastFile, data);
		return data;
	}


	byte[] readBytesFromFile(File file){
		return null;

	}
}
