package tarena.day03_syntax;

public class SwitchTest {
	public static void main(String[] args) {
		double d = Math.random();
		int i = (int) (d * 10);
		switch (i) {
		case 0:
			System.out.println("i==0");
			break;
		case 1:
			System.out.println("i==1");
			break;
		case 2:
			System.out.println("i==2");
			break;
		case 3:
			System.out.println("i==3");
			break;
		default:
			System.out.println("i!=0,1,2,3");
			break;
		}
		System.out.println("=======================");
		// char c = 'A' + i;//can not convert int to char
		int c = 'A' + i;
		switch (c) {
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		}
	}
}