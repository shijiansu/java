package tarena.day02_syntax;

public class Operation1 {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
		int a = 30;
		int b = 20;
		int c = 10;
		int d = 5;
		boolean bool = a > b & c < d;
		System.out.println(bool);
		bool = a > b | c < d;
		System.out.println(bool);
		bool = !(a > b);
		System.out.println(bool);
		bool = a > b && b > c && c > d;
		bool = a > b || b > c || c > d;
		System.out.println("====================");
		bool = a < b && b++ > c && c++ > d;
		System.out.println("bool=" + bool);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		bool = a < b & b++ > c && c++ > d;
		System.out.println("bool=" + bool);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println("======================");
		System.out.println("~79=" + (~79));
		System.out.println("~-100=" + (~-100));
		System.out.println("~-1=" + (~-1));
		System.out.println("~100=" + (~100));
		System.out.println("45&79=" + (45 & 79));
		System.out.println("45|79=" + (45 | 79));
		System.out.println("45^79=" + (45 ^ 79));
		byte b1 = 1;
		byte b2 = 2;
		// byte b3 = b1&b2;//Error
		System.out.println("-45>>2=" + (-45 >> 2));
		System.out.println("-32>>2=" + (-32 >> 2));
		System.out.println("-32>>>2=" + (-32 >>> 2));
		System.out.println("-12>>>2=" + (-12 >>> 2));

	}
}