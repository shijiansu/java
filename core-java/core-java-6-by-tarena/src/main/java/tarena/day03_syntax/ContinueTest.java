package tarena.day03_syntax;

public class ContinueTest {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.print(i);
		}
		System.out.println();
		int i = 0;
		while (i < 10) {
			if (i == 5) {
				i++;
				continue;
			}
			System.out.print(i);
			i++;
		}
	}
}