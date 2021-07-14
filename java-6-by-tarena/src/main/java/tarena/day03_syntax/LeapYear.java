package tarena.day03_syntax;

import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);// 创建一个键盘扫描器
		System.out.print("请输入年份:");// 提示用户输入
		int year = s.nextInt();// 从键盘上读取一个整数保存到变量year中
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			System.out.println(year + "是闰年");
		} else {
			System.out.println(year + "不是闰年");
		}
		s.close();
	}
}