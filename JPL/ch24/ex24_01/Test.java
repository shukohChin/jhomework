package ch24.ex24_01;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test {
	public static void main(String[] args) {
		testDefault();
	}

	public static void testDefault() {
		ResourceBundle res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes");
		// default
		System.out.println("DEFAULT: ");
		print(res);
		System.out.println();

		// En
		Locale locEn = new Locale("en");
		ResourceBundle resEn = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes", locEn);
		System.out.println("EN: ");
		print(resEn);
		System.out.println();

		// En_Au
		Locale locEnAu = new Locale("en", "AU");
		ResourceBundle resEnAu = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes", locEnAu);
		System.out.println("EN_AU: ");
		print(resEnAu);
		System.out.println();

		// Zh_CN
		Locale locCn = new Locale("zh", "CN");
		ResourceBundle resCn = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes", locCn);
		System.out.println("China: ");
		print(resCn);
		System.out.println();

	}

	public static void print(ResourceBundle res) {
		String msg;
		msg = res.getString(GlobalRes.GOODBYE);
		System.out.println(msg);
		msg = res.getString(GlobalRes.HELLO);
		System.out.println(msg);
	}
}
