package tarena.day23_socket;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestCalendar {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		int month = c.get(Calendar.MONTH) + 1;
		System.out.println(month);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		System.out.println(c.get(YEAR) + "-" + (c.get(MONTH) + 1) + "-"
				+ c.get(DAY_OF_MONTH));
		c.set(YEAR, 2010);
		c.set(MONTH, 11);// 12��
		c.set(DAY_OF_MONTH, 1);
		Date d = c.getTime();
		System.out.println(d);
		Calendar c1 = Calendar.getInstance(Locale.US);
		Date d1 = c1.getTime();
		System.out.println(d1);
	}
}
