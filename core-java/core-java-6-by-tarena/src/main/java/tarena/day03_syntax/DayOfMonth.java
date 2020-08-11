package tarena.day03_syntax;

import java.util.Scanner;

public class DayOfMonth {
	public static void main(String[] args) {
		int year, month;// 声明(定义)两个int型的变量，不建议这样做
		// 提示用户输入
		Scanner s = new Scanner(System.in);
		System.out.print("请输入年份：");
		// 保存用户输入的值
		year = s.nextInt();

		System.out.print("请输入月份：");
		month = s.nextInt();

		// 判断输入的有效性
		if (year <= 0 || year >= 3000 || month <= 0 || month >= 13) {
			System.out.println("您输入的年份或月份错误，程序将退出！");
			// return;
			System.exit(0);// 强制退出JVM
		}

		// 以下是天数的判断
		int day = 31;
		switch (month) {
		case 2:
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				day = 29;
			} else {
				day = 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
		}
		System.out.println(year + "年" + month + "月有" + day + "天");
		s.close();
	}
}