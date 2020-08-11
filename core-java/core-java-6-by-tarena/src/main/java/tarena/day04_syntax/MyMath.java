package tarena.day04_syntax;

public class MyMath {
	int add(int x, int y) {
		return x + y;
	}

	/*
	 * int add(int a, int b){ return a+b; }
	 */
	double add(int x, double y) {
		return x + y;
	}

	double add(double x, int y) {
		return x + y;
	}

	double add(double x, double y, double z) {
		return x + y + z;
	}

	public static void main(String[] args) {
		MyMath mm = new MyMath();
		System.out.println("1+2=" + mm.add(1, 2));
		System.out.println("1+2.2=" + mm.add(1, 2.2));
		System.out.println("1.1+2=" + mm.add(1.1, 2));
		System.out.println("1.1+2+3=" + mm.add(1.1, 2, 3));
	}
}