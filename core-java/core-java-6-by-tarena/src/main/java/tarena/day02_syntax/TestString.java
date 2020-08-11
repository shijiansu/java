package tarena.day02_syntax;

public class TestString {
	public static void main(String[] args) {
		String str = "abc";
		System.out.println(str);
		int a = 10;
		int b = 20;
		str = str + a + b;
		System.out.println(str);
		System.out.println("abc" + "10" + "20");
		str = 10 + 20 + str;
		System.out.println(str);// 30abc1020
		System.out.println("abc\ndef");
		System.out.println("abcdef\rhij");
		System.out.println("abc\bdef");
		System.out.println("\'\\\"");
		System.out.println("\\\\\\");

	}
}