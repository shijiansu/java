package tarena.day23_socket;

import java.util.Calendar;

public class TestFormatOutput {
	public static void main(String[] args) {
		double d1 = 2.0;
		double d2 = 1.99;
		double d3 = d1 - d2;
		System.out.println(d3);
		System.out.printf("%1$10.2f", d3, 10.00);
		System.out.println();
		int x = 100;
		System.out.printf("%d\n", x);
		System.out.printf("%o\n", x);
		System.out.printf("%x\n", x);
		Calendar c = Calendar.getInstance();
		System.out.printf("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", c);
	}
}
