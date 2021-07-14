package tarena.day05_array;

class Dog {
	String name;
	int size;

	// 构造方法
	/*
	 * Dog(){ System.out.println("一个Dog对象被构造"); }
	 */
	Dog(int i) {
		System.out.println("有int型参数的一个Dog对象被构造");
	}

	Dog(String n, int s) {
		System.out.println("Dog(String, int)被调用");
		name = n;
		size = s;
	}
}

public class TestDog {
	public static void main(String[] args) {
		Dog d = new Dog(100);
		Dog d1 = new Dog("haha", 100);
		System.out.println(d.name + ":" + d.size);
		System.out.println(d1.name + ":" + d1.size);
		// Dog d2 = new Dog(); // The constructor Dog() is undefined

	}
}