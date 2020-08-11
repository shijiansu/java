package tarena.day05_array;

import java.util.Scanner;

public class Prime {
	public static void main(String[] args) {
		System.out.print("请输入一个值：");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		for (int i = 2; i <= num; i++) {
			boolean flag = true;
			for (int j = 2; j <= ((int) Math.sqrt(i) + 1); j++) {
				if (i % j == 0) {
					flag = false;
				}
			}
			if (flag) {
				System.out.println(i);
			}
		}
		s.close();
	}
}