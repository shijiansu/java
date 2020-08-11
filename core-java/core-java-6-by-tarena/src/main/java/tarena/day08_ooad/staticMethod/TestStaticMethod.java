package tarena.day08_ooad.staticMethod;

class StaticA{
    int i = 10;
    static int s = 20;
	public void m1(){
		System.out.println(i);
		System.out.println(s);
		System.out.println("m1");
	}
	public static void m2(){
		//在静态方法中不能访问非静态成员
		//System.out.println(i);
		//m1();
		//静态方法中可以访问静态成员
		System.out.println(s);
		System.out.println("m2");
	}
	
	public static void show(){
		System.out.println("秀一下父类");
	}
	public static void show(int i){
		System.out.println("秀一下父类int");
	}
	public void show(double d){
		System.out.println("秀一下非静态");
	}
}

class StaticB extends StaticA{
	public static void show(){
		System.out.println("秀一下子类");
	}
}

public class TestStaticMethod{
	/*
	int i = 10;
	void show(){

	}
	*/
    @SuppressWarnings("static-access")
    public static void main(String[]args){
		StaticA a = new StaticA();
		a.m1();
		a.m2();
		//StaticA.m1();
		StaticA.m2();
		System.out.println("===================");
		StaticA a1 = new StaticA();
		StaticB b1 = new StaticB();
		a1.show();
		b1.show();
		StaticA a2 = new StaticB();
		a2.show();
		System.out.println("===================");
		a1.show(3);
    }
}