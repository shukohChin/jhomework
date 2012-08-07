package ch16.ex16_04;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Copyright{
	String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Name{
	String first();
	String last();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Author{
	Name value();
}

@Copyright("2012 by chin")
@Author(@Name(first = "shukoh", last = "chin"))
public class Test {
	/**
	 * @deprecated 推奨されない
	 */
	@Deprecated
	public void printA(){
		int a = 0;
		System.out.println(a);
	}
}
