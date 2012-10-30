package ch22.ex22_02;

import java.util.HashSet;
import java.util.Set;

public class WhichChars {
	private Set<Character> used = new HashSet<Character>();

	  WhichChars(String str) {
	    for (int i = 0; i < str.length(); ++i)
	      used.add(str.charAt(i));
	  }

	  public String toString() {
	    String desc = "[";
	    for (Character ch : used) {
	      desc += ch;
	    }
	    return desc + "]";
	  }

	  public static void main(String[] args) {
	    WhichChars whichChars = new WhichChars("Testing 1 2 3");
	    System.out.println(whichChars);
	  }
}
