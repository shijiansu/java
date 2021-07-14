package tarena.day05_array;

public class Animal {
	String breed;
	int age;

	void eat() {
		System.out.println("动物在吃人");
	}

	void makeNoice(int num) {
		System.out.println("叫了N声");
	}

	public static void main(String[] args) {
		Animal a = new Animal();
		a.eat();
		a.makeNoice(3);
	}
}