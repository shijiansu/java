package tarena.day11_inner_class.inner.staticc;

public class TestStaticInnerClass{
    public static void main(String[]args){
		Outer.Inner inner = new Outer.Inner();
		inner.show();
		System.out.println(Outer.Inner.s2);
    }
}

class Outer{
	private int i1 = 10;
	static int s1 = 100;
	//静态内部类(嵌套内部类),地位上相当于静态成员
	static class Inner{
		private int i2 = 20;
		/*private*/ static int s2 = 200;
		public void show(){
			System.out.println(i2);
			System.out.println(s2);
			//在静态内部类中，不能访问外部类的非静态成员
			//System.out.println(i1);
			System.out.println(s1);
			Outer outer = new Outer();
			System.out.println(outer.i1);
		}
	}
}