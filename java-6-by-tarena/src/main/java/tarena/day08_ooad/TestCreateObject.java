package tarena.day08_ooad;

@SuppressWarnings("unused")
class Animal{
	private String name;
	private int age = 10;
	private static int counter = 10;
	{
		//System.out.println("又一个初始化代码块被调用");
	}
	{
		System.out.println("Animal被初始化");
	}
	static {
		System.out.println("Animal被加载");
	}
	public Animal(){
		System.out.println("Animal()被调用");
	}
}
class Dog extends Animal{
	{
		System.out.println("Dog被初始化");
	}
	static{
		System.out.println("Dog类被加载");
	}
	public Dog(){
		System.out.println("Dog()被调用");
	}
}

public class TestCreateObject{
    @SuppressWarnings("unused")
	public static void main(String[]args){
		Dog d = new Dog();
		System.out.println("=========================");
		Dog d1 = new Dog();
	}
}