package tarena.day03_syntax;

public class DaffodilFlower {
	public static void main(String[] args) {
		int i = 100;
		int a = 1, b = 1, c = 1;
		while (i <= 999) {
			a = i / 100;
			b = i / 10 % 10;
			c = i % 10;
			if (a * a * a + b * b * b + c * c * c == i) {
				System.out.println(i + "是水仙花数");
			}
			i++;
		}
		System.out.println("=========================");
		int r = 0;
		a = 1;
		while (a <= 9) {
			b = 0;
			while (b <= 9) {
				c = 0;
				while (c <= 9) {
					r = a * 100 + b * 10 + c;
					if (r == a * a * a + b * b * b + c * c * c) {
						System.out.println(r + "是水仙花数");
					}
					c++;
				}
				b++;
			}
			a++;
		}
	}
}