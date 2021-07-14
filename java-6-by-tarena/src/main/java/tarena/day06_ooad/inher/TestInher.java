package tarena.day06_ooad.inher;

class Animal extends Object {
	String name;

	/*
	 * Animal(){ System.out.println("Animal的空参构造方法被调用"); }
	 */
	Animal(String name) {
		super();
		this.name = name;
		System.out.println("Animal(String)构造方法被调用");
	}

	void eat() {
		System.out.println(name + "在吃东西！");
	}

	void sleep() {
		System.out.println(name + "在睡觉！");
	}

	void walk() {
		System.out.println(name + "在散步！");
	}

	void makeNoice() {
		System.out.println(name + "在叫！");
	}
}

class Dog extends Animal {
	String name;

	Dog() {
		this("haha");
	}

	Dog(String name) {
		super(name);
		System.out.println("Dog的空参构造方法被调用");
	}

	void eat() {
		System.out.println(super.name + "狗吃骨头");
		super.eat();
	}

	void makeNoice() {
		System.out.println(name + "Wang~~Wang~~Wang~~~");
	}
}

class Cat extends Animal {
	Cat() {
		super("加菲");
		System.out.println("Cat的空参构造方法被调用");
	}

	void eat() {
		System.out.println("猫吃鱼");
	}

	void makeNoice() {
		System.out.println(name + "喵~~喵~~~~");
	}
}

public class TestInher {
	public static void main(String[] args) {
		// Animal a = new Animal();
		Dog d = new Dog("哈士奇");
		String str = d.toString();
		System.out.println(str);
		d.eat();
		/*
		 * a.name = "小强"; System.out.println(a.name); a.eat(); Dog d = new
		 * Dog(); d.name = "旺财"; System.out.println(d.name); d.eat();
		 * d.makeNoice(); Cat c = new Cat(); c.name = "加菲";
		 * System.out.println(c.name); c.eat(); c.makeNoice();
		 */
	}
}