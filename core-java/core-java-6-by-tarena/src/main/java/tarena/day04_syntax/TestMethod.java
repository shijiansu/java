package tarena.day04_syntax;

class A {
	void m1(int x) {
		x++;
		System.out.println("in A x=" + x);
	}

	void m2(Dog d) {
		d.size++;
		System.out.println("in A d.size=" + d.size);
	}

	void swap(Dog d1, Dog d2) {
		Dog d = d1;
		d1 = d2;
		d2 = d;
	}

	void m3(Dog d) {
		d = new Dog();
		d.size = 100;
		System.out.println("in A m3() d.size=" + d.size);
	}
}

public class TestMethod {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
		A a = new A();
		Dog d = new Dog();
		d.size = 10;
		// a.m2(d);
		a.m3(d);
		System.out.println("in main d.size=" + d.size);
		Dog d10 = null;
		// a.m3(d10);
		// System.out.println(d10.size);//Error,空指针
		int x = 10;
		a.m1(x);
		System.out.println("in main x=" + x);
		Dog d1 = new Dog();
		Dog d2 = new Dog();
		d1.size = 10;
		d2.size = 20;
		a.swap(d1, d2);
		System.out.println(d1.size);
		System.out.println(d2.size);
	}
}