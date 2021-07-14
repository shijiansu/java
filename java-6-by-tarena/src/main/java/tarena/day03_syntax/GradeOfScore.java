package tarena.day03_syntax;

import java.util.Random;

public class GradeOfScore {
	public static void main(String[] args) {
		Random r = new Random();// 产生一个随机数对象
		int score = r.nextInt(101);// 产生一个[0,100]的一个随机整数
		System.out.println("Score:" + score);
		char grade;
		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 60) {
			grade = 'D';
		} else {
			grade = 'E';
		}
		System.out.println("成绩的级别为:" + grade);
		System.out.println("============================");
		switch (score / 10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'E';
		}
		System.out.println("成绩的级别为:" + grade);
	}
}