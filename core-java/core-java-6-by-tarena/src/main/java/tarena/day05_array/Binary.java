package tarena.day05_array;

import java.util.Scanner;

/**
 * 把一个整数的二进制形式打印出来
 */
public class Binary {
	public static void main(String[] args) {
		System.out.println("把一个整数的二进制形式打印出来");
		System.out.print("请输入一个数:");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		System.out.print("二进制为：");
		int tmp = num;
		for (int i = 0; i < 32; i++) {
			if (tmp >= 0) {
				System.out.print("0");
			} else {
				System.out.print("1");
			}
			tmp = tmp << 1;
		}
		System.out.print("\n正确的是：" + Integer.toBinaryString(num));
		System.out.print("\n倒序为：");
		tmp = num;
		for (int i = 0; i < 32; i++) {
			if ((tmp & 1) == 1) {
				System.out.print("1");
			} else {
				System.out.print("0");
			}
			tmp = tmp >> 1;
		}
		s.close();
	}
}