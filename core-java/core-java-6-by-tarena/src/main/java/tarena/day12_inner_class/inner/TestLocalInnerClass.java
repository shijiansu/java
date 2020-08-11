package tarena.day12_inner_class.inner;

public class TestLocalInnerClass {
	private int i3 = 30;
	private static int s2 = 200;
	@SuppressWarnings("unused")
	public void show(){
		int i1 = 10;
		final int i4 = 40;
		class LocalClass{
			private int i2 = 20;
			//不能定义静态变量
			//private static int s1 = 100;
			public void show(){
				System.out.println(i2);
				//System.out.println(i1);
				System.out.println(i4);
				System.out.println(i3);
				System.out.println(s2);
			}
		}
        class Child extends LocalClass{}
		LocalClass lc = new LocalClass();
		lc.show();
	}
	public static void main(String[] args) {
		TestLocalInnerClass t = new TestLocalInnerClass();
		t.show();
	}
}
