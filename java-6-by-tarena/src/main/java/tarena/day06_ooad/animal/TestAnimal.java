package tarena.day06_ooad.animal;
@SuppressWarnings("unused")
class Animal {
	private String name;
	private int age;
	private int helf;

	public Animal(String name, int age, int helf) {
		this.name = name;
		this.age = age;
		this.helf = helf;
	}

	public void eat() {
		System.out.println("动物吃");
	}

	public void sleep() {
		System.out.println("动物睡");
	}

	public void makeNoise() {
		System.out.println("动物叫");
	}

	public void roam() {
		System.out.println("动物散步");
	}
}

class Feline extends Animal {
	public Feline(String name, int age, int helf) {
		super(name, age, helf);
	}

	public void roam() {
		System.out.println("动物走猫步");
	}
}

class Tiger extends Feline {
	public Tiger(String name, int age, int helf) {
		super(name, age, helf);
	}

	public void eat() {
		System.out.println("老虎吃人");
	}

	public void makeNoise() {
		System.out.println("老虎在咆哮");
	}
}

class Cat extends Feline {
	public Cat(String name, int age, int helf) {
		super(name, age, helf);
	}

	public void eat() {
		System.out.println("猫吃老鼠");
	}

	public void makeNoise() {
		System.out.println("猫在喵喵叫");
	}
}

class Lion extends Feline {
	public Lion(String name, int age, int helf) {
		super(name, age, helf);
	}

	public void eat() {
		System.out.println("狮子吃动物");
	}

	public void makeNoise() {
		System.out.println("狮子在怒吼");
	}
}

class Caline extends Animal {
	public Caline(String name, int age, int helf) {
		super(name, age, helf);
	}

	public void roam() {
		System.out.println("犬科动物在奔跑");
	}
}

class Dog extends Caline {
	public Dog(String name, int age, int helf) {
		super(name, age, helf);
	}

	public void eat() {
		System.out.println("狗吃骨头");
	}

	public void makeNoise() {
		System.out.println("狗旺旺叫");
	}
}

class Wolf extends Caline {
	public Wolf(String name, int age, int helf) {
		super(name, age, helf);
	}

	public void eat() {
		System.out.println("狼吃羊");
	}

	public void makeNoise() {
		System.out.println("狼嚎叫");
	}
}

class Hippo extends Animal {
	public Hippo(String name, int age, int helf) {
		super(name, age, helf);
	}

	public void eat() {
		System.out.println("河马吃草");
	}

	public void makeNoise() {
		System.out.println("河马哞哞~~~");
	}
}

public class TestAnimal {
	public static void main(String[] args) {
		Dog d = new Dog("dog", 3, 30);
		Wolf w = new Wolf("wolf", 5, 25);
		Cat c = new Cat("cat", 2, 8);
		Tiger t = new Tiger("tiger", 5, 260);
		Lion l = new Lion("loin", 8, 240);
		Hippo h = new Hippo("hippo", 10, 400);
		d.eat();
		d.sleep();
		d.roam();
		d.makeNoise();
		w.eat();
		w.sleep();
		w.roam();
		w.makeNoise();
		c.eat();
		c.sleep();
		c.roam();
		c.makeNoise();
		t.eat();
		t.sleep();
		t.roam();
		t.makeNoise();
		l.eat();
		l.sleep();
		l.roam();
		l.makeNoise();
		h.eat();
		h.sleep();
		h.roam();
		h.makeNoise();
	}
}
