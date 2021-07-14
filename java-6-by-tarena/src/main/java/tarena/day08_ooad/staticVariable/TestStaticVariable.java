package tarena.day08_ooad.staticVariable;

class StaticA{
    int i = 10;
    static int s = 20;
}

public class TestStaticVariable{
	public static int global = 100;//类似全局变量
    @SuppressWarnings("static-access")
    public static void main(String[]args){
		StaticA a = new StaticA();
		StaticA b = new StaticA();
		a.i++;
		a.s++;
		StaticA.s += 10;
		System.out.println("a.i="+a.i);
		System.out.println("a.s="+a.s);
		System.out.println("b.i="+b.i);
		System.out.println("b.s="+b.s);
		System.out.println("StaticA.s="+StaticA.s);
    }
}