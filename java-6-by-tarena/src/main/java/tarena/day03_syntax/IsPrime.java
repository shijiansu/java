package tarena.day03_syntax;

import java.util.Scanner;

public class IsPrime {
	@SuppressWarnings("resource")
    public static void main(String[] args) {
		System.out.print("请输入一个2以上的整数：");
		int num = new Scanner(System.in).nextInt();
		if (num < 2) {
			System.out.println("这个数不能小于2");
			return;
		}
		int numSqrt = (int) Math.sqrt(num) + 1;
		boolean flag = true;
		for (int i = 2; i <= numSqrt; i++) {
			if (num % i == 0) {
				System.out.println(i);
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println(num + "是一个素数");
		} else {
			System.out.println(num + "不是一个素数");
		}
		System.out.println(num + "" + (flag ? "是" : "不是") + "一个素数");
		
	}
}