package tarena.day05_array;

import java.util.Random;

public class ArrayEx1 {
	public static void main(String[] args) {
		int[] a = new int[10];
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(100);
			System.out.print(a[i] + " ");
		}
		int max = a[0];// 不能直接给0
		int min = a[0];// 不能直接给0
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
			if (a[i] < min) {
				min = a[i];
			}
			sum += a[i];
		}
		avg = sum * 1.0 / a.length;
		System.out.println("\nmax=" + max);
		System.out.println("min=" + min);
		System.out.println("sum=" + sum);
		System.out.println("avg=" + avg);
		int tmp = a[0];
		for (int i = 0; i < a.length - 1; i++) {
			a[i] = a[i + 1];
		}
		a[a.length - 1] = tmp;
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}