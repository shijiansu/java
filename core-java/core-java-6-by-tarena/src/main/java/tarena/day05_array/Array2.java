package tarena.day05_array;

public class Array2 {
	public static void main(String[] args) {

		int[][] a = new int[2][3];

		int[][] b = new int[2][];
		b[0] = new int[3];
		b[1] = new int[3];

		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 3;
		a[1][0] = 4;
		a[1][1] = 5;
		a[1][2] = 6;
		b[0][0] = 1;
		b[0][1] = 2;
		b[0][2] = 3;
		b[1][0] = 4;
		b[1][1] = 5;
		b[1][2] = 6;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(a.length);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("a[0].length=" + a[0].length);
		// int[][][][][] b = new int[2][2][2][2][2];
		System.out.println("============");
		int[][] c = new int[2][];
		c[0] = new int[3];
		c[1] = new int[4];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = i * j;
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
		int[][] d = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 } };
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
		int[][][] e = new int[2][3][3];
		System.out.println(e);
		System.out.println(e[0]);
		System.out.println(e[1]);
		System.out.println(e[0][0]);
		System.out.println(e[0][1]);
		System.out.println(e[0][2]);
		System.out.println(e[1][0]);
		System.out.println(e[1][1]);
		System.out.println(e[1][2]);

	}
}