package tarena.day08_ooad.classLoader;

class StaticA{
	public static int s1 = 100;
	public static final double PI = 3.14;
	public static final double OTHER = Math.random()*1000;
	static{
		System.out.println("StaticA类被加载");
	}
}

class StaticB extends StaticA{
	static int s2 = 200;
	static{
		System.out.println("StaticB类被加载");
	}
}

public class TestClassLoader{
    @SuppressWarnings("unused")
    public static void main(String[]args){
		//StaticA a = new StaticA();
		//System.out.println(StaticA.s1);
		StaticA a;//声明一个引用变量
		//System.out.println(StaticB.s2);
		//System.out.println(StaticB.s1);
		System.out.println(StaticA.PI);
		System.out.println(StaticA.OTHER);

    }
}