package tarena.day03_syntax;

public class BreakTest {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
			if (i > 5) {
				break;
			}
		}
		System.out.println("=====================");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(i + "*" + j + "=" + i * j + " ");
				if (i * j > 30) {
					break;
				}
			}
			System.out.println();
		}
	}
}