package tarena.day02_syntax;

public class DataType {
	@SuppressWarnings("unused")
    public static void main(String[] args) {
		byte b;
		b = 10;// 初始化
		System.out.println(b);
		b = 100;// 赋值
		System.out.println(b);
		// b = 128;//Error
		short s = 100;// 初始化变量
		System.out.println(s);
		// s = 32768;//Error
		int i = 200;
		// i = 2147483648L;//ERROR
		long l = 2147483648L;
		System.out.println("==========================");
		i = 017;
		System.out.println(i);
		i = 0x55;
		System.out.println(i);
		System.out.println("======================");

		float f = 3.14f;
		System.out.println(f);

		double d = 3.14;
		System.out.println(d);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		// f = 12.5E300F;//Error
		char c;
		c = 'A';
		System.out.println(c);
		c = '中';
		System.out.println(c);
		// int 中国 = 1000;
		// System.out.println(中国);
		c = '\u0041';
		c = 0x41;
		System.out.println(c);
		c = 65;
		System.out.println(c);
		c = '\'';
		System.out.println(c);
		c = '\101';
		c = '\u0041';
		System.out.println(c);
		System.out.println("==================");
		boolean b1 = true;
		b1 = 20 > 100;
		System.out.println(b1);
	}
}