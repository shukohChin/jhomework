package ch24.ex24_03;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class ParseDate {
	public static void test(final String dateString) {
		final DateFormat format = DateFormat.getDateInstance();
		try {
			final Date date = format.parse(dateString);
			Format fmt = DateFormat.getDateInstance(DateFormat.SHORT);
			System.out.println(fmt.format(date));
			fmt = DateFormat.getDateInstance(DateFormat.MEDIUM);
			System.out.println(fmt.format(date));
			fmt = DateFormat.getDateInstance(DateFormat.LONG, new Locale("en",
			"US"));
			System.out.println(fmt.format(date));
			fmt = DateFormat.getDateInstance(DateFormat.FULL, new Locale("ja",
			"JP"));
			System.out.println(fmt.format(date));
			fmt = DateFormat.getDateInstance(DateFormat.FULL, new Locale("zh",
			"CN"));
			System.out.println(fmt.format(date));
		} catch (final ParseException e) {
			e.printStackTrace();
		}

	}

	public static void main(final String[] args) {
		ParseDate.test("2012/12/22 12:12:12");
	}
}
