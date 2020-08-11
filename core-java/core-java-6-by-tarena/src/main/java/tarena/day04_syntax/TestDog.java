package tarena.day04_syntax;

class Dog {
	int size;
	String breed;
	String name;

	void bark(int num) {// 形参
		size++;
		while (num > 0) {
			System.out.println("旺旺~~");
			num--;
		}
	}

	int getSize() {
		size++;
		// 不能访问另外一个方法中的局部变量
		// System.out.println(localVariable);
		return size;
	}

	@SuppressWarnings("unused")
	void show(int x, int y, double z, String name) {
		size++;
		int localVariable = 1000;// 典型的局部变量
		System.out.println(x > y ? name : name + z);
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
		}
		// System.out.println(i);
		if (true) {
			int j = 100;
			j++;
		}
		// System.out.println(j);
		{
			int k = 200;
		}
		// System.out.println(k);
	}
}

public class TestDog {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
		Dog d = new Dog();
		d.size = 40;
		int a = 3;
		d.bark(a);// 实参
		System.out.println(d.getSize());
		int result = d.getSize() + 10;
		int r = d.getSize();
		d.getSize();
		d.show(1, 2, 3, "guodh");
	}
}