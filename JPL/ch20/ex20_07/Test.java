package ch20.ex20_07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		Attr attr1 = new Attr("Name", "Cindy");
		attr1.save(new ObjectOutputStream(new FileOutputStream("JPL/ch20/ex20_07/out")));

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("JPL/ch20/ex20_07/out"));
		Attr attr2 = new Attr(in);
		System.out.println(attr2.getName() + " = " + attr2.getValue());
	}
}
