package tarena.day05_array;

public class TestArraycopy {
	public static void main(String[] args) {
		int[] a = new int[10];
		a[0] = 1;
		a[2] = 2;
		a[3] = 3;
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		int[] b = new int[20];
		System.arraycopy(a, 0, b, 5, 4);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}
}