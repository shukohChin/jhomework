package ch21.ex21_01;

import java.util.Comparator;

public class StringCompare implements Comparator {

	public int compare(Object obj1, Object obj2) {
		return ((String) obj1).compareTo((String) obj2);
	}

}
