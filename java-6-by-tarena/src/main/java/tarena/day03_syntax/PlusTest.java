package tarena.day03_syntax;

public class PlusTest {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 99; i += 2) {
			sum = sum + i;
		}
		System.out.println("sum=" + sum);
	}
}