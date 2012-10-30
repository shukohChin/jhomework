package ch24.ex24_02;

import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;

public class CurrencyPrint {
	public static void main(final String[] args) {
		Locale[] locales = Calendar.getAvailableLocales();
		int num = 6;

		Locale[] selectedLocales = new Locale[num];
		int index = 0;
		int i = 0;
		for(;;) {
			if (!(locales[i].getDisplayCountry().equals(""))) {
				selectedLocales[index++] = locales[i];
				if (index == num) {
					break;
				}
			}
			i++;
		}

		for (int j = 0; j < num; j++) {

			Locale locale = selectedLocales[j];
			for (int k = 0; k < num; k++) {
				Currency currency = Currency.getInstance(selectedLocales[k]);
				System.out.println("Locale : " + locale + ", currency code: "
						+ currency.getCurrencyCode() + " , symbol : "
						+ currency.getSymbol(locale));
			}
			System.out.println();
		}

	}
}
