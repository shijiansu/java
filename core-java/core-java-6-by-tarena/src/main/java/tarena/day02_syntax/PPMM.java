package tarena.day02_syntax;

public class PPMM {
	public static void main(String[] args) {
		double d = Math.random();// [0,1)
		int i = (int) (d * 100);
		System.out.println("i=" + i);
		System.out.println("++i=" + (++i));
		System.out.println("i++=" + (i++));
		System.out.println("i=" + i);
		System.out.println("--i=" + (--i));
		System.out.println("i--=" + (i--));
		System.out.println("i=" + i);
		i = 100;
		System.out.println(i++ + ++i);
		System.out.println(i);
	}
}