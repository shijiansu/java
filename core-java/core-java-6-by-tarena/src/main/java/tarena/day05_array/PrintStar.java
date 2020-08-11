package tarena.day05_array;

public class PrintStar {
	public static void main(String[] args) {
		int c = 1;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print("*");
			}
			if (i < 3) {
				c += 2;
			} else {
				c -= 2;
			}
			System.out.println();
		}
	}
}