package tarena.day16_reflection;

import java.util.Date;

public class TestOverride {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Stu s = new Stu(1, "guodh");
		System.out.println(s);
		Date d = new Date();
		d.getYear();
		s.old();
	}
}
