package tarena.day14_generic;

public class TestGenericMethod {
	public static <T> void m(T x){
		System.out.println(x.getClass().getName());
	}
	public static <T> void m1(T x, T y){
		System.out.println(x.getClass().getName());
		System.out.println(y.getClass().getName());
	}
	public static void main(String[] args) {
		m("abc");
		m(1);
		System.out.println("=====================");
		TestGenericMethod.<String>m1("abc", "123");
	}
}
