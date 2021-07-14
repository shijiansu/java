package tarena.day11_inner_class.inner.member;

public class TestMemberInnerClass{
    public static void main(String[]args){
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.show();
		System.out.println("===================");
		outer.show();
    }
}

class Outer{
	private int i1 = 10;//实例变量
	private int i2 = 200;
	private static int s1 = 100;
	//成员内部类(实例内部类)，地位相当于实例变量
	public void outerMethod(){
		System.out.println("outerMethod");
	}
	public void show(){
		Inner inner = new Inner();
		System.out.println(inner.i2);
		inner.show();
		@SuppressWarnings("unused")
		Inner inner1 = new Inner();
	}
	class Inner{
		private int i2 = 20;
		//public static int s2 = 200;
		public void show(){
			System.out.println(i1);
			System.out.println(this.i2);
			System.out.println(s1);
			outerMethod();
			System.out.println(Outer.this.i2);
		}
	}
}