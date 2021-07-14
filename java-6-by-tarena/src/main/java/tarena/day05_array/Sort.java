package tarena.day05_array;

public class Sort {
	public static void main(String[] args) {
		int[] a = { 1, 2, 0, 3, 5, 4, 6, 9, 8, 7 };

		// Arrays.sort(a);
		for (int i = a.length - 1; i >= 0; i--) {
			boolean flag = true;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}
}