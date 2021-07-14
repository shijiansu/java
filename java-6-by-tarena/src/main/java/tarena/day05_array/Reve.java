package tarena.day05_array;

public class Reve {
	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < a.length / 2; i++) {
			int tmp = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = tmp;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}