package tarena.day04_syntax;

public class Overload {
	static void f() {
		System.out.println("空参");
	}

	static void f(byte b) {
		System.out.println("byte");
	}

	static void f(short b) {
		System.out.println("short");
	}

	static void f(int b) {
		System.out.println("int");
	}

	static void f(long b) {
		System.out.println("long");
	}

	static void f(float b) {
		System.out.println("float");
	}

	static void f(double b) {
		System.out.println("double");
	}

	static void f(char b) {
		System.out.println("char");
	}

	static void f1(short b) {
		System.out.println("short");
	}

	static void f1(int b) {
		System.out.println("int");
	}

	static void f1(long b) {
		System.out.println("long");
	}

	static void f1(float b) {
		System.out.println("float");
	}

	static void f1(double b) {
		System.out.println("double");
	}

	static void f1(char b) {
		System.out.println("char");
	}

	static void f2(int b) {
		System.out.println("int");
	}

	static void f2(long b) {
		System.out.println("long");
	}

	static void f2(float b) {
		System.out.println("float");
	}

	static void f2(double b) {
		System.out.println("double");
	}

	static void f2(char b) {
		System.out.println("char");
	}

	static void f3(long b) {
		System.out.println("long");
	}

	static void f3(float b) {
		System.out.println("float");
	}

	static void f3(double b) {
		System.out.println("double");
	}

	static void f3(char b) {
		System.out.println("char");
	}

	static void f4(int i) {
		System.out.println("int");
	}

	static void f4(long b) {
		System.out.println("long");
	}

	static void f4(float b) {
		System.out.println("float");
	}

	static void f4(double b) {
		System.out.println("double");
	}

	static void f5(float b) {
		System.out.println("float");
	}

	static void f5(double b) {
		System.out.println("double");
	}

	static void f6(double b) {
		System.out.println("double");
	}

	static void f7(boolean b) {
		System.out.println("boolean");
	}

	public static void main(String[] args) {
		byte b = 10;
		short s = 20;
		int i = 30;
		long l = 40;
		float f = 5.12f;
		double d = 6.34;
		char c = 'A';
		f();
		f(b);
		f(s);
		f(i);
		f(l);
		f(f);
		f(d);
		f(c);
		System.out.println("=============================");
		f1(b);
		f1(s);
		f1(i);
		f1(l);
		f1(f);
		f1(d);
		f1(c);
		System.out.println("=============================");
		f2(b);
		f2(s);
		f2(i);
		f2(l);
		f2(f);
		f2(d);
		f2(c);
		System.out.println("=============================");
		f3(b);
		f3(s);
		f3(i);
		f3(l);
		f3(f);
		f3(d);
		f3(c);
		System.out.println("=============================");
		f4(b);
		f4(s);
		f4(i);
		f4(l);
		f4(f);
		f4(d);
		f4(c);
		System.out.println("=============================");
		f5(b);
		f5(s);
		f5(i);
		f5(l);
		f5(f);
		f5(d);
		f5(c);
		System.out.println("=============================");
		f6(b);
		f6(s);
		f6(i);
		f6(l);
		f6(f);
		f6(d);
		f6(c);
		// f7(b);
	}
}