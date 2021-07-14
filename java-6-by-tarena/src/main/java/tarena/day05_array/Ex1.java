package tarena.day05_array;

import java.util.Scanner;

/**
 * 计算a+aa+aaa+aaaa+aaaaa+.....的值
 */
public class Ex1 {
	public static void main(String[] args) {
		System.out.println("计算a+aa+aaa+aaaa+aaaaa+.....的值");
		Scanner s = new Scanner(System.in);
		int num;// a的值
		int count;// 项数
		int sum = 0;// 和
		System.out.print("请输入一个数：");
		num = s.nextInt();
		System.out.print("请输入项数数：");
		count = s.nextInt();
		for (int i = 1; i <= count; i++) {
			// 产生第i项的一个数
			int iVal = num;// 第i个值
			for (int j = 1; j < i; j++) {
				iVal = iVal * 10 + num;
			}
			// 将这个数加入到总和中
			sum += iVal;
		}
		System.out.println("和为： " + sum);
		s.close();
	}
}