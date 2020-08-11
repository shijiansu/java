package tarena.day03_syntax;

public class ForTest {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
		}
		System.out.println();// 打印换行
		int i = 0;
		for (; i < 10; i++) {
			System.out.print(i);
		}
		System.out.println();
		i = 0;
		for (; i < 10;) {
			System.out.print(i);
			i++;
		}
		// 死循环
		/*
		 * for(;;){ System.out.print(i); }
		 */
		// int j=0, k=0, l=0;
		System.out.println();
		System.out.println("========================");
		for (int j = 0, k = 0, l = 0; j < 10 && k < 10 && l < 10; j++, k++, l++, System.out
				.println("j=" + j + ";k=" + k + ";" + "l=" + l))
			;
		System.out.println("=========================");
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				System.out.print(r + "*" + c + "=" + r * c + " ");
			}
			System.out.println();
		}
	}
}