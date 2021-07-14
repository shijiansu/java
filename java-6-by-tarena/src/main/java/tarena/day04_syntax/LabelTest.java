package tarena.day04_syntax;

public class LabelTest {
	public static void main(String[] args) {
		hello: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i * j >= 20) {
					break hello;
				}
				System.out.print(i + "*" + j + "=" + i * j + " ");
			}
			System.out.println();
		}
		System.out.println("==========================");
		hello1: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i * j >= 20) {
					continue hello1;
				}
				System.out.print(i + "*" + j + "=" + i * j + " ");
			}
			System.out.println();
		}
	}
}