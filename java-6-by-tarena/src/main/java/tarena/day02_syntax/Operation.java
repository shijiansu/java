package tarena.day02_syntax;

public class Operation {
	@SuppressWarnings("unused")
    public static void main(String[] args) {
		int i = 1 + 1;
		System.out.println(i);
		int a = 10;
		int b = 20;
		i = a + b;
		System.out.println(a + "+" + b + "=" + i);
		i = a - b;
		System.out.println(a + "-" + b + "=" + i);
		i = a * b;
		System.out.println(a + "*" + b + "=" + i);
		double d = (double) a / b;
		d = a * 1.0 / b;
		System.out.println(a + "/" + b + "=" + d);

		byte b1 = 10;
		byte b2 = 20;
		byte b3 = 10 + 20;
		// byte b4 = b1 + b2;//Error
		int i4 = b1 + b2;
		a = 5;
		b = 3;
		System.out.println(a + "%" + b + "=" + a % b);
		System.out.println("-5.1%-3=" + ((-5.1) % (-3)));

		a = 10;
		a += 10;// a = a + 10;
		System.out.println("a+=10:" + a);

		byte b10 = 10;
		// b10 = b10 + 20;
		b10 += 20;
		System.out.println(b10);
		b10 = 127;
		b10 += 10;
		System.out.println(b10);
		System.out.println("=====================");
		a = 10;
		b = 20;
		boolean bool = a != b;
		System.out.println(bool);

	}
}