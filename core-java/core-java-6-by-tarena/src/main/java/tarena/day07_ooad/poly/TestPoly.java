package tarena.day07_ooad.poly;

class Animal {
    @SuppressWarnings("unused")
	private String name;
    @SuppressWarnings("unused")
	private int age;

	public void eat() {
		System.out.println("动物吃");
	}

	public void sleep() {
		System.out.println("动物睡");
	}
}

class Dog extends Animal {
	public void eat() {
		System.out.println("狗吃。。");
	}

	public void watchHome() {
		System.out.println("狗在看家");
	}
}

class Cat extends Animal {
	public void eat() {
		System.out.println("猫吃。。。");
	}

	public void catchMouse() {
		System.out.println("猫捉老鼠");
	}
}

public class TestPoly {
	/*
	 * 方法参数上的多态 一个方法的参数可以接收多种不同类型的对象
	 */
	public static void feed(Animal a) {
		a.eat();
	}

	/*
	 * 方法返回类型上的多态， 一个方法可以返回多种不同类型的对象
	 */
	public static Animal getAnimal(int i) {
		if (i == 0) {
			return new Dog();
		} else if (i == 1) {
			return new Cat();
		} else {
			return new Animal();
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Dog d = new Dog();
		Animal a = new Dog();
		a.sleep();
		a.eat();
		d.watchHome();
		// a.watchHome();
		Animal a1 = new Cat();
		a1.eat();
		a1.sleep();
		// a1.catchMouse();
		System.out.println("====================");
		Dog d1 = new Dog();
		Cat c1 = new Cat();
		Animal an = new Animal();
		feed(an);
		feed(d1);// Animal an = d1;
		feed(c1);
		Animal a2 = getAnimal(0);
		Dog d2 = (Dog) a2;
		d2.watchHome();
		// Dog d3 = (Dog)c1;
		Animal a3 = new Cat();
		if (a3 instanceof Dog) {
			Dog d4 = (Dog) a3;
		} else {
			System.out.println("NO");
		}
	}
}