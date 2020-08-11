package tarena.day03_syntax;

public class Table99 {
	public static void main(String[] args) {
		// i为行号，j为列号
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + " ");
			}
			System.out.println();
		}
	}
}